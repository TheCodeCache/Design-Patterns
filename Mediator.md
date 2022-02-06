# Mediator Design Pattern – 

A component that facilitates communication b/w other components  
w/o necessarily being aware of each other or having direct (reference) access to each other  

In an application like `chat room`,  
components may go in and out of the system at any time  

for ex: set of participants in a chat room, or a set of players in an online game  
or a set of airplanes trying to land on the airport  

So, it makes no sense for the different participants to have direct references to one another,  
because those references can go dead at any time.  

So the solution here is to have all of the components refer to some sort of central component,  
that facilitates communication, and that component happens to be the `mediator`.  

So, the mediator design pattern necessitates a component  
that simply facilitates communication between the different components  
w/o them necessarily being aware of each other or having direct or referential access to one another.  

**Example:**  

```java
import java.util.ArrayList;
import java.util.List;

class Person
{
  public String name;
  public ChatRoom room;
  private List<String> chatLog = new ArrayList<>();

  public Person(String name)
  {
    this.name = name;
  }

  public void receive(String sender, String message)
  {
    String s = sender + ": '" + message + "'";
    System.out.println("[" + name + "'s chat session] " + s);
    chatLog.add(s);
  }

  public void say(String message)
  {
    room.broadcast(name, message);
  }

  public void privateMessage(String who, String message)
  {
    room.message(name, who, message);
  }
}

class ChatRoom
{
  private List<Person> people = new ArrayList<>();

  public void broadcast(String source, String message)
  {
    for (Person person : people)
      if (!person.name.equals(source))
        person.receive(source, message);
  }

  public void join(Person p)
  {
    String joinMsg = p.name + " joins the chat";
    broadcast("room", joinMsg);

    p.room = this;
    people.add(p);
  }

  public void message(String source, String destination, String message)
  {
    people.stream()
      .filter(p -> p.name.equals(destination))
      .findFirst()
      .ifPresent(person -> person.receive(source, message));
  }
}

/**
 * Chat Room Demo
 */
public class Demo
{
  public static void main(String[] args)
  {
    ChatRoom room = new ChatRoom();

    Person john = new Person("John");
    Person jane = new Person("Jane");

    room.join(john); // no message here
    room.join(jane);

    john.say("hi room");
    jane.say("oh, hey john");

    Person simon = new Person("Simon");
    room.join(simon);
    simon.say("hi everyone!");

    jane.privateMessage("Simon", "glad you could join us!");
  }
}
```
