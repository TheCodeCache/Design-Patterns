package com.design.pattern.code.facade;

public class Dog implements Animal {

	@Override
	public void speak() {
		System.out.println("Dog Speaks :: Bow!! Bow!!");
	}
}