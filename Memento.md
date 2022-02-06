Memento Design Pattern – 

It provides the **`ability to restore an object to its previous state`** (**`undo`** via **`rollback`**).  

Typically, the `Memento Design Pattern` should be used in situations where some actions are undoable,  
therefore requiring to rollback to a previous state.  
However, if the state of the Originator is heavy,  
using the Memento Design Pattern can lead to an expensive creation process and increased use of memory.  

**Example-1:**  

![image](https://user-images.githubusercontent.com/26399543/152692911-ac150de1-88ed-4408-bb70-5b559549c17e.png)  

**Example-2:**  

```java
/**
 * A Memento
 * 
 * @author manoranjan.kumar
 */
class Memento {
	private int balance;

	public int getBalance() {
		return balance;
	}

	public Memento(int balance) {
		this.balance = balance;
	}
}

class BankAccount {
	private int balance;

	public BankAccount(int balance) {
		this.balance = balance;
	}

	public Memento deposit(int amount) {
		balance += amount;
		return new Memento(balance);
	}

	public void restore(Memento m) {
		balance = m.getBalance();
	}

	@Override
	public String toString() {
		return "BankAccount{" + "balance=" + balance + '}';
	}
}

class Demo {
	public static void main(String[] args) {
		BankAccount ba = new BankAccount(100);
		Memento m1 = ba.deposit(50); // 150
		Memento m2 = ba.deposit(25); // 175
		System.out.println(ba);

		// restore to m1
		ba.restore(m1);
		System.out.println(ba);

		// restore to m2
		ba.restore(m2);
		System.out.println(ba);
	}
}
```

**Reference:**  
1. Udemy
2. https://www.youtube.com/watch?v=_Q5rXfGuyLQ

