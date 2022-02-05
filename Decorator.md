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

**Case-1:** extending behavior of final class (i.e. inheritance not possible)  

example: String.java is a final class, can not be inherited.  

so to extend the behavior of such class would be like follows:  

```java
class MagicString{
    // **Aggregation** - aggregating the actual object 
    private String string;
    
    public MagicString(String string) {
      this.string = string;
    }
    
    // override all the functions from String class or at least whichever is required or relevant
    // and then delegate the calls to String class methods
    public int length() {
      return string.length();
    }
    
    // here augment the additional behavior that are custom in nature - 
    public long getNumberOfVowels() {
      return string.chars().mapToObj(c -> (char)c).filter(c -> "aeiou".contains(c.toString())).count();
    }
    
    @Override
    public String toString() {
      return string;
    }
}

class Demo{
  public static void main(String[] args){
    MagicString s = new MagicString("hello");
    System.out.println(s + " has " + s.getNumberOfVowels() + " vowels");
  }
}
```

**Case-2:** extending behavior of a non-final class (i.e. inheritance is possible)  

```java
interface Shape
{
  String info(); // deliberately different from toString
}

class Circle implements Shape
{
  private float radius;

  Circle(){}

  public Circle(float radius)
  {
    this.radius = radius;
  }

  void resize(float factor)
  {
    radius *= factor;
  }

  @Override
  public String info()
  {
    return "A circle of radius " + radius;
  }
}

class Square implements Shape
{
  private float side;

  public Square()
  {
  }

  public Square(float side)
  {
    this.side = side;
  }

  @Override
  public String info()
  {
    return "A square with side " + side;
  }
}

// we are NOT altering the base class of these objects
// cannot make ColoredSquare, ColoredCircle

class ColoredShape implements Shape
{
  private Shape shape;
  private String color;

  public ColoredShape(Shape shape, String color)
  {
    this.shape = shape;
    this.color = color;
  }

  @Override
  public String info()
  {
    return shape.info() + " has the color " + color;
  }
}

class TransparentShape implements Shape
{
  private Shape shape;
  private int transparency;

  public TransparentShape(Shape shape, int transparency)
  {
    this.shape = shape;
    this.transparency = transparency;
  }

  @Override
  public String info()
  {
    return shape.info() + " has " + transparency + "% transparency";
  }
}

class DynamicDecoratorDemo
{
  public static void main(String[] args)
  {
    Circle circle = new Circle(10);
    System.out.println(circle.info());

    ColoredShape blueSquare = new ColoredShape(new Square(20), "blue");
    System.out.println(blueSquare.info());

    TransparentShape myCircle = new TransparentShape(new ColoredShape(new Circle(5), "green"), 50);
    System.out.println(myCircle.info());

    // cannot call myCircle.resize()
  }
}
```

**Reference:**  
1. Udemy

