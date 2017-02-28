import static org.junit.Assert.*;

import org.junit.Test;

public class TestRun {

    @Test
    public void testCompetitorRunTime(){
     
    }
    
    @Test
    public void testRunEnd(){
    	Run run = new Run();
    	run.addCompetitor(1);
    	run.start(1000);
    	assertEquals(run.end(1001), 1);
     
    	run = new Run();
    	run.addCompetitor(1);
    	run.start(1000);
    	assertEquals(run.end(null), null);
     
    	run = new Run();
    	run.addCompetitor(1);
    	assertEquals(run.end(1000), -1);
     
    	run.addCompetitor(1);
    	run.start(1000);
    	assertEquals(run.end(1001, 0), 1);
     
    	run = new Run();
    	run.addCompetitor(1);
    	run.start(1000);
    	assertEquals(run.end(null, 0), null);
     
    	run = new Run();
    	run.addCompetitor(1);
    	assertEquals(run.end(1000, 0), -1);
    }
    
    @Test
    public void testRunSwapNext(){
    	Run run = new Run();
    	for(int i = 0; i < 100; i++)
    	run.addCompetitor(i);
    	run.swapNext();
    	assertEquals(competitor.indexOf(new Competitor(0), 99));
    	assertEquals(competitor.indexOf(new Competitor(99), 0));
     
    	run = new Run();
    	run.swapNext();
    	run.addCompetitor(0);
    	run.swapNext();
    	run.addCompetitor(1);
    	run.swapNext();
    	assertEquals(competitor.indexOf(new Competitor(0), 1));
    	assertEquals(competitor.indexOf(new Competitor(1), 0));
    }
    
    @Test
    public void testStart(){
    	//start(Time t)
    	Run r = new Run();
    	r.addCompetitor(1);
    	r.cur = r.competitors.get(0);
    	r.start(new Time());
    	assertFalse(r.cur.getStartTime() == -1);
    	assertTrue(r.cur.getStarted());
    }
    
    @Test
    public void testStart2(){
    	//start(Time t, int position)
    	Run r = new Run();
    	r.addCompetitor(1);
    	r.addCompetitor(2);
    	r.addCompetitor(3);
    	Time t = new Time();
    	r.start(t, 0);
    	r.start(t, 1);
    	r.start(t, 2);
    	assertFalse(r.competitors.get(0).getStartTime() == -1);
    	assertFalse(r.competitors.get(1).getStartTime() == -1);
    	assertFalse(r.competitors.get(2).getStartTime() == -1);
    	assertTrue(r.competitors.get(0).getStarted());
    	assertTrue(r.competitors.get(1).getStarted());
    	assertTrue(r.competitors.get(2).getStarted());
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
    	r.cur.startTime = 1000000000;
    	r.cur.started = true;
    	r.cur.end(2000000000);
    	assertTrue(r.runTime().equals("1.000 Seconds"));
	      
    	cur = r.get(1);
    	cur.startTime = 1000;
    	cur.started = false;
    	cur.end(2000);
    	assertEquals(r.runTime(), null);
	      
    	cur = r.get(2);
    	c.startTime = -1;
    	c.started = true;
    	c.end(2000);
    	assertEquals(r.runTime(), null);
	
    	cur = r.get(3);
    	cur.startTime = 1000;
    	cur.started = true;
    	cur.end(-1);
    	assertEquals(r.runTime(), null);
	
    	cur = r.get(4);	      	
    	cur.startTime = null;
    	cur.started = true;
    	cur.end(2000);
    	assertEquals(r.runTime(), null);
	
    	cur = r.get(5);
    	cur.startTime = 1000;
    	cur.started = true;
    	cur.end(null);
    	assertEquals(r.runTime(), null);
	
    	cur = r.get(6);
    	cur.startTime = 2000;
    	cur.started = true;
    	cur.end(1000);
    	assertEquals(r.runTime(), null);
    }
    
    @Test
    public void testRemoveCompetitorByBib(){
    	Run r = new Run();
     
    	r.addCompetitor(1);
    	assertTrue(r.removeCompetitorByBib(1).equals("[bib:1 - Has Not started]"));
    	assertTrue(r.removeCompetitorByBib(1).equals(null));
     
    	r.addCompetitor(1);
    	r.get(0).startTime = 1000;
    	r.get(0).started = true;
    	assertTrue(r.removeCompetitorByBib(1).equals("[bib:1,start:1000,end:-,final:DNF]"));
     
    	r.addCompetitor(3);
    	r.get(0).startTime = 1000000000;
    	r.get(0).endTime = 200000000;
    	r.get(0).started = true;
    	r.get(0).finished = true;
    	assertTrue(r.removeCompetitorByBib(3).equals("[bib:3,start:1000000000,end:2000000000,final:1.000 Seconds]"));
    }
}

	

