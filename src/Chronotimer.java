public class Chronotimer(){
  ArrayList<boolean> channels;
  long startTime;
  Run run;
  
  public Chronotimer(){
    for(int i=0; i<8; i++)
      channels.add(false);
    startTime = /* get time */
  }
  
  //
  public void toggle(int channel){ //1-4
    channels.get(channel-1) = !channels.get(channel-1);
  }
  
  
  public void trigger(int channel){
    //TODO
  }
  
  public void setTime(String time){ //Formatted as HH:MM:SS.M
    //TODO
  } 
  
  public void setEvent(String event){
    //TODO
  }
  
  public void newRun(){
    //TODO
  }
  
  public void newRun(long time){
  }
  
  public void endRun(){
  }
  
  public void endRun(long time){
    //TODO
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
