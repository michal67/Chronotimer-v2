import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestCompetitor {
	
	//test commit

	@Test
	public void testCompetitorStart() {
		Competitor a = new Competitor(1);
		a.start(1000);
		assertTrue(a.getStarted());
		assertEquals(a.getStartTime(), 1000);
	}

	@Test
	public void testCompetitorToString() {
		Competitor a = new Competitor(1);
		assertEquals(a.toString(), "Competitor: 1 --- Has not Started");

		a.start(1000);
		assertEquals(a.toString(), "Competitor: 1 --- DNF");

		a.end(1001);
		assertEquals(a.toString(), "Competitor: 1 --- 1");
	}

	@Test
	public void testCompetitorRunTime() {
		Competitor a = new Competitor(1);
		a.start(1000);
		a.setStarted();
		a.end(2000);
		assertEquals(a.runTime(), 1000);

		Competitor b = new Competitor(2);
		b.start(1000);
		b.setStarted();
		b.end(2000);
		assertEquals(b.runTime(), -1);

		Competitor c = new Competitor(3);
		c.start(-1);
		c.setStarted();
		c.end(2000);
		assertEquals(c.runTime(), -1);

		Competitor d = new Competitor(4);
		d.start(1000);
		d.setStarted();
		d.end(-1);
		assertEquals(d.runTime(), -1);

		Competitor e = new Competitor(5);
		e.start(-1);
		e.setStarted();
		e.end(2000);
		assertEquals(d.runTime(), -1);

		Competitor f = new Competitor(6);
		f.start(1000);
		f.setStarted();
		f.end(-1);
		assertEquals(f.runTime(), -1);

		Competitor g = new Competitor(7);
		g.start(2000);
		g.setStarted();
		g.end(1000);
		assertEquals(g.runTime(), -1);
	}

	@Test
	public void testCompetitorEnd() {
		Competitor a = new Competitor(1);
		a.start(1000);
		a.setStarted();
		a.end(2000);
		assertEquals(a.getEndTime(), 2000);
		assertEquals(a.getFinished(), true);

		Competitor b = new Competitor(2);
		b.start(1000);
		b.setStarted();
		b.end(-1);
		assertEquals(b.getEndTime(), -1);
		assertEquals(b.getFinished(), false);

		Competitor c = new Competitor(3);
		c.start(-1);
		c.end(2000);
		assertEquals(b.getEndTime(), -1);
		assertEquals(b.getFinished(), false);

		Competitor d = new Competitor(3);
		d.start(-1);
		d.setStarted();
		d.end(2000);
		assertEquals(b.getEndTime(), -1);
		assertEquals(b.getFinished(), false);
	}
}
