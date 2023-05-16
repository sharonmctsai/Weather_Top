package utilities;


import javax.swing.text.Utilities;
import java.util.List;

public class Conversions extends Utilities {


  public static double CelsiusToFarenheit(double temperature) {
    return (temperature * 9 / 5) + 32;
  }


}