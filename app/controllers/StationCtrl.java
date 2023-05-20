package controllers;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class StationCtrl extends Controller
{
  public static void index(Long id)
  {
    Station station = Station.findById(id);
    Logger.info ("Station id = " + id);
    render("station.html", station);
  }

  public static void addReading(Long id, int code, double temperature, double windSpeed, int windDirection, int pressure)
  {
    String date = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss").format(LocalDateTime.now(ZoneOffset.UTC));
    Reading reading = new Reading (date,code,temperature,windSpeed,windDirection, pressure);
    Station station = Station.findById(id);
    station.readings.add(reading);
    station.save();
    redirect ("/stations/" + id);
  }
  public static void deletereading(Long id ,Long readingid)
  {
    Station station = Station.findById(id);
    Reading reading = Reading.findById(readingid);
    Logger.info ("Removing " + reading);
    station.readings.remove(reading);
    station.save();
    reading.delete();
    render("station.html", station);
  }

}

