# Decorator Design Pattern – 

`Adding behavior w/o altering the class itself`  

`Augmenting behavior w/o inheriting the class`  

The idea is to augment existing objects with additional functionality  

So you already have classes defined and you want additional functionality in those classes,  
but you don't want to go into those classes and kind of rewrite them or change their existing code,  
because that would break the open closed principle.  

And also, you want to maybe keep the new functionality entirely separate,  
which is consistent with the single responsibility principle.  

However, you do want the constructs that you end up with to interact with existing structures.  
Somehow, you do want the decorated object to be compatible with an API that uses the old object.  

So, ultimately you have just two choices -   

First of all, if the class isn't final, then you can just inherit from that class,  
and you kind of automatically get some of the behaviors of that class and then you can build on top of that.  

And that is OK.

That is an OK implementation of the decorator generally.  

But some classes, like, for example, the `String` class,  
you cannot inherit from a `String` and give the string additional functionality.  

That's simply not possible.

So option number two is what we're going to look at, which is building a decorator,  
which is simply an object which references the decorate the object.  

Typically it aggregates it and it adds new functionality on the side.  

So, `the decorative design pattern facilitates the addition of behaviors to individual objects without directly inheriting from them.`  

**Facilitates the addition of behaviors to individual objects without inheriting from them**  

