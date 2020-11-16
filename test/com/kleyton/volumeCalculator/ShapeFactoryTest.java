package com.kleyton.volumeCalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.kleyton.volumeCalculator.Shape;
import com.kleyton.volumeCalculator.ShapeFactory;

/**
 * Ensure there are no logic errors when calculating values for different subtypes of
 * {@code Shape} using abstract factory design.
 * 
 * @author <a href="mailto:kleyton.ohare@gmail.com">Kleyton O'Hare</a>
 */
class ShapeFactoryTest {
	private Shape sphere;
	private Shape cube;
	private Shape tetrahedron;
	private double result;

	@Test
	void testSphere() {
		// Test 1 - A sphere of radius 1 has volume 4.19
		sphere = ShapeFactory.getShape("SPHERE", 1);	// first arg in Uppercase 
		result = sphere.getVolume();
		assertEquals(4.19, result, "Expecting 4.19");	// args: expected, actual, message

		// Test 2 - A sphere of radius 2 has volume 33.51
		sphere = ShapeFactory.getShape("sphere", 2);
		result = sphere.getVolume();
		assertEquals(33.51, result, "Expecting 33.51");

		// Test 3 - A sphere of radius 3 has volume 113.1
		sphere = ShapeFactory.getShape("sphere", 3);
		result = sphere.getVolume();
		assertEquals(113.1, result, "Expecting 113.1");

		// Test 4 - A sphere of radius 4 has volume 268.08
		sphere = ShapeFactory.getShape("sphere", 4);
		result = sphere.getVolume();
		assertEquals(268.08, result, "Expecting 268.08");

		// Test 5 - A sphere of radius 5 has volume 523.6
		sphere = ShapeFactory.getShape("sphere", 5);
		result = sphere.getVolume();
		assertEquals(523.6, result, "Expecting 523.6");
	}

	@Test
	void testCube() {
		// Test 1 - A cube of width 1 has volume 1
		cube = ShapeFactory.getShape("CUBE", 1);	// first arg in Uppercase
		result = cube.getVolume();
		assertEquals(1, result, "Expecting 1");

		// Test 2 - A cube of width 2 has volume 8
		cube = ShapeFactory.getShape("cube", 2);
		result = cube.getVolume();
		assertEquals(8, result, "Expecting 8");

		// Test 3 - A cube of width 3 has volume 27
		cube = ShapeFactory.getShape("cube", 3);
		result = cube.getVolume();
		assertEquals(27, result, "Expecting 27");

		// Test 4 - A cube of width 4 has volume 64
		cube = ShapeFactory.getShape("cube", 4);
		result = cube.getVolume();
		assertEquals(64, result, "Expecting 64");

		// Test 5 - A cube of width 5 has volume 125
		cube = ShapeFactory.getShape("cube", 5);
		result = cube.getVolume();
		assertEquals(125, result, "Expecting 125");
	}

	@Test
	void testTetrahedron() {
		// Test 1 - A regular tetrahedron with edge 1 has volume 0.12
		tetrahedron = ShapeFactory.getShape("TETRAHEDRON", 1);	// first arg in Uppercase
		result = tetrahedron.getVolume();
		assertEquals(0.12, result, "Expecting 0.12");

		// Test 2 - A regular tetrahedron with edge 2 has volume 0.94
		tetrahedron = ShapeFactory.getShape("tetrahedron", 2);
		result = tetrahedron.getVolume();
		assertEquals(0.94, result, "Expecting 0.94");

		// Test 3 - A regular tetrahedron with edge 3 has volume 3.18
		tetrahedron = ShapeFactory.getShape("tetrahedron", 3);
		result = tetrahedron.getVolume();
		assertEquals(3.18, result, "Expecting 3.18");

		// Test 4 - A regular tetrahedron with edge 4 has volume 7.54
		tetrahedron = ShapeFactory.getShape("tetrahedron", 4);
		result = tetrahedron.getVolume();
		assertEquals(7.54, result, "Expecting 7.54");

		// Test 5 - A regular tetrahedron with edge 5 has volume 14.73
		tetrahedron = ShapeFactory.getShape("tetrahedron", 5);
		result = tetrahedron.getVolume();
		assertEquals(14.73, result, "Expecting 14.73");
	}
}