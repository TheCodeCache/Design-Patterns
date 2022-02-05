# Strategy Design Pattern – 

Thought process - 

"Many algorithms can be decomposed into higher and lower level parts.

**Example-1 : Process of making a tea** -   

The process of making a tea can be decomposed into something high level,  
like the process of making hot beverages (boil water, pour into cup)  
and it doesn't matter whether we're making tea or coffee or any other hot drink,  
we've to boil the water and we've to pour the water into a cup  
so, this is the high level part.  

and then we've the tea specific things. so after we've done the high level stuffs,  
what we can do is, we can take a tea bag put it into water, we can add milk or sugar oe lemon etc.  

So, the high level algorithm (the process of boiling water, pouring into cup) can then be reused.  
 
So, the tea specific things are specific, but everything else can be reused for making something else,  
like coffee or hot chocolate, for example.  

**Example-2 : Payment System** -  

https://www.youtube.com/watch?v=Nrwj3gZiuJU  

Assume, the current only supports payment through credit card, then the below impl. would just work fine.  

![image](https://user-images.githubusercontent.com/26399543/152636614-4752a917-dd83-496f-9fb4-d6af2f5f57ee.png)  

However, the problems may arise when we try to add support for more payment methods, like paypal, paytm, debit card, wallet etc.  

In this case, we need to wrap up our code within switch case or if-elseif ladder structure,  
and then introduce a new payment method like below:  

![image](https://user-images.githubusercontent.com/26399543/152636782-f657a371-7fb3-4f04-b0b1-7744742b4830.png)  

The above solution will indeed work in short term, but will be very hard to maintain in long term.  

what we just created above is a block of code that is closed for extension and open for modification.  
because everytime, a change is required (like adding/supporting a new payment method),  
we're gonna open this method and modify it.  
and `that violates the open/closed principle of SOLID principles`.  

Additionally, this class handles several functionalities, which violates `Single Responsibility` principle.  

To fix this we need to have a kind of strategy that places each payment method in its own class,  
making this class resposible for a particular payment method.  

Additionally, these classes should be easily interchangeable or replceable by one another.  


`Strategy Design Pattern` defines a family of algorithms, puts each of them in separate class,  
and make their objects interchangeable,  
**and to make objects interchangeable, we need to introduce a common interface among them**  

![image](https://user-images.githubusercontent.com/26399543/152637196-4c2e89bc-5223-4d2a-a1ea-226362e08188.png)  

or,  

![image](https://user-images.githubusercontent.com/26399543/152637312-bf7b6eb1-037a-425f-95f6-3564c6530f4d.png)  

now PaymentService.java should be something like this  

![image](https://user-images.githubusercontent.com/26399543/152637337-d1292de1-0a19-47e8-b6e1-3619a758aefc.png)

The above PaymentService class has no visibility on how the payment is being conducted and it should not,  
because it's making use of the Strategy Interface.  

![image](https://user-images.githubusercontent.com/26399543/152637800-eb363662-7708-4f2c-9c4f-6fa45606f8e3.png)  


![image](https://user-images.githubusercontent.com/26399543/152638645-9ea5f4a8-700d-48fd-8e39-a513f59eec5e.png)  

**Reference(s)**:  
1. DZone
2. https://www.youtube.com/watch?v=Nrwj3gZiuJU

