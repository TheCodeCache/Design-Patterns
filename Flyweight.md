# Flyweight Design Pattern – 

This design pattern is concerned with **`space optimization`**  

When we're storing lots of data, then we'd like to avoid any redundancy in data while storing.  

it's kind of like compression in images.  

if we've the same block repeating over and over again, we'd probably like to avoid write each one of them, instead  
we'd like to write it once and say how many times it repeats.  

the above definition is also quite similar to **`run-length encoding`** mechanism for text compression  

**Example-1:**  
In online games,  
We're going to have lots of people called John Smith,  
but we're also going to have lots of people called John and lots of people whose last name is Smith.  
And, there is no point in actually storing the same first and last name combinations over and over again  
because we'll be simply wasting memory.  
So what we would do instead is we would store a list of names somewhere else and then we would keep  
the pointers to those names and link through pointers.  

In other words -  
`in the context of database, we can maintain all the first names and last names in separate columns in one table,
and then we can have the index as a number pointing into that table.`  
This is the essence of `Flyweight Pattern`  

So, the flyweight design pattern is quite simply a space optimization technique,  
that allows us to use less memory by storing some of the common data that's common to several items or several data objects  

**Example-2:**  

Let us suppose, we've this Book DTO -  

![image](https://user-images.githubusercontent.com/26399543/152644369-dd983bfb-f4a0-44d3-b4ac-989df04ae04e.png)  

If we carefully observe its attributes, it's like below  

attributes name and price could be very specific to individual book,  
however the attributes like type, distributor and otherData need not be.  
that means these attrs (type, distributor etc.) are shareable in nature across book objects  

if we store such book object, then we'll end up storing every attribute for each book object,  
even though some of them are common across multiple book objects  

for ex: the size in memory for one book object = sum (sizeOf(name) + sizeOf(price) + sizeOf(type) + sizeOf(distributor) + sizeOf(otherData))  
if we've a million object, then we'll end up storing -  
1 million * sum (sizeOf(name) + sizeOf(price) + sizeOf(type) + sizeOf(distributor) + sizeOf(otherData))  

which is waste because we're saving redundant data (like type, distributor names) which could be common across multiple objects.  

That's where flyweight design pattern comes into play,  
and saves space by storing the data elements separately and referencing them through pointer whenever we need them  

<img src = "https://user-images.githubusercontent.com/26399543/152644729-0712227e-8229-4afe-80da-a5cb5cda63ef.png" width="60%" height="60%">  

<img src = "https://user-images.githubusercontent.com/26399543/152644750-4d58b96e-8caf-4384-895b-f696fdce31e9.png" width="60%" height="60%">  

<img src = "https://user-images.githubusercontent.com/26399543/152644792-f6808904-a82e-4cb9-9e73-8bf40cdb7d6a.png" width="60%" height="60%">  

**Reference(s):**  
1. https://www.youtube.com/watch?v=qscOsQV-K14
2. Udemy

