public class Chronotimer(){
  ArrayList<boolean> channels;
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
  public void toggle(int channel){ //1-4
    channels.get(channel - 1) = !channels.get( channel - 1);
  }
  
  
  public void trigger(int channel){ trigger(channel, startTime - System.nanoTime()); }
  
  public void trigger(int channel, long time){
    if(channels.get( channel - 1)){
      if(channel==1)
        run.start(time);
      else if(channel==2)
        run.end(time);
    }
  }
  
  public void setTime(String[] time){
    offsetTime = Long.parseLong(time[0]) * 36000 //hours
      + Long.parseLong(time[1]) * 600 //minutes
      + Long.parseLong(time[2]) * 10 //seconds
      + Long.parseLong(time[3]);
  } 
  
  public void setEvent(String event){
    //TODO
  }
  
  public void newRun(){
    run = new Run();
  }
  
  public void endRun(){
  }
  
  public void addCompetitor(int bib){
    //TODO
  }
  
  /* Returns a formatted String representing the run,
     which is outputted by Simulator */
  public String print(){
    //TODO
  }
}
