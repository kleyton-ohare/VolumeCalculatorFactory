# VolumeCalculatorFactory

This application calculates the volume of three types of shapes: `Sphere`, `Cube` and a regular `Tetrahedron`.

Factory Design Pattern was implemented so that the creation of objects is not exposed to the client.

As a result, the client invokes only one static method from `ShapeFactory` which then manages the instantiation.

Loose-coupling implementation is enforced by this design.

Here is the [link](https://kleyton-ohare.github.io/VolumeCalculatorFactory/index.html) to Javadoc.

The executable jar file, containing GUI, can be found [here](https://drive.google.com/drive/folders/1eeE3XRAEk-ERaHBr1-rbx_YG0utMAZ9E?usp=sharing).

**jdk-15**

<br><br>

## UML
![UML](https://raw.githubusercontent.com/kleyton-ohare/VolumeCalculatorFactory/master/img/VolumeCalculatorFactoryUML.png)


The UML above shows `Sphere`, `Cube`, and `Tetrahedron` implementing `Shape` interface.

`ShapeFactory` uses `Shape` and returns a `Shape` object.

`Demo` is where the `main` method invokes `ShapeFactory`.

<br><br>

### VolumeCalculatorAbstractFactory
I have also developed the **Abstract Factory** version for VolumeCalculatorFactory [here](https://github.com/kleyton-ohare/VolumeCalculatorAbstractFactory).