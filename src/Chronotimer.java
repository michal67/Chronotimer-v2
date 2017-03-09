package src;
import java.util.ArrayList;

public class Chronotimer{
  ArrayList<Boolean> channels;
  long startTime, offsetTime;
  //TODO FIGURE OUT WHY THIS ISNT WORKING and add "curRace"
  ArrayList<Race> races;
  boolean runStarted, eventSelected;
  
  //TODO Update for CurRace, instantiating to first race with type.
  public Chronotimer(){
	  channels = new ArrayList<Boolean>();
    for(int i=0; i<8; i++)
      channels.add(false);
    startTime = System.nanoTime();
    runStarted = eventSelected = false;
  }
  
  //TODO Update for CurRace, instantiating to first race with type.
  public Chronotimer(long time){
    for(int i=0; i<8; i++)
      channels.add(false);
    startTime = time;
  }
  
  /** The TOG console/file command has a range from 1-8
   * This toggles the appropriate channel in the array from on (true) to off (false) or vice versa, from 0-7.
   * THis should be separate from races, but should only feed in triggers if true.*/
  public void toggle(int channel){ channels.set(channel-1, !channels.get(channel-1)); }
  
  //TODO Make this feed into curRace, not into arbitrary run
  /** If the channel is on and there's an active run,
   * start a new competitor if channel 1, end a competitor if channel 2. Should feed into current race.*/
  public void trigger(int channel, long time){
    if(channels.get(channel-1) && runStarted){ run.trigger(time - startTime); }
  }
  
  /** Sets the time offset in the file */
  public void setTime(long time){ offsetTime = time; } 
  
  //TODO Update this to accept paraInd as well
  /** If the event is IND, turns eventSelected to true, allowing new runs to be created.
   * Otherwise nothing happens.
   */
  public void setEvent(String event){
	  if(event.equalsIgnoreCase("IND"))
			  eventSelected = true;
	  }
  
  
  //TODO Update this to work with races storage, make new race curRace
  /** If there's no current run and an event has been selected,
   * start a new run, clearing all previous data.
   */
  public void newRun(){
	  if(!runStarted && eventSelected){
		  run = new Run();
		  runStarted = true;
	  }
  }
  
  //TODO Update this to work with race Storage, store curRace before making a new one
  /** Allows for a new run to be created. */
  public void endRun(){ runStarted=false; }
  
  //TODO Update to add competitor to curRace, not run.
  /** Adds a competitor to run */
  public void addCompetitor(int bib){ run.addCompetitor(bib); }
  
  //TODO Make this return all runs to console.
  /** Returns a formatted String representing the run,
     which is outputted by Simulator */
  public ArrayList<String> print(){
	return run.competitorList();
  }
  
  //TODO Make to Json method that puts all race data into a json formatted file.
}
