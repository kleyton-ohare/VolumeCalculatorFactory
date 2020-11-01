package com.wandisco.kleyton.volumeCalculator;

/**
 * This functional interface provides a single method which given a unit, Shape
 * subtypes will implement the volume calculations.
 * 
 * @author <a href="mailto:kleyton.ohare@gmail.com">Kleyton O'Hare</a>
 */
public interface Shape {
	/**
	 * Volume calculation
	 * 
	 * @return calculated volume.
	 */
	double getVolume();

}
