package src;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class Run {
	ArrayList<Competitor> competitors;
	Competitor cur; // the current competitor
	int curStart;
	int curFinish;

	/**
	 * the constructor that creates the run, with default values
	 */
	public Run() {
		competitors = new ArrayList<Competitor>();
		curStart = 0;
		curFinish = 0;
	}

	/**
	 * provides a list of the competitors for this race
	 * 
	 * @param bib
	 *            the bib number of the competitor
	 * @return ArrayList<String> - The list of formatted strings that represent
	 *         the competitors
	 */
	public ArrayList<String> competitorList() {
		ArrayList<String> comps = new ArrayList<String>();
		for (int i = 0; i < competitors.size(); i++) {
			comps.add(competitors.get(i).toString());
		}
		return comps;
	}

	/**
	 * adds a new competitor to the list of competitors, does not add a
	 * competitor if the a competitor already exists with the same bib number
	 * 
	 * @param bib
	 *            the bib number of the competitor
	 * @return true if the competitor was added, false otherwise
	 */
	public boolean addCompetitor(int bib) {
		for (int i = 0; i < competitors.size(); i++) {
			if (competitors.get(i).getBibNum() == bib)
				return false;
		}
		competitors.add(new Competitor(bib));
		return true;
	}

	/**
	 * clears the list of competitors
	 * 
	 * @param
	 * @return String[] - a formatted list of strings of the competitors that
	 *         were in the list
	 */
	public String[] clear() {
		String[] listOfCompetitors = new String[competitors.size()];
		for (int i = 0; i < competitors.size(); i++) {
			listOfCompetitors[i] = competitors.get(i).toString();
		}

		competitors.clear();
		return listOfCompetitors;
	}

	/**
	 * finds a competitor with a matching bib and removes them from the list
	 * 
	 * @param bib
	 *            the bib number of the competitor
	 * @return String - A formatted string that represents the competitor
	 */
	public String removeCompetitorByBib(int bib) {
		for (int i = 0; i < competitors.size(); i++)
			if (competitors.get(i).getBibNum() == bib)
				return competitors.remove(i).toString();
		return null;
	}

	/**
	 * removes the competitor in the position specified
	 * 
	 * @param position
	 *            - the zero indexed position of the competitor to be removed
	 * @return String - A formatted string that represents the competitor
	 */
	public String removeCompetitorByPos(int position) {
		if (competitors.size() <= position) {
			return null;
		}

		String s = competitors.get(position).toString();
		competitors.remove(position);
		return s;
	}

	/**
	 * the current competitor is moved to the back of the queue, and the next
	 * competitor becomes the current
	 * 
	 * @return String[] - A list of formatted strings that represents the
	 *         competitors
	 */
	public String[] swapNext() {
		// TODO
	}

	/**
	 * indicates that the current competitor did not finish their run
	 */
	public void didNotFinish() {
		cur.end(-1);
	}

	/**
	 * sets the start time of the current competitor
	 * 
	 * @param l
	 *            - the time the trigger was fired
	 * @return
	 */
	public void start(long l) {
		cur.start(l);
	}

	/**
	 * sets the time of the competitor at a specified position
	 * 
	 * @param t
	 *            - a newly created Time object containing the time the the
	 *            trigger was fired
	 * @param position
	 *            - the zero index position of the competitor to act on
	 */
	public void start(long t, int position) {
		competitors.get(position).start(t);
	}

	/**
	 * ends the run of the current competitor, send in null for DNF, this will
	 * return the duration of the run or null if the competitor did not finish,
	 * or -1 if there is not start time(the end time will be recorded)
	 * 
	 * @param t
	 *            - a newly created Time object containing the time the the
	 *            trigger was fired
	 * @return Time - the difference of time from the start to the finish
	 */
	public void end(long l) {
		cur.end(l);
	}

	/**
	 * ends the run of the current specified, send in null for DNF, thsi will
	 * return the duration of the run or null if the competitor did not finish,
	 * or -1 if there is not start time(the end time will be recorded)
	 * 
	 * @param t
	 *            - a newly created Time object containing the time the the
	 *            trigger was fired
	 * @param position
	 *            - the zero index position of the competitor to act on
	 */
	public void end(long t, int position) {
		competitors.get(position).end(t);
	}

	/**
	 * resets the run of the current competitor, returns the start and end time
	 * to a default value, the bib Number will remain intact
	 * 
	 * @return long[3] - a tree element array of Long containing the start time,
	 *         end time, and duration
	 */
	public long[] reset() {
		long comp[] = new long[3];
		comp[0] = cur.getStartTime();
		comp[1] = cur.getEndTime();
		comp[2] = cur.runTime();
		cur.reset();
		return comp;
	}

	/**
	 * provides the difference in the start time and end time of the current
	 * specified
	 * 
	 * @param position
	 *            - the zero index position of the competitor to act on
	 * @return Time - The total time of the run
	 * @see
	 */
	public long runTime(int position) {
		return competitors.get(position).runTime();
	}

	/**
	 * provides the XML for this run
	 * 
	 * @return String - the XML that represents this run
	 * @see Image
	 */
	public String toXML() {
		// TODO
		return null;
	}
	
	/* FOLLOWING METHODS USED FOR TESTING ONLY */
	
	public Competitor getCur(){
		return cur;
	}
	
	public void setCur(Competitor c){
		cur = c;
	}
	
	public ArrayList<Competitor> getCompetitors(){
		return competitors;
	}
	
	public long getEndTime(){
		return cur.getEndTime();
	}
	
	public long getStartTime(){
		return cur.getStartTime();
	}
	
	public boolean getStarted(){
		return cur.getStarted();
	}
	
	public boolean getFinished(){
		return cur.getFinished();
	}
}
