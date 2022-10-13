# Chain of Responsibility Design Pattern – 

Use this pattern, when you encounter the need to execute several handlers in a particular order  
like this -  
![image](https://user-images.githubusercontent.com/26399543/152685580-cc3ece5d-6ddb-484f-a0bb-89cd3c575c85.png)  

The `chain of responsibility` is essentially just a chain of components,  
who all get a chance to process either a command or a query,  
and they can optionally have some sort of default processing implementation.  
And they can also terminate the processing chain and thereby preventing the rest of the objects in the chain  
to actually prevent them from processing this particular command query.  

**Implementation:**  
Suppose we're working on authentication app, and for a user to log-in to our platform,  
he or she must pass several checks.  

first we need to make sure that the username entered indeed exists in our server databases.  
and if not we've to prompt the user and suggest to sign-up  

and if the username does exist, we need to verify the password entered by the user  
matches with the password of his or her account.  
and if not we must alert the user that the password entered is not correct  

finally if both the checks are validated, we need to go over the admin users of our application,  
because if the user trying to log-in is an administration then we may have to enable additional  
admin pages for him/her or grant the specific rights etc.  

Database.java  
![image](https://user-images.githubusercontent.com/26399543/152686417-6e60feb4-2f24-4dab-aba7-e6b575ca4aef.png)  

Handler.java  
![image](https://user-images.githubusercontent.com/26399543/152686453-eab44c2d-d5a7-477a-92d2-3805c5468d66.png)

Specific Handlers  
![image](https://user-images.githubusercontent.com/26399543/152686816-033eb045-49db-4ced-a1dd-5d5147bcea5e.png)  

AuthService.java  
![image](https://user-images.githubusercontent.com/26399543/152686868-34121104-7537-400b-ae84-616edc064e43.png)  

**Reference:**  
1. https://www.youtube.com/watch?v=FafNcoBvVQo

