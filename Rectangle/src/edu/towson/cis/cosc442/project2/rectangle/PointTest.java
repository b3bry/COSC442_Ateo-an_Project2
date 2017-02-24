package edu.towson.cis.cosc442.project2.rectangle;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PointTest {
	Point p;

	@Before
	public void setUp() throws Exception {
		p = new Point(2.0,3.0);
	}
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPoint() {
		try{
			Point localPoint = new Point(5.0,2.0);
		}catch (Exception e){
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetX() {
		assertEquals(new Double(2.0), p.getX());
	}

	@Test
	public void testSetX() {
		p.setX(5.0);
		assertEquals(new Double(5.0),p.getX());
	}

	@Test
	public void testGetY() {
		assertEquals(new Double(3.0), p.getY());
	}

	@Test
	public void testSetY() {
		p.setY(5.0);
		assertEquals(new Double(5.0),p.getY());
	}

}
