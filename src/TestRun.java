package src;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRun {
    
	
	@Test
	public void testCompetitorList(){
		
	}
	
	@Test
	public void testAddCompetitor(){
		
	}
	
	@Test
	public void testClear(){
		
	}
	
	@Test
	public void testRemoveCompetitorByPos(){
		
	}
	
	@Test
	public void testDidNotFinish(){
		
	}
	
	@Test
	public void testEnd2(){
		
	}
	
	@Test
	public void testReset(){
		
	}
	
    @Test
    public void testRunEnd(){
    	Run run = new Run();
    	run.addCompetitor(1);
    	run.start(1000000000);
    	run.end(200000000);
    	assertEquals(2000000000, run.getEndTime());
    	assertEquals(true, run.getFinished());
     
    	run = new Run();
    	run.addCompetitor(1);
    	run.start(1000);
    	run.end(-1);
    	assertEquals(-1, run.getEndTime());
    	assertEquals(false, run.getFinished());
     
    	run = new Run();
    	run.addCompetitor(1);
    	run.end(1000000000);
    	assertEquals(-1, run.getEndTime());
    	assertEquals(false, run.getFinished());
     
    	run = new Run();
    	run.addCompetitor(1);
    	run.start(-1);
    	run.end(1000000000);
    	assertEquals(-1, run.getEndTime());
    	assertEquals(false, run.getFinished());
     
    	run = new Run();
    	run.addCompetitor(1);
    	run.start(2000000000);
    	run.end(1000000000);
    	assertEquals(-1, run.getEndTime());
    	assertEquals(false, run.getFinished());
    }
    
   
    @Test
    public void testStart(){
    	//start(Time t)
    	Run r = new Run();
    	r.addCompetitor(1);
    	r.start(1000000000);
    	assertFalse(r.getCur().getStartTime() == -1);
    	assertTrue(r.getCur().getStarted());
    }
    
    @Test
    public void testStart2(){
    	//start(Time t, int position)
    	Run r = new Run();
    	r.addCompetitor(1);
    	r.addCompetitor(2);
    	r.addCompetitor(3);
    	r.start(1000000000, 0);
    	r.start(2000000000, 1);
    	r.start(3000000000L, 2);
    	assertEquals(r.getCompetitors().get(0).getStartTime(), 1000000000);
    	assertEquals(r.getCompetitors().get(1).getStartTime(), 2000000000);
    	assertEquals(r.getCompetitors().get(2).getStartTime(), 3000000000L);
    	assertTrue(r.getCompetitors().get(0).getStarted());
    	assertTrue(r.getCompetitors().get(1).getStarted());
    	assertTrue(r.getCompetitors().get(2).getStarted());
    }
    
    @Test
    public void testRunTime(){
    	Run r = new Run();
    	r.addCompetitor(1);
    	r.addCompetitor(2);
    	r.addCompetitor(3);
    	r.addCompetitor(4);
    	r.addCompetitor(5);
    	r.addCompetitor(6);
    	r.addCompetitor(7);

    	r.cur = r.competitors.get(0);
    	r.cur.start(1000000000);
    	r.cur.setStarted(); 
    	r.cur.end(2000000000);
    	assertTrue(r.runTime().equals("1.000 Seconds"));
	      
    	r.cur = r.competitors.get(1);
    	r.cur.start(1000);
    	r.cur.end(2000);
    	assertEquals(r.runTime(), null);
	      
    	r.cur = r.competitors.get(2);
    	r.cur.start(-1);
    	r.cur.setStarted();
    	r.cur.end(2000);
    	assertEquals(r.runTime(), null);
	
    	r.cur = r.competitors.get(3);
    	r.cur.start(1000);
    	r.cur.setStarted();
    	r.cur.end(-1);
    	assertEquals(r.runTime(), null);
	
    	r.cur = r.competitors.get(6);
    	r.cur.start(2000);
    	r.cur.setStarted();
    	r.cur.end(1000);
    	assertEquals(r.runTime(), null);
    }
    
    @Test
    public void testRemoveCompetitorByBib(){
    	Run r = new Run();
     
    	r.addCompetitor(1);
    	assertTrue(r.removeCompetitorByBib(1).equals("[bib:1 - Has Not started]"));
    	assertTrue(r.removeCompetitorByBib(1).equals(null));
     
    	r.addCompetitor(1);
    	r.competitors.get(0).start(1000);
    	r.competitors.get(0).setStarted();
    	assertTrue(r.removeCompetitorByBib(1).equals("[bib:1,start:1000,end:-,final:DNF]"));
     
    	r.addCompetitor(3);
    	r.competitors.get(0).start(1000000000);
    	r.competitors.get(0).end(2000000000);
    	r.competitors.get(0).setStarted();
    	r.competitors.get(0).setFinished();
    	assertTrue(r.removeCompetitorByBib(3).equals("[bib:3,start:1000000000,end:2000000000,final:1.000 Seconds]"));
    }
 
    
    /* DON'T NEED FOR SPRINT 1
    @Test
    public void testRunSwapNext(){
    	Run run = new Run();
    	for(int i = 0; i < 100; i++){
    		run.addCompetitor(i);
    	}
    	run.swapNext();
    	assertEquals(run.getCompetitors().indexOf(new Competitor(0)), 99);
    	assertEquals(run.getCompetitors().indexOf(new Competitor(99)), 0);
     
    	run = new Run();
    	run.swapNext();
    	run.addCompetitor(0);
    	run.swapNext();
    	run.addCompetitor(1);
    	run.swapNext();
    	assertEquals(run.getCompetitors().indexOf(new Competitor(0)), 1);
    	assertEquals(run.getCompetitors().indexOf(new Competitor(1)), 0);
    }
    */
    
}

	

