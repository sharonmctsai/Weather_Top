package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static utilities.Conversions.CelsiusToFarenheit;



@Entity
public class Reading extends Model {
  public String date;
  public int code;
  public double temperature;
  public double windSpeed;
  public int windDirection;
  public int pressure;

  public Reading(String date, int code, double temperature, double windSpeed, int windDirection, int pressure) {
    this.date =date;
    this.code = code;
    this.temperature = temperature;
    this.windSpeed = windSpeed;
    this.windDirection = windDirection;
    this.pressure = pressure;
  }



  public String getFormattedDate() {
    String formattedDate = this.date;
    LocalDateTime dateTime = LocalDateTime.parse(formattedDate, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return dateTime.format(formatter);
  }


  public double getWindChill() {
    double windChill = 13.12 + 0.6215 * this.temperature - 11.37 * Math.pow(this.windSpeed, 0.16)
        + 0.3965 * this.temperature * Math.pow(this.windSpeed, 0.16);
    return Math.round(windChill * 100.0) / 100.0;
  }

  String getWeatherCode() {
    switch (this.code) {
      case 100:
        return "Clear";
      case 200:
        return "Partial clouds";
      case 300:
        return "Cloudy";
      case 400:
        return "Light Showers";
      case 500:
        return "Heavy Showers";
      case 600:
        return "Rain";
      case 700:
        return "Snow";
      case 800:
        return "Thunder";
      default:
        return " ";
    }
  }
  public String getWeatherIcon() {
    switch (this.code) {
      case 100:
        return "/public/images/sun.png";
      case 200:
        return "/public/images/partialclouds.png";
      case 300:
        return "/public/images/cloudy.png";
      case 400:
        return "/public/images/lightshower.png";
        case 500:
          return "/public/images/heavyshower.png";
      case 600:
        return "/public/images/rains.png";
      case 700:
        return "/public/images/snow.png";
      case 800:
        return "/public/images/thunder.png";
      default:
        return "/public/images/weather.png";
    }
  }


  String getWindDirection() {
    if (windDirection >= 11 && windDirection <= 33) {
      return "NNE";
    } else if (windDirection >= 34 && windDirection <= 55) {
      return "NE";
    } else if (windDirection >= 56 && windDirection <= 77) {
      return "ENE";
    } else if (windDirection >= 78 && windDirection <= 100) {
      return "E";
    } else if (windDirection >= 101 && windDirection <= 122) {
      return "ESE";
    } else if (windDirection >= 123 && windDirection <= 145) {
      return "SE";
    } else if (windDirection >= 146 && windDirection <= 167) {
      return "SSE";
    } else if (windDirection >= 168 && windDirection <= 190) {
      return "S";
    } else if (windDirection >= 191 && windDirection <= 212) {
      return "SSW";
    } else if (windDirection >= 213 && windDirection <= 235) {
      return "SW";
    } else if (windDirection >= 236 && windDirection <= 257) {
      return "WSW";
    } else if (windDirection >= 258 && windDirection <= 280) {
      return "W";
    } else if (windDirection >= 281 && windDirection <= 303) {
      return "WNW";
    } else if (windDirection >= 304 && windDirection <= 325) {
      return "NW";
    } else if (windDirection >= 326 && windDirection <= 347) {
      return "NNW";
    } else if (windDirection >= 348) {
      return "N";
    } else if (windDirection <= 11) {
      return "N";
    } else {
      return "";
    }
  }


  public double getWeatherTemp() {
    return this.temperature;

  }

  public double getFahrenheit() {
    return CelsiusToFarenheit(this.temperature);
  }


  public int getPressure() {
    return this.pressure;
  }


  public int getBeaufort() {
    if (this.windSpeed == 1) {
      return 0;
    } else if (this.windSpeed >= 1 && this.windSpeed <= 5) {
      return 1;
    } else if (this.windSpeed >= 6 && this.windSpeed <= 11) {
    }
    return -1;
  }



}
