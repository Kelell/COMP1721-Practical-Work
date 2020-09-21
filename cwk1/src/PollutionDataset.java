import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


/**
 * A sequence of air pollution measurements.
 *
 * <p>Created for COMP1721 Coursework 1.</p>
 *
 * @author KELELL DAVISON-THOMAS
 */
public class PollutionDataset {
  private List<Measurement> dataSet;


  public PollutionDataset() {
    List<Measurement> dataSet= new ArrayList<>();
    this.dataSet= dataSet;
  }
  //reads the CSV file and uses it to populate a dataset
  public void readCSV(String filename) throws FileNotFoundException {
    Scanner input = new Scanner(new File(filename));
    dataSet.clear();
    while (input.hasNextLine()) {
      String line = input.nextLine();
      if (line.length() >=17 && line.length() <= 20) //condition to avoid titles
      {
        Measurement newValue = new Measurement(line);
        dataSet.add(newValue);
      }
    }
    input.close();
}
  //adds a measurement to the end of a dataset
  public void add(Measurement m) {
    String compare= m.toString();
    int length = compare.length();
    if (length< 15){
      throw new DataException("Invalid value");
    }
    dataSet.add(m);
  }
  //return the size of a dataset
  public int size() {
    int size = dataSet.size();
    return size;
  }
  //returns a measurement at a selected location in a dataset
  public Measurement get(int index) {
    if (dataSet.isEmpty() ==true){
      throw new DataException("Empty dataset");
    }
    Measurement selValue = dataSet.get(index);
    return selValue;
  }
  //returns the measurement with the highest NO2 level in the dataset
  public Measurement maxLevel() {
    if (dataSet.isEmpty() ==true){
      throw new DataException("Empty dataset");
    }
    int maxValue =-1;
    int valuePointer=0;
    Measurement currentValue;
    for(int i=0; i< dataSet.size(); i++){
      currentValue = dataSet.get(i);
      if ( maxValue < currentValue.getLevel()){
        maxValue = currentValue.getLevel();
        valuePointer =i;
      }
    }
    Measurement maxLevel = dataSet.get(valuePointer);
    return maxLevel;
  }
  //returns the measurement with the lowest NO2 level in the dataset
  public Measurement minLevel() {
    if (dataSet.isEmpty() ==true){
      throw new DataException("Empty dataset");
    }
    int minValue =10000;
    int valuePointer=0;
    Measurement currentValue;
    for(int i=0; i< dataSet.size(); i++){
      currentValue = dataSet.get(i);
      if ( minValue > currentValue.getLevel() && currentValue.getLevel() != -1){
        minValue = currentValue.getLevel();
        valuePointer =i;
      }
    }
    Measurement minLevel = dataSet.get(valuePointer);
    return minLevel;
  }
  //caluclates the mean NO2 level of the dataset amongst the valid measurements
  public double meanLevel(){
    if (dataSet.isEmpty() ==true){
      throw new DataException("Empty dataset");
    }
    double n02Total= 0.0;
    double meanLevel= 0.0;
    double totalValues= 0.0;
    Measurement currentValue;
    for(int i=0; i< dataSet.size(); i++){
      currentValue = dataSet.get(i);
      if (currentValue.getLevel() > -1){
        n02Total =n02Total+currentValue.getLevel();
        totalValues++;
      }
    }
    meanLevel =(n02Total/ totalValues);
    return meanLevel;
  }
  //returns the day that the hourly NO2 levels reach 200 for the 18th time
  public LocalDate dayRulesBreached(){
    if (dataSet.isEmpty() ==true){
      throw new DataException("Empty dataset");
    }
    int n02Total= 0;
    Measurement currentValue;
    int breachCounter=0;
    int hourCounter=0;
    for(int i=0; i< dataSet.size(); i++){
      if (hourCounter ==4){ //this will gate each value for an hour
        hourCounter = 0;
        n02Total =0;
      }
      currentValue = dataSet.get(i);
      hourCounter++;
      if (currentValue.getLevel() > -1){
        n02Total =n02Total+currentValue.getLevel();
          if (n02Total >= 200){
            breachCounter++;
            n02Total=0;
            if (breachCounter > 18){
              return currentValue.getTime().toLocalDate();
            }
          }
        }
      }
      return null;
    }

}
