package src;

public class Simulator{
  Chronotimer chronotimer;
  boolean powerOn;
  
  public Simulator(){
    chronotimer = new Chronotimer();
    powerOn = false;
  }
  
  public void input(String[] input){
    if(input[0].equalsIgnoreCase("POWER"))
      powerOn = !powerOn;
    else if(powerOn){
      if(input[0].equalsIgnoreCase("TOG"))
        chronotimer.toggle( Integer.parseInt( input[1]));
      else if(input[0].equalsIgnoreCase("TIME"))
        chronotimer.setTime( input[1].split(":|."));
      else if(input[0].equalsIgnoreCase("TRIG"))
        chronotimer.trigger( Integer.parseInt( input[1]));
      else if(input[0].equalsIgnoreCase("EVENT"))
        chronotimer.setEvent( input[1]);
      else if(input[0].equalsIgnoreCase("NEWRUN"))
        chronotimer.newRun();
      else if(input[0].equalsIgnoreCase("ENDRUN"))
        chronotimer.endRun();
      else if(input[0].equalsIgnoreCase("NUM"))
        chronotimer.addCompetitor( Integer.parseInt(input[1]));
      else if(input[0].equalsIgnoreCase("PRINT"))
        System.out.println( chronotimer.print());
    }
  }
}
