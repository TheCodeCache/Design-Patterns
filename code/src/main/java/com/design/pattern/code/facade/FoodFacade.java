package com.design.pattern.code.facade;

/**
 * Food Facade
 * 
 * it cooks the food
 * 
 * @author manoranjan
 */
public class FoodFacade {
	private Food food;

	/**
	 * exposes a simple API
	 * 
	 * hides the complexity of making food, it's a form of subset of abstraction,
	 * and not the vice-versa
	 * 
	 * @throws InterruptedException
	 */
	public void makeFood() throws InterruptedException {
		food.cleanVeggies();
		food.cuttingWorks();
		food.addIngredients();

		// busy waiting, consumes CPU resources
		// or use hardware timing circuit to release CPU resources
		while (!food.isFoodReady())
			;

		System.out.println("Food Is Cooked");
	}
}
