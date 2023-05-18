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

  public int getMaxPressure() {
    int maxPressure = Integer.MIN_VALUE;

    for (Reading reading : readings) {
      int pressure = reading.getPressure();
      if (pressure > maxPressure) {
        maxPressure = pressure;
      }
    }

    return maxPressure;
  }

  public int getMinPressure() {
    int minPressure = Integer.MAX_VALUE;

    for (Reading reading : readings) {
      int pressure = reading.getPressure();
      if (pressure < minPressure) {
        minPressure = pressure;
      }
    }

    return minPressure;
  }
  public double getMaxTemperature() {
    double maxTemperature = Double.MIN_VALUE;

    for (Reading reading : readings) {
      double temperature = reading.getWeatherTemp();
      if (temperature > maxTemperature) {
        maxTemperature = temperature;
      }
    }

    return maxTemperature;
  }

  public double getMinTemperature() {
    double minTemperature = Double.MAX_VALUE;

    for (Reading reading : readings) {
      double temperature = reading.getWeatherTemp();
      if (temperature < minTemperature) {
        minTemperature = temperature;
      }
    }

    return minTemperature;
  }

  public double getMaxWindChill() {
    double maxWindChill = Double.MIN_VALUE;

    for (Reading reading : readings) {
      double windChill = reading.getWindChill();
      if (windChill > maxWindChill) {
        maxWindChill = windChill;
      }
    }

    return maxWindChill;
  }

  public double getMinWindChill() {
    double minWindChill = Double.MAX_VALUE;

    for (Reading reading : readings) {
      double windChill = reading.getWindChill();
      if (windChill < minWindChill) {
        minWindChill = windChill;
      }
    }

    return minWindChill;
  }


}

