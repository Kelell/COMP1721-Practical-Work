import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A single measurement of NO<sub>2</sub> level.
 *
 * <p>Created for COMP1721 Coursework 1.</p>
 *
 * @author KELELL DAVISON-THOMAS
 */
public class Measurement {
  // Use this when parsing measurement time
  private static DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

  private LocalDateTime time;
  private int level;

 //Proces the data in this method
 public Measurement(String record) {
   int length = record.length();

  //checks for valid values based on the length of the string  before converting
   if (length < 17 || length >20){
     throw new DataException("Invalid value");
   }
   if (length >=17){
     String date = record.substring(0, 16);
     String newDate = date.substring(0, 10)+" "+date.substring(11, 16);

     LocalDateTime time = LocalDateTime.parse(newDate, FORMAT);
     this.time= time;
     if (length <18){
       level = -1;
     }
     else{
       level=Integer.parseInt(record.substring(17));
     }
     this.level= level;
   }
   return;
 }

  //return the data in the next two
  public LocalDateTime getTime() {
    return time;
  }

  public int getLevel() {
    return level;
  }

  public String toString() {
    if (this.getLevel() == -1)
    {
      return(this.getTime()+", no data");
    }
    return(this.getTime()+", "+this.getLevel()+" \u00b5g/m\u00b3");
  }
}
