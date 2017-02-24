package edu.towson.cis.cosc442.project2.rectangle;

/**
 * The Point Class.
 */
public class Point {
	
	/** x and y coordinates. */
	private Double x, y;
	
	/**
	 * Instantiates a new point.
	 *
	 * @param x the x
	 * @param y the y
	 */
	Point(Double x, Double y) {
		this.x = x;
		this.y = y;
	}
	
	public Double getX(){
		return x;
	}
	
	public void setX(Double x){
		this.x = x;
	}
	
	public Double getY(){
		return y;
	}
	
	public void setY(Double y){
		this.y = y;
	}
}
