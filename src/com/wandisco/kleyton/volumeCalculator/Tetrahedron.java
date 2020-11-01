package com.wandisco.kleyton.volumeCalculator;

/**
 * A regular Tetrahedron blueprint. <br>
 * It implements Shape interface. <br>
 * Its {@code edge} variable is set when instantiated.
 * 
 * @author <a href="mailto:kleyton.ohare@gmail.com">Kleyton O'Hare</a>
 */
public class Tetrahedron implements Shape {
	private int edge;
	
	/**
	 * Constructs a new {@code Tetrahedron}.
	 * 
	 * @param edge the value.
	 */
	public Tetrahedron(int edge) {
		this.edge = edge;
	}
	
	/**
	 * Returns current edge.
	 * 
	 * @return current {@code edge}.
	 */
	public int getEdge() {
		return edge;
	}

	/**
	 * Returns the calculated volume based on the edge given when {@code Tetrahedron}
	 * is instantiated.
	 * 
	 * @return current volume.
	 */
	@Override
	public double getVolume() {
		double cubedEdge = new Cube(edge).getVolume();
		double result = cubedEdge / (6 * Math.sqrt(2));
		result = Math.round(result * 100.0) / 100.0; 	// round to 2 decimal points
		return result;
	}
	
	@Override
	public String toString() {
		return "A regular tetrahedron with edge " + edge + " has volume " + getVolume(); 
	}
	
}
