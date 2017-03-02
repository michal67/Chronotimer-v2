package src;

import java.util.ArrayList;

public class Chronotimer{
  ArrayList<Boolean> channels;
  long startTime;
  long offsetTime;
  Run run;
  
  public Chronotimer(){
    for(int i=0; i<8; i++)
      channels.add(false);
    startTime = System.nanoTime();
  }
  
  public Chronotimer(long time){
    for(int i=0; i<8; i++)
      channels.add(false);
    startTime = time;
  }
  
  //
  public void toggle(int channel, long time){ //1-4
	  boolean chan = channels.get(channel-1);
      chan = !chan;
  }
  
  public void trigger(int channel, long time){
    if(channels.get( channel - 1)){
      if(channel==1)
        run.start(startTime - time);
      else if(channel==2)
        run.end(startTime - time);
    }
  }
  
  public void setTime(long time){ offsetTime = time; } 
  
  public void setEvent(String event, long time){
    //TODO
  }
  
  public void newRun(long time){
    run = new Run();
  }
  
  public void endRun(long time){
	  
  }
  
  public void addCompetitor(int bib, long time){
    //TODO
  }
  
  /* Returns a formatted String representing the run,
     which is outputted by Simulator */
  public String print(long time){
    //TODO
  }
}
