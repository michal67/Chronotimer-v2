package src;

public class Simulator{
  Chronotimer chronotimer;
  boolean powerOn, fileRead;
  long time;
  
  public Simulator(boolean fileRead){
    if(fileRead)
    chronotimer = new Chronotimer();
    powerOn = false;
    this.fileRead = fileRead;
  }
  
  public void input(String[] input){
    //Special case for a file read where the command is prefixed by a time in HH:MM:SS.S formatting
    if(fileRead){ 
      time = parseTime(input[0]);         
      input = System.arraycopy(input, 1, input, 0, input.length - 1);
    } else
      time = System.nanoTime();
    
    if(input[0].equalsIgnoreCase("POWER"))
      powerOn = !powerOn;
    
    else if(powerOn){
      if(input[0].equalsIgnoreCase("TOG"))
        chronotimer.toggle( Integer.parseInt(input[1]), time);
      
      else if(input[0].equalsIgnoreCase("TIME"))
        chronotimer.setTime( parseTime(input[1]), time);
      
      else if(input[0].equalsIgnoreCase("TRIG"))
        chronotimer.trigger( Integer.parseInt(input[1]), time);
      
      else if(input[0].equalsIgnoreCase("EVENT"))
        chronotimer.setEvent( input[1], time);
      
      else if(input[0].equalsIgnoreCase("NEWRUN"))
        chronotimer.newRun(time);
      
      else if(input[0].equalsIgnoreCase("ENDRUN"))
        chronotimer.endRun(time);
      
      else if(input[0].equalsIgnoreCase("NUM"))
        chronotimer.addCompetitor( Integer.parseInt(input[1]), time);
      
      else if(input[0].equalsIgnoreCase("PRINT"))
        System.out.println( chronotimer.print(), time);
    }
  }
  
  public long parseTime(String time){
    String[] timeString = time.split(":|.");

    return (Long.parseLong(timeString[0]) * 36000 //Convert to a single time unit (tenth-seconds), which is then converted to nanoseconds
      + Long.parseLong(timeString[1]) * 600
      + Long.parseLong(timeString[2]) * 10
      + Long.parseLong(timeString[3]) *)
      * 100000000;
  }
}
