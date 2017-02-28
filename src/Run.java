import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class Run{
    ArrayList<Competitor> competitors;
    Competitor cur;							// the current competitor
    int curNum;
    
    /**
     * the constructor that  creates the run, with default values
     *
     */
     public Run(){
      competitors = new ArrayList<Competitor>();
      cur = null;
      curNum = 0;
     }
     
      /**
     * provides a list of the competitors for this race
     *
     * @param  bib  the bib number of the competitor
     * @return	ArrayList<String> - The list of formatted strings that represent the competitors
     * @see         
     */
     public ArrayList<String> competitorList(){
     	String comps[] = new String[competitors.size()]
     	for(int i = 0; i < competitors.size(); i++){
     		comps[i] = competitors.get(i).toString();
     	}
     	return comps;
     }
     
     /**
     * adds a new competitor to the list of competitors, does not add a competitor
     *  if the a competirot already exists with the same bib number
     *
     * @param  bib  the bib number of the competitor
     * @return      true if the competitor was added, false otherwise
     * @see         
     */
     public boolean addCompetitor(int bib){
      for(int i = 0; i < competitors.size(); i++){
       if(competitors.get(i).bibNum == bib) return false;
      }
      competitors.add(new Comptitor(bib));
      return true;
     }
     
     /**
     * clears the list of competitors
     *
     * @param
     * @return      String[] - a formatted list of strings of the competitors that were in the list
     * @see         
     */
     public void String[] clear(){
       String[] listOfCompetitors = new String[competitors.size()];
       for(int i = 0; i < competitors.size(); i++){
        listOfCompetitors[i] = competitors.get(i).toString();
       }
       
       competitors.clear();
       return listOfCompetitors;
     }
     
      /**
     * finds a competitor with a matching bib and removes them from the list
     *
     * @param  bib  the bib number of the competitor
     * @return      String - A formatted string that represents the competitor
     * @see         
     */
     public String removeCompetitorByBib(int bib){
      for(int i=0; i<competitors.size(); i++)
        if(competitors.get(i).getBib() == bib)
         return competitors.remove(i).toString();
      return null;
     }
     
     /**
     * removes the competitor in the position specified
     *
     * @param	position - the zero indexed position of the competitor to be removed
     * @return	String - A formatted string that represents the competitor
     * @see         
     */
     public String removeCompetitorByPos(int position){
      if(competitors.size() <= position){
       return null;
      }
      String s = competitors.get(position).getName();
      competitors.remove(position);
      return s;
     }
     
     /**
     * the current competitor is moved to the back of the queue, and the next competitor becomes the current
     *
     * @param	
     * @return	String[] - A list of formatted strings that represents the competitors
     * @see         
     */
     public void swapNext(){
     }
     
    
     
     /**
     * indicates that the current competitor did not finish their run
     *
     * @param	
     * @return	
     * @see         
     */
     public void didNotFinish(){
      end(null);
     }
     
     
     
     /**
     * sets the time of the current competitor
     *
     * @param	t - a newly created Time object containing the time the the trigger was fired
     * @return
     * @see
     */
     public void start(Time t){
      curr.start(t.getTime());
     }
     
      /**
     * sets the time of the competitor at a specified position
     *
     * @param	t - a newly created Time object containing the time the the trigger was fired
     * @param	position - the zero index position of the competitor to act on
     * @return
     * @see
     */
     public void start(Time t, int position){
      competitors.get(position).start(t.getTime());
     }
     
     /**
     * ends the run of the current competitor, send in null for DNF, this will return the duration of the run or null if the competitor
     * did not finish, or -1 if there is not start time(the end time will be recorded)
     * @param	t - a newly created Time object containing the time the the trigger was fired
     * @return	Time - the differenece of time from the start to the finish
     * @see
     */
     public void end(Time t){
      curr.end(t.getTime());
     }
     
      /**
     * ends the run of the current specified, send in null for DNF, thsi will return the duration of the run or null if the competitor
     * did not finish, or -1 if there is not start time(the end time will be recorded)
     * @param	t - a newly created Time object containing the time the the trigger was fired
     * @param	position - the zero index position of the competitor to act on
     * @return	Time - the difference of time from the start to the finish
     * @see
     */
     public void end(Time t, int position){
      competitors.get(position).start(t.getTime());
     }
     
      /**
     * resets the run of the current competitor, returns the start and end time to a defult value,
     * the bib Number will remain intact
     * @return      long[3] - a tree element array of Long containing the start time, end time, and duration
     * @see
     */
     public long[] reset(){
     	long comp[] = new long[3];
     	comp[0] = cur.getStartTime();
     	comp[1] = cur.getEndTime();
     	comp[2] = cur.runTime();
     	cur.reset();
     	return comp;
     }
     
      /**
     * provides the difference in the start time and end time of the current competitor
     * @return      Time - The total time of the run
     * @see
     */
     public Time runTime(){
      if(null || -1) return null;
      long l = cur.runTime();
      Time t = parseTime(l);
      return t;
     }
     
       /**
     * provides the difference in the start time and end time of the current specified
     * @param	position - the zero index position of the competitor to act on
     * @return      Time - The total time of the run
     * @see
     */
     public long runTime(int position){
      return competitors.get(position).runTime();
     }
     
     
      /**
     * provides the XML for this run
     * @return      String - the XML that represents this run
     * @see         Image
     */
     public String toXML(){
     }

}
