# Prototype Design Pattern – 

It's all about copying an object, and with copying, we generally meant to do a deep copy.  

Let us consider this Person class,  

```java
class Person
{
  public String [] names;
  public Address address;
  
  public Person(String[] names, Address address)
  {
    this.names = names;
    this.address = address;
  }
  . . .
}
```
Let us create a person object  
```java
Person john = new Person(new String[]{"John", "Smith"},
      new Address("London Road", 123));
```
Now, let us copy the above object and create a new instance  
```java
// shallow copy, not good 
Person jane = john;
```
if we do like above, then we'll end up copying the reference of john object,  
and thus in case of any modification to jane, will propagate to john object as well,  
because we simply copied the reference, (shallow copy)  

we could solve this problem using Cloneable interface like below  

```java
import java.util.Arrays;

// Cloneable is a marker interface
class Address implements Cloneable {
  public String streetName;
  public int houseNumber;

  public Address(String streetName, int houseNumber)
  {
    this.streetName = streetName;
    this.houseNumber = houseNumber;
  }

  @Override
  public String toString()
  {
    return "Address{" +
      "streetName='" + streetName + '\'' +
      ", houseNumber=" + houseNumber +
      '}';
  }

  // base class clone() is protected
  @Override
  public Object clone() throws CloneNotSupportedException
  {
    // instead of doing super.clone() which gives shallow copy, use new operator to create instance 
    return new Address(streetName, houseNumber);
  }
}

class Person implements Cloneable
{
  public String [] names;
  public Address address;

  public Person(String[] names, Address address)
  {
    this.names = names;
    this.address = address;
  }

  @Override
  public String toString()
  {
    return "Person{" +
      "names=" + Arrays.toString(names) +
      ", address=" + address +
      '}';
  }

  @Override
  public Object clone() throws CloneNotSupportedException
  {
    return new Person(
      // clone() creates a shallow copy!
      /*names */ names.clone(),

      // fixes address but not names
      /*address */ // (Address) address.clone()
      address instanceof Cloneable ? (Address) address.clone() : address
    );
  }
}
```

Now by doing the above changes using Cloneable insterface, we did solve the problem,  
but **`using Cloneable is NOT recommended`**  


Now, typically, implementation of Cloneable is not recommended.  
So, if you read the literature, nobody ever tells you that you should be implementing Cloneable  
whenever you want deep copying to be done,  
because unfortunately, cloning doesn't really state what the cloning method does.  
And the default behavior of clone is to actually perform a shallow copy as opposed to a deep copy.  
And what we really want in most cases is a deep copy and it's better to use other mechanisms

**Copy Constructor:**  

```java
class Address
{
  public String streetAddress, city, country;

  public Address(String streetAddress, String city, String country)
  {
    this.streetAddress = streetAddress;
    this.city = city;
    this.country = country;
  }

  public Address(Address other)
  {
    this(other.streetAddress, other.city, other.country);
  }

  @Override
  public String toString()
  {
    return "Address{" +
      "streetAddress='" + streetAddress + '\'' +
      ", city='" + city + '\'' +
      ", country='" + country + '\'' +
      '}';
  }
}

class Employee
{
  public String name;
  public Address address;

  public Employee(String name, Address address)
  {
    this.name = name;
    this.address = address;
  }

  public Employee(Employee other)
  {
    name = other.name;
    address = new Address(other.address);
  }

  @Override
  public String toString()
  {
    return "Employee{" +
      "name='" + name + '\'' +
      ", address=" + address +
      '}';
  }
}

class CopyConstructorDemo
{
  public static void main(String[] args)
  {
    Employee john = new Employee("John",
      new Address("123 London Road", "London", "UK"));

    //Employee chris = john;
    Employee chris = new Employee(john);

    chris.name = "Chris";
    System.out.println(john);
    System.out.println(chris);
  }
}
```

The Copy-Constructor approach is actually better than Cloneable interface for creating a deep-copy of an object  

but the downside is, we've to build a copy constructor for every single type that we've,  
for ex: if we've 20 types in the class hierarchy or the object-graph,  
then we'd need to write 20 copy-constructors one for each type  

so, the solution to this downside of copy-constructor is to copy through serialization as follows:  

**Copy through Serialization:**  

Given a complicated hierarchy of types, how can you actually copy the objects?  

```java
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

// some libraries use reflection (no need for Serializable)
class Foo implements Serializable
{
  public int stuff;
  public String whatever;

  public Foo(int stuff, String whatever)
  {
    this.stuff = stuff;
    this.whatever = whatever;
  }

  @Override
  public String toString()
  {
    return "Foo{" +
      "stuff=" + stuff +
      ", whatever='" + whatever + '\'' +
      '}';
  }
}

class CopyThroughSerializationDemo
{
  public static void main(String[] args)
  {
    Foo foo = new Foo(42, "life");
    // use apache commons!
    Foo foo2 = SerializationUtils.roundtrip(foo);

    foo2.whatever = "xyz";

    System.out.println(foo);
    System.out.println(foo2);
  }
}

```

**Reference:**  
1. Udemy

