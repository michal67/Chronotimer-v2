import org.junit.*;

public class CompetitorOld{
    private long start;
    private long end;
    private int bibNum;
    private String name;
	   private boolean started;
	   private boolean finished;
    
    
    /**
     * the constructor that  creates the competitor, with a bib
     * sets the start and end times to default values (-1)
     *
     * @param  bib  the bib number of the competitor
     * @return
     * @see
     */
     public CompetitorOld(int bib){
      bibNum = bib;
		    startTime = -1;
		    endTime = -1;
		    started = false;
		    finished = false;
     }
     
    /**
     * called when the competitor strats their run, and saves the time
     * **SETS STARTED TO TRUE**
     * @param   t - the time the the trigger was fired
     * @return
     * @see
     */
     public void start(long t){
      this.startTime = t;
    	 started = true;
     }
     
     /**
     * ends the run, send in null for DNF, this will return the duration of the run or null if the competitor
     * did not finish, or -1 if there is not start time(the end time will be recorded) 
     * **SETS FINISHED TO TRUE UNLESS DNF**
     * @param   t -  the time the the trigger was fired
     * @return      long - the differenece of time from the start to the finish
     * @see
     */
     public long end(long t){
     
     }
     
     public long end(Object object){ //FOR NULL CASE IF WE USE IT
		if(object == null){
			endTime = -1;
			finished = false;
		}
     }
     
     /**
      * returns the bib number of the competitor
      */
     public int getBib(){ return bibNum; }
     
     public String getName(){ return name; }
     
      /**
     * resets the run of the competitor, returns the start and end time to a defult value,
     * the bib Number will remain intact
     * @return      long[3] - a three element array of long containing the start time, end time, and duration
     * @see
     */
     public long[] reset(){
     	start = -1;
     	end = -1;
     	long l[] = new long[start, end, 0];
     	return l;
     }
     
      /**
     * provides the difference in the start time and end time
     * @return      long - The total time of the run
     * @see
     */
     public long runTime(){
     	return end - start;
     }
     
     /*
     *
     * OVERRIDE THE TO STRING METHOD
     *
     */
      /**
     * overrides the toString
     * for now:
     *      [bib:<bibNum>,start:<start>,end:,<end>]
     * @return      String - String that represents this competitor
     * @see
     */
     public string toString(){
      if ((started == true) && (finished == true)) {
			    String finalTime = Time.parseTime(end-start);
			    return "Competitor: " + bibNum + " --- " + finalTime;
		    } else if ((started == true && finished == false)){
			    return "Competitor: " + bibNum + " --- " + "DNF";
		    } else {
			    return "Competitor: " + bibNum + " --- " + "Has not Started.";
		    }
     }
     
     /**
     * provides the XML for this competitor
     * @return      String - the XML that represents this competitor
     * @see
     */
     public String toXML(){
     }
     
     @Test
     public void testCompetitorStart(){
     	CompetitorOld a = new CompetitorOld(1);
     	a.start(1000);
     	assertTrue(a.started);
     	assertEquals(a.startTime,1000);
     }
     
     @Test
     public void testCompetitorToString(){
     	CompetitorOld a = new CompetitorOld(1);
     	assertEquals(a.toString(), "Competitor: 1 --- Has not Started");
     	
     	a.start(1000);
     	assertEquals(a.toString(), "Competitor: 1 --- DNF");
     	
     	a.end(1001);
     	assertEquals(a.toString(), "Competitor: 1 --- 1");
     }
     
     @Test
     public void testCompetitorEnd(){
		    CompetitorOld a = new CompetitorOld(1);
		    a.startTime = 1000;
		    a.started = true;
		    a.end(2000);
		    assertEquals(a.endTime, 2000);
		    assertEquals(a.finished, true);
		
		    CompetitorOld b = new CompetitorOld(2);
		    b.startTime = 1000;
		    b.started = true;
		    //b.end(-1);
		    b.end(null);
		    assertEquals(b.endTime, -1);
		    assertEquals(b.finished, false);
		
		    CompetitorOld c = new CompetitorOld(3);
		    c.startTime = -1;
		    c.started = false;
		    c.end(2000);
		    assertEquals(b.endTime, -1);
		    assertEquals(b.finished, false);
		
		    CompetitorOld d = new CompetitorOld(3);
		    d.startTime = -1;
		    d.started = true;
		    d.end(2000);
		    assertEquals(b.endTime, -1);
		    assertEquals(b.finished, false);
	}
	
	@Test 
	public void testCompetitorRunTime(){
		CompetitorOld a = new CompetitorOld(1);
		a.startTime = 1000;
		a.started = true;
		a.end(2000);
		assertEquals(a.runTime(), 1000);
		
		CompetitorOld b = new CompetitorOld(2);
		b.startTime = 1000;
		b.started = false;
		b.end(2000);
		assertEquals(b.runTime(), null);
		
		CompetitorOld c = new CompetitorOld(3);
		c.startTime = -1;
		c.started = true;
		c.end(2000);
		assertEquals(c.runTime(), null);
		
		CompetitorOld d = new CompetitorOld(4);
		d.startTime = 1000;
		d.started = true;
		d.end(-1);
		assertEquals(d.runTime(), null);
		
		CompetitorOld e = new CompetitorOld(5);
		e.startTime = null;
		e.started = true;
		e.end(2000);
		assertEquals(d.runTime(), null);
		
		CompetitorOld f = new CompetitorOld(6);
		f.startTime = 1000;
		f.started = true;
		f.end(null);
		assertEquals(f.runTime(), null);
		
		CompetitorOld g = new CompetitorOld(7);
		g.startTime = 2000;
		g.started = true;
		g.end(1000);
		assertEquals(g.runTime(), null);
	}
}
