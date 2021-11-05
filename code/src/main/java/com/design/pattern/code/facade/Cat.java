package com.design.pattern.code.facade;

public class Cat implements Animal {

	@Override
	public void speak() {
		System.out.println("Cat Speaks :: Meow!! Meow!!");
	}
}