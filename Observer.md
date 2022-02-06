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


