import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.io.FileReader;


class Pollution
{

  public static void main(String[] args) throws IOException {
      PollutionDataset basicTest = new PollutionDataset();
    // Check for a filename on command line

    if (args.length == 0) {
      System.out.println("File not found!");
      System.exit(1);
    }
    //args is currently a string array, parse it to a string
    String csv= Arrays.toString(args);

    // even after parsed, the string is in brackets
    csv=csv.replace("[", "");
    csv=csv.replace("]", "");

    basicTest.readCSV(csv);
    System.out.println(basicTest.size()+" records processed");
    System.out.println("Max: "+basicTest.maxLevel());
    System.out.println("Min: "+basicTest.minLevel());
    System.out.println("Mean level of NO2: "+basicTest.meanLevel()+" \u00b5g/m\u00b3");
    if (basicTest.dayRulesBreached() != null)
      System.out.println("The day the EU rules were breached was: "+basicTest.dayRulesBreached());
    else
      System.out.println("The EU rules were not breached.");
  }
}
