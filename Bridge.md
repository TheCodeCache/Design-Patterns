# Bridge Design Pattern – 

`It's all about connecting components through abstraction`  

A `Bridge` prevents something called `Cartesian Product` complexity explosion  

For ex - let's assume we need to implement a thread scheduler  

Base class ThreadScheduler  
Can be Pre-emptive or Co-operative  
Can run on Windows or Unix  

And then we end up with 2 X 2 scenario -  
WindowsPTS, UnixPTS, WindowsCTS, UnixCTS  

basically, we'd end up having 4 classes in place, which is the all possible combination of above cases.  

Bridge Pattern avoids this entity explosion  

A mechanism, that decouples an interface (hierarchy) from an implementation (hierarchy)  

```java
package com.design.pattern.bridge;

interface Renderer {
	void renderCircle(float radius);
}

class VectorRenderer implements Renderer {
	@Override
	public void renderCircle(float radius) {
		System.out.println("Drawing a circle of radius " + radius);
	}
}

class RasterRenderer implements Renderer {
	@Override
	public void renderCircle(float radius) {
		System.out.println("Drawing pixels for a circle of radius " + radius);
	}
}

/**
 * A Bridge
 */
abstract class Shape {
	protected Renderer renderer;

	public Shape(Renderer renderer) {
		this.renderer = renderer;
	}

	public abstract void draw();

	public abstract void resize(float factor);
}

class Circle extends Shape {
	public float radius;

	public Circle(Renderer renderer) {
		super(renderer);
	}

	public Circle(Renderer renderer, float radius) {
		super(renderer);
		this.radius = radius;
	}

	@Override
	public void draw() {
		renderer.renderCircle(radius);
	}

	@Override
	public void resize(float factor) {
		radius *= factor;
	}
}

class BridgeDemo {
	public static void main(String[] args) {
		VectorRenderer vectorRenderer = new VectorRenderer();
		Circle circle = new Circle(vectorRenderer, 5);
		circle.draw();
		circle.resize(2);
		circle.draw();
	}
}
```

The snippet in the above code, i.e. abstract Shape class composes Renderer class and accepts it through constructor arguments both,  
this is what makes the bridge, which supports open/closed principle as well as single responsibility principle.  

![image](https://user-images.githubusercontent.com/26399543/152654166-af90b9f9-53c9-499f-aaaa-d16851fee09d.png)  

Shape hierarchy and Renderer hierarchy are independent now, just making the above change.  

This is all about Bridge Pattern.  

**Reference:**  
1. Udemy

