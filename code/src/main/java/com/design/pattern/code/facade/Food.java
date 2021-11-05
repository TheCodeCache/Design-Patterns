package com.design.pattern.code.facade;

public class Food {

	private int quantity;

	protected void addIngredients() {
		// impl.
	}

	protected void cuttingWorks() {
		// impl.
	}

	protected void turnOnTheFlame() {
		// impl.
	}

	protected void turnOffTheFlame() {
		// impl.
	}

	protected void addGravy(int quantity) {
		this.quantity = quantity;
		// impl.
	}

	protected void cleanVeggies() {
		// impl.
	}

	protected boolean isFoodReady() {
		// impl.
		return false;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
