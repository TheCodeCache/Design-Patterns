# Iterator Design Pattern –

The `Iterator pattern` provides a way to access the elements of an aggregate object sequentially without exposing it's underlying representation.  

**Problem** statement **:**  
Lets say there are two companies - **Company A** and **Company B**.  
They both maintain employee records for their respective employees and their implementation is something like below -  

Company_A :  
```java
public class CompanyAEmpRecords {
    private Employee[] companyEmployees = new Employee[10];
    private int index = -1;
 
    public void addEmployee(Employee newEmployee) {
        if (index == 10) {
            throw new RuntimeException("Maximum employee limit reached");
        }
        companyEmployees[index++] = newEmployee;
    }
 
    public void removeEmployee(String name) {
        // implementation to remove employee
    }
 
    public int getNoOfEmployees() {
        return index + 1;
    }
  
    public Employee[] getEmployees() {
        return companyEmployees;
    }
}
```

Company_B :  
```java
public class CompanyBEmpRecords {
    private List<Employee> companyEmployees = new ArrayList<>();
  
    public void addEmployee(Employee newEmployee) {
        companyEmployees.add(newEmployee);
    }
 
    public void removeEmployee(String name) {
        // implementation to remove an employee based on name
    }
 
    public int getNoOfEmployees() {
        return companyEmployees.size();
    }
  
    public List<Employee> getEmployees() {
        return companyEmployees;
    }
}
```

The main difference b/w above two employee records class is that,  
Company_A uses **`Array`** to hold the employee objects,  
Company_B uses **`List`** to hold the employee objects  

Let us now suppose, these two companies decided to merge and expand their business.  
Employees of both the companies will now be under one entity and then we need to create code,  
that lists down employees from both company  

```java
public class CompanyRecordsPrinter {
     
    public void printCompanyEMployeeRecords(CompanyAEmpRecords companyAEmpRecords, 
                                            CompanyBEmpRecords companyBEmpRecords) {
         
        Employee[] companyAEmployees = companyAEmpRecords.getEmployees();
        for(int i=0; i< companyAEmpRecords.getNoOfEmployees();i++) {
            System.out.println(companyAEmployees[i]);
        }
         
        List<Employee> companyBEmployees= companyBEmpRecords.getEmployees();
        for(Employee emp : companyBEmployees) {
            System.out.println(emp);
        }
    }
}
```

This does serve the purpose, as we are able to print employees from both companies using their records.  
But is it a good design? Two loops for two different types of data structures?  
What if Company C is merged with this later. Add a new loop to handle it? Nope. This is where iterator pattern comes into picture.  

**Solution:**  

We need to have a common interface called `Iterator` which will have methods like -  
- boolean hasNext()
- Object next()

Each Employee Record class will have a method called `getIterator()`  
that will basically return corresponding new instance of Iterator.  
Lets call it -  
- CompanyAEmpRecordsIterator
- CompanyBEmpRecordsIterator

Then we can have a common method that take an Object of type Iterator and iterate over it using `hasNext()` method  
and get the actual data using `next()` method.  

```java
public class CompanyAEmpRecords implements CompanyEmpRecords {
 
    private Employee[] companyEmployees = new Employee[10];
    private int index = -1;
 
    @Override
    public void addEmployee(Employee newEmployee) {
        # implementation
    }
 
    @Override
    public void removeEmployee(Employee oldEmployee) {
        # implementation
    }
 
    @Override
    public int getNoOfEmployees() {
        return index + 1;
    }
 
    @Override
    public Iterator getIterator() {
        return new CompanyAEmpRecordsIterator();
    }
 
    private class CompanyAEmpRecordsIterator implements Iterator {
 
        int currIndex = -1;
 
        @Override
        public boolean hasNext() {
            if (currIndex + 1 <= index)
                return true;
            else
                return false;
        }
 
        @Override
        public Object next() {
            if (currIndex + 1 <= index)
                return companyEmployees[++currIndex];
            else
                return null;
        }
    }
}
```

We need to have similar implementation for Company_B employee records as well.  

and then the printing logic will be as simple as this:  

```java
public class CompanyRecordsPrinter {
    public void printCompanyEMployeeRecords(CompanyAEmpRecords companyAEmpRecords, 
                                            CompanyBEmpRecords companyBEmpRecords) {
        printRecord(companyAEmpRecords.getIterator());
        printRecord(companyBEmpRecords.getIterator());
    }

    private void printRecord(Iterator recordIterator) {
        while(recordIterator.hasNext()) {
            System.out.println(recordIterator.next());
        }
    }
}
```

Notice, how we've been able to avoid writing loops as opposed to previous case.  
well, that's the advantage of using design patterns,  
it solves the problem in extendable, re-usable, cleaner and maintainable manner  

that's why while coding, we should constantly think of design patterns, solid principles, best practices etc.  

**Reference:**  
1. http://opensourceforgeeks.blogspot.com/2016/06/iterator-design-pattern.html

