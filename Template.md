# Template Design Pattern – 

It defines the sequential steps to execute a multi-step algorithm.  

It avoids code duplication and promotes code re-usability.  

**Example-1:**  

```java
package com.design.pattern.template;

abstract class Game {
	protected int currentPlayer;
	protected final int numberOfPlayer;

	public Game(int numberOfPlayer) {
		this.numberOfPlayer = numberOfPlayer;
	}

	/**
	 * template method
	 * 
	 * because no matter which game, as long as it's been played b/w two players,
	 * then the steps of the game is gng to be same
	 */
	public void run() {
		start();
		while (!haveWinner()) {
			takeTurn();
		}
		System.out.println("Player " + getWinningPlayer() + " wins");
	}

	protected abstract int getWinningPlayer();

	protected abstract void takeTurn();

	protected abstract boolean haveWinner();

	protected abstract void start();

}

class Chess extends Game {
	private int maxTurns = 10;
	private int turn = 1;

	public Chess() {
		super(2);
	}

	@Override
	protected int getWinningPlayer() {
		return 0;
	}

	@Override
	protected void takeTurn() {
		System.out.println("Turn " + (turn++) + " taken by player " + currentPlayer);
		currentPlayer = (currentPlayer + 1) % numberOfPlayer;
	}

	@Override
	protected boolean haveWinner() {
		return turn == maxTurns;
	}

	@Override
	protected void start() {
		System.out.println("Starting a game of chess");
	}

}

public class Demo {
	public static void main(String[] args) {
		new Chess().run();
	}
}
```

**Example-2:**  

```java
/**
 * abstract class House containing template method buildHouse and implementation
 * of steps which is same for all types of houses. Those implementations have
 * been marked as final.
 */
 
abstract class House {
    /**
     * This is the template method we are discussing. This method should be
     * final so that other class can't re-implement and change the order of the
     * steps.
     */
    public final void buildhouse() {
        constructBase();
        constructRoof();
        constructWalls();
        constructWindows();
        constructDoors();
        paintHouse();
        decorateHouse();
    }
 
    public abstract void decorateHouse();
    public abstract void paintHouse();
    public abstract void constructDoors();
    public abstract void constructWindows();
    public abstract void constructWalls();
 
    /**
     * final implementation of constructing roof - final as all type of house
     * Should build roof in same manner.
     */
    private final void constructRoof() {
        System.out.println("Roof has been constructed.");
    }
 
    /**
     * final implementation of constructing base - final as all type of house
     * Should build base/foundation in same manner.
     */
    private final void constructBase() {
        System.out.println("Base has been constructed.");
    }
}

class ConcreteWallHouse extends House {
      @Override
      public void decorateHouse() {
            System.out.println(“Decorating Concrete Wall House”);
      }
      @Override
      public void paintHouse() {
            System.out.println(“Painting Concrete Wall House”);
      }
      @Override
      public void constructDoors() {
            System.out.println(“Constructing Doors for Concrete Wall House”);
      }
      @Override
      public void constructWindows() {
            System.out.println(“Constructing Windows for Concrete Wall House”);
      }
      @Override
      public void constructWalls() {
            System.out.println(“Constructing Concrete Wall for my House”);
      }
}

class GlassWallHouse extends House {
    @Override
    public void decorateHouse() {
        System.out.println("Decorating Glass Wall House");
    }
 
    @Override
    public void paintHouse() {
        System.out.println("Painting Glass Wall House");
    }
 
    @Override
    public void constructDoors() {
        System.out.println("Constructing Doors for Glass Wall House");
    }
 
    @Override
    public void constructWindows() {
        System.out.println("Constructing Windows for Glass Wall House");
    }
 
    @Override
    public void constructWalls() {
        System.out.println("Constructing Glass Wall for my House");
    }
}

public class Demo {
      public static void main(String[] args) {
 
            System.out.println(“Going to build Concrete Wall House”);
 
            House house = new ConcreteWallHouse();
            house.buildhouse();
 
            System.out.println(“Concrete Wall House constructed successfully”);
 
            System.out.println(“********************”);
 
            System.out.println(“Going to build Glass Wall House”);
 
            house = new GlassWallHouse();
            house.buildhouse();
 
            System.out.println(“Glass Wall House constructed successfully”);
      }
}
```

**Comparison:**  
with **Strategy**:  It uses composition over inheritance to do the same stuff  
while **Template** uses inheritance over composition to do the same  


**Reference:**  
1. https://howtodoinjava.com/design-patterns/behavioral/template-method-pattern/
2. Udemy

