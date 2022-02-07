# Adapter Design Pattern – 

It's a construct which adapts an existing interface X to conform to the required interface  

Allows objects with incompatible interfaces to collaborate with each other  

It uses `inheritance` and `composition` to enable objects with incompatible interfaces to collaborate with one another  

**Implementation:**  

Suppose we've MultiRestoApp that works only with XML Data as follows:  

![image](https://user-images.githubusercontent.com/26399543/152834812-23683c8c-3749-4396-8e36-2b95e62b47aa.png)  

This app is being used by UI app that works only with JSON data as follows:  

![image](https://user-images.githubusercontent.com/26399543/152835052-bdfa3519-5e2b-4fb2-a994-f09633ee8c6b.png)  

Since they two work with different represenations of data, hence they can not work with each other.  
To solve this issue, we can use `Adapter Pattern` to allow the collaboration b/w these two possible  

![image](https://user-images.githubusercontent.com/26399543/152835445-da75bbbd-21a4-46ab-bfc5-99e65bff6564.png)  

Client.java  
![image](https://user-images.githubusercontent.com/26399543/152835536-6aff736e-dfd7-42ad-b3fe-2b41a28c9ad0.png)  

**Reference:**  
1. https://www.youtube.com/watch?v=wA3keqCeKtM

