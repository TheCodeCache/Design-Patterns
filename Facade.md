# Facade Design Pattern – 

The best way to understand or getting a true feeling of what and how a `Facade` looks like,  
could be to just review/go through the following `HomeFacade.java` class  

`Facade hides the minor details and provide a simpler interface`  

`HomeFacade.java`  
```java
package com.design.pattern.facade;

import java.util.List;

import com.design.pattern.facade.devices.Fan;
import com.design.pattern.facade.devices.Light;
import com.design.pattern.facade.devices.SoundBar;
import com.design.pattern.facade.devices.TV;
import com.design.pattern.facade.devices.kitchen.CoffeeMaker;
import com.design.pattern.facade.devices.kitchen.ElectricGrill;
import com.design.pattern.facade.devices.kitchen.KitchenLight;
import com.design.pattern.facade.devices.kitchen.Microwave;
import com.design.pattern.facade.devices.kitchen.Refrigerator;
import com.design.pattern.facade.devices.livingroom.LivingRoomFan;
import com.design.pattern.facade.devices.livingroom.LivingRoomFireTV4KStick;
import com.design.pattern.facade.devices.livingroom.LivingRoomLight;
import com.design.pattern.facade.devices.livingroom.LivingRoomSoundBar;
import com.design.pattern.facade.devices.livingroom.LivingRoomTV;

/**
 * This is how a Facade looks like - 
 * 
 * Facade hides the minor details and provide a simpler interface
 * 
 * It basically provides a simplified interface to client as per client's specific needs, 
 *   if the need changes, a new facade has to be introduced
 * It is generally implemented for a single component or a group components, 
 *   that evolve to become very complex over the period of time.
 * It should never be implemented in the beginning of s/w development, 
 *   as it's not needed at that point in time, because all the components/subsytem are generally simple in nature.
 */
public class HomeFacade {

	Fan fan;
	LivingRoomFireTV4KStick stick;
	Light livingRoomLight;
	SoundBar soundBar;
	TV tv;

	CoffeeMaker maker;
	ElectricGrill grill;
	Light kitchenLight;
	Microwave microwave;
	Refrigerator refrigerator;

	public HomeFacade() {
		super();
		fan = new LivingRoomFan();
		tv = new LivingRoomTV();
		stick = new LivingRoomFireTV4KStick(tv);
		livingRoomLight = new LivingRoomLight();
		soundBar = new LivingRoomSoundBar(tv);

		maker = new CoffeeMaker();
		grill = new ElectricGrill();
		kitchenLight = new KitchenLight();
		microwave = new Microwave();
		refrigerator = new Refrigerator();
	}

	public void playMovieOnNetflix(String movieName) {
		fan.on();
		fan.increase();
		livingRoomLight.on();
		tv.on();
		((LivingRoomTV) tv).setSource("HDMI ARC");
		stick.on();
		soundBar.on();
		soundBar.setSoundMode("Dolby Atmos");
		stick.openApp("Netflix");
		stick.selectContent(movieName);
		((LivingRoomLight) livingRoomLight).dim();
		soundBar.volume(20);
		stick.play();
	}

	public void prepareFood(List<String> pizzaNames) {
		kitchenLight.on();
		// normally refrigerator runs always. so no need to turn on.
		refrigerator.partyMode(); // for fast cooling
		microwave.on();
		microwave.setOnPreHeat(200, 5);
		microwave.grillOn();
		grill.on();
		maker.on();
		pizzaNames.forEach(pizzaName -> microwave.bake(pizzaName, 400, 10));
	}

	public void stopMovie() {
		stick.closeApp();
		stick.off();
		soundBar.off();
		tv.off();
		((LivingRoomLight) livingRoomLight).bright();
		fan.off();
	}

	public void closeKitchen() {
		refrigerator.normalMode();
		grill.off();
		maker.off();
		microwave.off();
	}
}
```

**General Points:**  
1. It provides simplified methods required by the client
2. Facade layer should not be forced and its always optional
3. Subsystems are not aware of the existence of facade. Only facade talks to the subsystems.  
   it's unidirectional from Facade to its underlying subsystems.
4. Subsystem may be dependent with one another.  
   In such case, facade can act as a coordinator and decouple the dependencies between the subsystems.
5. GoF Definition: Provide a unified interface to a set of interfaces in a subsystem.  
   Facade Pattern defines a higher-level interface that makes the subsystem easier to use.

**Common Mistakes** while implementing Facade Pattern:  
1. just for the sake of introducing a facade layer developers tend to create additional classes.  
  Layered architecture is good but assess the need for every layer.  
  Just naming a class as ABCDFacade.java doesn’r really make it a facade.  
2. Facade layer should not be forced and its always optional.  
   If the client wishes to interact with components directly it should be allowed to bypass the facade layer.  
3. Methods in facade layer has only one or two lines which calls the other components.  
   If facade is going to be so simple it invalidates its purpose and clients can directly do that by themselves.  
4. A controller is not a facade. 
5. Facade is NOT a layer that imposes security and hides important data and implementation. 
6. Don't create a facade layer in advance -  
   After the subsystem has become complex you can implement the facade design pattern.
7. Subsystems are not aware of facade and there should be no reference for facade in subsystems.

Type-1:  
<img src="https://user-images.githubusercontent.com/26399543/152584295-692446c3-02eb-41ef-82a6-77f21596a14a.png" width="80%" height="80%">

Type-2:  
<img src="https://user-images.githubusercontent.com/26399543/152584324-85886474-16f0-4189-ab1f-1bca8b053b49.png" width="80%" height="80%">

**Comparison:**  
1. With **Mediator** - 
- `Facade Pattern` defines the simplifies interface to a complex system.
- `Mediator Pattern` provides a central communication point between components of a system.
2. With **Flyweight** - 
- `Flyweight Pattern` creates smaller reusable objects for the system.
- `Facade Pattern` creates single bigger objects to deal with the entire system.
3. With **Proxy** - 
- `Proxy Pattern` is similar to `Facade` except,  
   it provides same interface as it's service object to make complex objects interchangeable.
4. With **Abstract Factory** - 
- `Abstract Factory` is like Facade except it only handles the creation part of objects of the system/subsystem.  
- `Facade` handles system's objects operational part as well.  
5. With **Singleton** - 
- `Facade Object` normally we create as `Singleton` while implement since it serves for its purpose. 


**Reference(s):**  
1. DZone
2. Other random sources

