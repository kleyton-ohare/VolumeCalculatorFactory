package com.wandisco.kleyton.volumeCalculator;

/**
 * Provides an interface for concrete classes instantiation.
 * 
 * @author <a href="mailto:kleyton.ohare@gmail.com">Kleyton O'Hare</a>
 */
public class ShapeFactory {

	/**
	 * Get object of type {@code Shape}
	 * 
	 * @param shapeType class name.
	 * @param value for class instantiation.
	 * @return {@code Shape} instantiation of a {@code Shape} subtype.
	 */
	public static Shape getShape(String shapeType, int value) {
		switch(shapeType.toLowerCase()) {
			case "sphere":
					return new Sphere(value);
			case "cube":
					return new Cube(value);
			case "tetrahedron":
					return new Tetrahedron(value);
			default:
					return null;
		}
	}
	
}
