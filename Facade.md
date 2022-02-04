# Facade Design Pattern – 

The best way to understand or getting a true feeling of what and how a `Facade` looks like,  
could be to just review/go through the following `HomeFacade.java` class  

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
 * It basically provides a simplified interface to client
 * It is generally implemented for a single component or a group components that evolve to become very complex over the period of time.
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

**Reference:**  
1. DZone
2. Other random sources

