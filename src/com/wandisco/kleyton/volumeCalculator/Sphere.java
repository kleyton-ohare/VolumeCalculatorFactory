package com.wandisco.kleyton.volumeCalculator;

/**
 * Sphere blueprint. <br>
 * It implements Shape interface. <br>
 * Its {@code radius} variable is set when instantiated.
 * 
 * @author <a href="mailto:kleyton.ohare@gmail.com">Kleyton O'Hare</a>
 */
public class Sphere implements Shape {
	private int radius;

	/**
	 * Constructs a new {@code Sphere}.
	 * 
	 * @param radius the value.
	 */
	public Sphere(int radius) {
		this.radius = radius;
	}

	/**
	 * Returns current radius.
	 * 
	 * @return current {@code radius}.
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * Returns the calculated volume based on the radius given when {@code Sphere}
	 * is instantiated.
	 *  
	 * @return current volume.
	 */
	@Override
	public double getVolume() {
		double cubedRadius = new Cube(radius).getVolume();
		double result = (4.0 / 3.0) * Math.PI * cubedRadius;
		result = Math.round(result * 100.0) / 100.0; // round to 2 decimal points
		return result;
	}

	@Override
	public String toString() {
		return "A sphere of radius " + radius + " has volume " + getVolume();
	}
	
}
