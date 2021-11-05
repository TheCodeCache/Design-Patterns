package com.design.pattern.code.facade;

/**
 * Facade Pattern Demo
 * 
 * @author manoranjan
 */
public class FacadeDemo {

	public static void main(String[] args) {

		/**
		 * Example - 1
		 */
		System.out.println("Facade Example - 1");

		ShapeFacade shapeMaker = new ShapeFacade();

		shapeMaker.drawCircle();
		shapeMaker.drawRectangle();
		shapeMaker.drawSquare();

		/**
		 * Example - 2
		 */
		System.out.println("\nFacade Example - 2");

		AnimalFacade af = new AnimalFacade();

		af.speakDog();
		af.speakCat();

		/**
		 * Example - 3
		 */
		System.out.println("\nFacade Example - 3");

		Computer facade = new Computer();
		facade.startComputer();
	}
}