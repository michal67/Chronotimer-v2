package src;

public class Competitor {
	private int bibNum;
	private long startTime;
	private long endTime;
	private boolean started; // True if started running false if not
	private boolean finished; // True if finsihed false if still running or DNF

	/**
	 * the constructor that creates the competitor, with a bib#. Sets the start
	 * and end times to default values (-1) and started and finished to false;
	 */
	public Competitor(int bib) {
		bibNum = bib;
		startTime = -1;
		endTime = -1;
		started = false;
		finished = false;
	}
	
	/** IGNORE TESTING CONSTRUCTOR*/
	public Competitor(){
		bibNum = 0;
		startTime = -1;
		endTime = -1;
		started = false;
		finished = false;
	}

	public long getStartTime() {
		return startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public int getBibNum() {
		return bibNum;
	}

	/**
	 * Called when the competitor starts their run. Saves the time sets started
	 * to true.
	 */
	public void start(long t) {
		this.startTime = t;
		started = true;
	}

	/**
	 * Called when the competitor ends their run. Saves the time sets finsihed
	 * to true if finishing time is greater than start time. Else assumes DNF
	 * and sets finishing time to -1 and finished to false to signify DNF
	 */
	public void end(long time) {
		if (startTime > time) {
			this.endTime = -1;
			finished = false;

		} else {
			this.endTime = time;
			finished = true;
		}
	}

	/**
	 * resets the run of the competitor, returns the start and end time to a
	 * defult value, and sets started and finished to false. The bib Number will
	 * remain intact.
	 */
	public void reset() {
		startTime = -1;
		endTime = -1;
		started = false;
		finished = false;
	}

	/**
	 * provides the difference in the start time and end time
	 * 
	 * @return long - The total time of the run
	 */
	public long runTime() {
		return endTime - startTime;
	}

	/**
	 * overrides the toString for now: [bib:<bibNum>,start:<start>,end:
	 * <end>,final:]
	 * 
	 * @return String - String that represents this competitor
	 */
	@Override
	public String toString() {
		if ((started == true) && (finished == true)) {
			String finalTime = Time.parseTime(endTime - startTime);
			return "[bib:" + bibNum + ",start:" + startTime + ",end:" + endTime + ",final:" + finalTime + "]";
		} else if ((started == true && finished == false)) {
			return "[bib:" + bibNum + ",start:" + startTime + ",end:-,final:DNF]";
		} else {
			return "[bib:" + bibNum + " - Has Not started]";
		}
	}

	/**
	 * provides the XML for this competitor
	 * 
	 * @return String - the XML that represents this competitor
	 */
	public String toXML() {
		//TODO
		return null;
	}

	/* FOLLOWING METHODS ONLY USED FOR TESTING */
	
	public boolean getStarted(){
		return started;
	}
	
	public boolean getFinished(){
		return finished;
	}
	
	public void setStarted(){
		started = true;
	}
	
	public void setFinished(){
		finished = true;
	}
}
