package controllers;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class StationCtrl extends Controller
{
  public static void index(Long id)
  {
    Station station = Station.findById(id);
    Logger.info ("Station id = " + id);
    render("station.html", station);
  }

  public static void addReading(Long id, String dateString, int code, double temperature, double windSpeed, int windDirection, int pressure)
  {
    System.out.printf("%d %f\n", code, temperature);
    Reading reading = new Reading (dateString,code,temperature,windSpeed,windDirection, pressure);
    Station station = Station.findById(id);
    station.readings.add(reading);
    station.save();
    redirect ("/stations/" + id);
  }
  public static void deleteReading(Long id)
  {
    Station station = Station.findById(id);
    Reading reading = Reading.findById(id);
    Logger.info ("Removing " + reading);

    render("station.html", station);
  }

}

