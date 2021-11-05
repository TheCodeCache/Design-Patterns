package com.design.pattern.code.facade;

/**
 * Facade for making Shape,
 * 
 * We could also call or rename this class as "ShapeMaker" which would be as
 * good as "ShapeFacade"
 * 
 * @author manoranjan
 */
public class ShapeFacade {

	private Shape circle;
	private Shape rectangle;
	private Shape square;

	public ShapeFacade() {
		circle = new Circle();
		rectangle = new Rectangle();
		square = new Square();
	}

	public void drawCircle() {
		circle.draw();
	}

	public void drawRectangle() {
		rectangle.draw();
	}

	public void drawSquare() {
		square.draw();
	}
}