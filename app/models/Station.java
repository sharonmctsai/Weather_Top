package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model {
  public String title;
  public double latitude;
  public double longitude;

  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();

  public Station(String title, double latitude, double longitude) {
    this.title = title;
    this.latitude= latitude;
    this.longitude= longitude;
  }
  public String getLatitude() {
    return String.format("%.3f",latitude);
  }

  public String getLongitude() {
    return String.format("%.3f", longitude);
  }



}

