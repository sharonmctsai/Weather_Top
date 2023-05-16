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
    Member member = Accounts.getLoggedInMember();
    List<Station> station = member.station;

    List<Station> stations = Station.findAll();
    List<Station> readings = Reading.findAll();

    render("dashboard.html", member, stations);
  }


  public static void addStation(String title, double latitude, double longitude) {
    Member member = Accounts.getLoggedInMember();
    Station station = new Station(title, latitude, longitude);
    member.station.add(station);
    member.save();
    Logger.info("Adding a new station called " + title);
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

