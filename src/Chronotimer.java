package src;

import java.util.ArrayList;

public class Chronotimer{
  ArrayList<Boolean> channels;
  long startTime, offsetTime;
  Run run;
  boolean runStarted, eventSelected;
  
  public Chronotimer(){
	  channels = new ArrayList<Boolean>();
    for(int i=0; i<8; i++)
      channels.add(false);
    startTime = System.nanoTime();
    runStarted = eventSelected = false;
  }
  
  public Chronotimer(long time){
    for(int i=0; i<8; i++)
      channels.add(false);
    startTime = time;
  }
  
  //
  public void toggle(int channel){ channels.set(channel-1, !channels.get(channel-1)); }
  
  public void trigger(int channel, long time){
    if(channels.get(channel-1) && runStarted){
      if(channel==1)
        run.start(time - startTime);
      else if(channel==2)
        run.end(time - startTime);
    }
  }
  
  public void setTime(long time){ offsetTime = time; } 
  
  public void setEvent(String event){eventSelected = true;}
  
  public void newRun(){
	  if(!runStarted && eventSelected){
		  run = new Run();
		  runStarted = true;
	  }
  }
  
  public void endRun(){ runStarted=false; }
  
  public void addCompetitor(int bib){ run.addCompetitor(bib); }
  
  /* Returns a formatted String representing the run,
     which is outputted by Simulator */
  public ArrayList<String> print(){
	return run.competitorList();
    //TODO
  }
}
