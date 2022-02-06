# Observer Design Pattern – 

An `Observer` is an object that wishes to be informed about events happening in the system.  
The entity generating the events is an `Observable`  

**Problem:**  
Let us assume, we own a shopping store, and in this store, we sell all kinds of stuffs,  
so, one day a customer approahces us and asks about a particular item,  
now, because we don't have it immediately but we 'll be getting sometime soon in the future,  
so, we tell the customer, to come back later in few days.  

Here the customer and we have two options:  
Case-1: customer could either visit the store everyday and check for the product's availability,  
this option could be pointless, if the product is still unavailable  
Case-2: we as an store owner, could send an email to all the cutomers each time, a new product  
becomes available.  
while this could save a few customers trips to the store, at the same time, it could upset our  
other customers who aren't interested in these products, and they will most likely consider it  
spam  

So, what we need is kind of a sbscription mechanism, where our customers can choose when and  
based on what to be notified or even if they want to be notified at all,  

and to design such a system, that's where Observer Pattern comes to help  

This pattern notifies multiple objects or subscribers abot any events that happen to the object,  
they're observing or publisher  


![image](https://user-images.githubusercontent.com/26399543/152671074-e973112d-3eb7-4d94-8a04-8d382ec90d9d.png)  

Store class holds the reference of NotificationService, so that we should be able to notify whenever a new item  
is arrived.  

**JDK support for Observer Pattern** -  

JDK supports this pattern since 1.0 version through java.util.Observer and java.util.Observable interfaces  

Observer interface isn't perfect and is deprecated since Java 9.  
One of its cons is that Observable isn't an interface but a class, that's why subclasses can't be used as observables.  

Also, a developer could override some of the Observable‘s synchronized methods and disrupt their thread-safety.  

**`ProperyChangeListener`** -  
It is the recommended way instead of Observer  

In this implementation, an observable must keep a reference to the `PropertyChangeSupport` instance.  
It helps to send the notifications to observers when a property of the class is changed.  

```java
package com.design.pattern.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


/**
 * Observer
 * 
 * @author manoranjan.kumar
 */
public class PCLNewsChannel implements PropertyChangeListener {

	private String news;

	public void propertyChange(PropertyChangeEvent evt) {
		this.setNews((String) evt.getNewValue());
	}

	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}
}

/**
 * Observable
 * 
 * @author manoranjan.kumar
 */
public class PCLNewsAgency {
	private String news;

	private PropertyChangeSupport support;

	public PCLNewsAgency() {
		support = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}

	public void setNews(String value) {
		support.firePropertyChange("news", this.news, value);
		this.news = value;

	}
}

public class Demo {

	public static void main(String[] args) {
		PCLNewsAgency observable = new PCLNewsAgency();
		PCLNewsChannel observer = new PCLNewsChannel();

		observable.addPropertyChangeListener(observer);
		observable.setNews("news1");

		System.out.println(observer.getNews());
	}
}
```

**Reference:**  
1. https://www.baeldung.com/java-observer-pattern

