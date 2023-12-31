//: factory:shapefact2:ShapeFactory2.java
// Polymorphic factory methods.
package factory.shapefact2;

import java.util.*;

interface Shape {
	void draw();

	void erase();
}

abstract class ShapeFactory {
	protected abstract Shape create();

	private static Map factories = new HashMap();

	public static void addFactory(String id, ShapeFactory f) {
		factories.put(id, f);
	}

	// A Template Method:
	public static final Shape createShape(String id) {
		if (!factories.containsKey(id)) {
			try {
				// Load dynamically
				Class.forName("factory.shapefact2." + id);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Bad shape creation: " + id);
			}
			// See if it was put in:
			if (!factories.containsKey(id))
				throw new RuntimeException("Bad shape creation: " + id);
		}
		return ((ShapeFactory) factories.get(id)).create();
	}
}

class Circle implements Shape {
	private Circle() {
	}

	public void draw() {
		System.out.println("Circle.draw");
	}

	public void erase() {
		System.out.println("Circle.erase");
	}

	private static class Factory extends ShapeFactory {
		protected Shape create() {
			return new Circle();
		}
	}

	static {
		ShapeFactory.addFactory("Circle", new Factory());
	}
}

class Square implements Shape {
	private Square() {
	}

	public void draw() {
		System.out.println("Square.draw");
	}

	public void erase() {
		System.out.println("Square.erase");
	}

	private static class Factory extends ShapeFactory {
		protected Shape create() {
			return new Square();
		}
	}

	static {
		ShapeFactory.addFactory("Square", new Factory());
	}
}
