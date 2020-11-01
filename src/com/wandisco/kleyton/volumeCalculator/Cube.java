package com.wandisco.kleyton.volumeCalculator;

/**
 * Cube blueprint. <br>
 * It implements Shape interface. <br>
 * Its {@code width} variable is set when instantiated.
 * 
 * @author <a href="mailto:kleyton.ohare@gmail.com">Kleyton O'Hare</a>
 */
public class Cube implements Shape {
	private int width;
	
	/**
	 * Constructs a new {@code Cube}.
	 * 
	 * @param width the value.
	 */
	public Cube(int width) {
		this.width = width;
	}
	
	/**
	 * Returns current width.
	 * 
	 * @return current {@code width}.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Returns the calculated volume based on the width given when {@code Cube}
	 * is instantiated.
	 *  
	 * @return current volume.
	 */
	@Override
	public double getVolume() {
		return Math.pow(width, 3);		// width to the power of 3
	}
	
	@Override
	public String toString() {
		return "A cube of width " + width + " has volume " + (int) getVolume(); 
	}
	
}
