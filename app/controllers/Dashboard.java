package controllers;

import models.Member;
import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends Controller {
  public static void index() {
    Logger.info("Rendering Dashboard");

    List<Station> stations = Station.findAll();
    List<Station> readings = Reading.findAll();

    render("dashboard.html", stations);
  }


  public static void addStation(String title, double latitude, double longitude) {
    Station station = new Station(title, latitude, longitude);
    Logger.info("Adding a new station called " + station);
    station.save();
    redirect("/dashboard");
  }
  public static void deleteStation(Long id)
  {
    Station station = Station.findById(id);
    Logger.info ("Removing" + station.title);
    station.delete();
    redirect ("/dashboard");
  }
}

