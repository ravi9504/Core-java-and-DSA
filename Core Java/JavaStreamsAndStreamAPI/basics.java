import java.util.*;
import java.util.stream.*;
/*
    Q. What problem does stream API solve?
        Suppose I have a list of employees and now my manager ask me to find the employees having salary greater 
        than 50000 sort them by salary and return only their name.
        In tradition java, it has multiple loops, temporary Collections more boiler plate logic is spread
        across several places. But with stream API
            List<String>n= emp.stream().
                              filter(e->e.getDepartment().equals("IT"))
                              .filter(e->e.getSalary()>50000).sorted(Comparator.comparing(Employee::getName))
                              .toList();
                                this is the power of stream API
    What is Stream?
        It is a sequence of elements that supports functional-style operations. Stream does not
        store the data(list stores). It processes that data

! IMPORTANT CONCEPT: STREAM PIPELINE
    Source->Intermediate operations->Terminal Operation
        Source-> Stream needs a source
            -> from collection
                    List<Integer>list=list.of(1,2,3);
                    Stream<Integer>stream= list.stream();
            -> from Array
                    int num[]= {1,2,3,4};
                    IntStream stream= Arrays.stream(num);
            -> Using Stream.of()
                    Stream<String> stream= Stream.of("Java","Spring","React");
            -> Infinite Streams
                    Stream.iterate(1,n->n+1).limit(10).forEach(System.out::println);

                    Intermediate vs Terminal
Intermediate -> they transform a stream into another stream
            Ex:  filter(), map(), sorted(), distinct(), limit(), skip(), peek(), flatmap()
            Ex. num.stream().filter(n->n>2).map(n->n*2);   Suprisingly, nothing may actually execute yet
Terminal-> they trigger the stream pipeline
            Ex: toList(), collect(), forEach(),count(), reduce(), findFirst(), findAny(), anyMatch(),
                allMatch(), noneMatch(), min(), max()

            ! Lazy Evaluation
        Means the stream pipeline will not be trigerred until the terminal operation is 
        not connected to it(or the stream pipeline)
            List<Integer> nums= List.of(1,2,3,4,5);
            Stream<Integer>stream= nums.stream().filter(n->
                {System.out.println("Filtering: "+n); return n%2==0;});
                Here "Filtering" will not print because there is no teminal operation.
                Now Stream.toList();
                    then processing happens
    Working?.......
        Stream creation-> Intermediate Operations-> No execution yet-> Terminal Operation-> Execution starts

        Memory And Execution Mechanism of java streams
    List<Integer> n= List.of(1,2,3,4,5);
    Stack                               Heap
        n-----------------------------> List Object
        |                                1,2,3,4,5
        |-------------> holds a refernce to the collection object

        When we write 
        Stream<Integer>stream= n.stream();
        It does not create new list rather create stream processing pipeline over a source

When is a new object actually created?
    Suppose 
            .map(Employee::getName);
             here map() operation transforms from Employee-> String 
                If your mapping function creates new object 
                    .map(employee->new employeeDTO(
                        empoyee.getId(),employee.getName()
                    ))

. Stream processing is often element-by-element 
    List<Integer>result= num.stream().filter(n->n%2==0).map(n->n*n).toList();
    In this filter works on each element to filter


    ->filter()-> used to select elements.
        How does filter() works?
            It accepts a predicate  Predicate<Integer>condition= n->n%2==0;
            A Predicate<T> returns true
            A Predicate<T> returns false
        If true-> element stays
        if false-> element is removed

    -> map() -> used to transform the data
        List<Integer>n= emp.stream().map(emp::getName).toList();
        Before-> Stream<Employee>
        After-> .map(Employee::getName) it becomes Stream<String>

filter() vs Map() 
    filter() decides should this element remain?
    map() decides what should this element become?

    -> sorted() -> used to start in ascending order or natural order
        List<Integer>sorted= numbers.stream().sorted().toList();

        Reverse Order
            List<Integer>result= numbers.stream().sorted(Comparator.reverseOrder()).toList()
    
    Sorting Objects
        sorting by salary:
            employee.stream().sorted(Comparator.comparing(Employee::getSalary)).toList()
        Descending:
            employee.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).toList();
    Multiple Fields:
    employee.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getSalary)).toList()

    -> distinct() -> remove duplicates
        List<Integer>nums= List.of(1,2,3,4,5,4);
        List<Integer>result= numbers.stream().distinct().toList();
        // Output  [1,2,3,4]
    !Important internally::: for objects, uniqueness depends on proper equality behaviour
        involving hashCode(), equals()
    
    -> limit() and skip()
        limit() takes only certain number 
            number.stream().limit(3).toList();
        skip() ingnores the first elements
            number.stream().skip(2).toList();
                Example     Real world pagination
                    int page=2; int size=10;
                    then List<Employee>pD= employee.stream().skip((long)page*size).limit(size).toList();
        Concept
            page 0-> 0-9                page 2-> 20-29
            page 1-> 10-19


    -> forEach() -> perform an action on every element
            n.stream().forEach(System.out::println);
        Equivalent to   n.stream().forEach(n->System.out.println(n));
             Real Example      emp.forEach(em->system.out.println(em.getName()));

        Talk about style-----------
            Bad Style..........      List<Integer>result= new ArrayList<>();
                                    n.stream().filter(n->n%2==0).forEach(n->result.add(n));
            Good Style..........     List<Integer>result= n.stream().filter(n->n%2==0).toList();

    ->count()
        Example: long count= employees.stream().filter(Employee::isActive).count();
            Why long?
                Because a stream could theoretically contain more elements than the maximum value of an int,
                so count returns a long to accommodate larger counts.
    
    -> min() and max()
        Example: Optional<Employee> minSalaryEmployee = employees.stream().min(Comparator.comparing(Employee::getSalary));
                 Optional<Employee> maxSalaryEmployee = employees.stream().max(Comparator.comparing(Employee::getSalary));
        Why Optional<Employee>? Because the stream might be empty, and in that case, 
        there would be no minimum or maximum employee to return. The Optional class is 
        used to represent the presence or absence of a value.
        Ex: max.ifPresent(System.out::println); or int value=max.orElse(0);
    
    -> findFirst() and findAny()
        Example: Optional<Employee> firstEmployee = employees.stream().filter(e->e.getDepartment().equals("IT")).findFirst();
                 optional because there may be no IT employees in the list or stream.
            findAny() is useful in parallel streams where you don't care which element you get, as long as it meets the criteria.
                employee.stream().filter(e->e.getSalary()>50000).findAny();
    Match Operations
        List<Integer>nums= List.of(1,2,3,4,5);
    ->anyMatch() -> returns true if any element matches the given predicate
        boolean hasEven= nums.stream().anyMatch(n->n%2==0);
    ->allMatch() -> returns true if all elements match the given predicate
        boolean allEven= nums.stream().allMatch(n->n%2==0);
    ->noneMatch() -> returns true if no elements match the given predicate
        boolean noneEven= nums.stream().noneMatch(n->n%2==0);
                Example Real world authorization
                    boolean hasAdmin= users.stream().anyMatch(user->user.getRole().equals("ADMIN"));
    !-> reduce() -> it combines multiple elements into a single summary value.
                    Ex: List<Integer>n= List.of(1,2,3,4,5);
                        int sum= n.stream().reduce(0,(a,b)->a+b);
                            Concept what happens here is 0+1=1, 1+2=3, 3+3=6, 6+4=10, 10+5=15
                            we can also write reduce(0,Integer::sum) which is equivalent to the above
                                0 is the indentity value for addition, meaning that adding 0 to any number doesn't change the number.
                        int product= n.stream().reduce(1,(a,b)->a*b);
                                1 is the indentity value for multiplication, meaning that multiplying any number by 1 doesn't change the number.
                        1*1=1, 1*2=2, 2*3=6, 6*4=24, 24*5=120
                Maximum using reduce
                        Optional<Integer> max= n.stream().reduce(Integer::max);  // no identity was provided, so the result is wrapped in an Optional to handle the case where the stream might be empty.
                Minimum using reduce
                        Optional<Integer> min= n.stream().reduce(Integer::min);

    -> Collect() and collectors()
        List<String>nam= emp.stream().map(Employee::getName).collect(Collectors.toList());
            Modern Java (Java 16 and later) introduced a more concise way to collect stream 
            elements into a list using the toList() method, which is part of the Stream 
            interface. This method simplifies the process of collecting elements into a list 
            without needing to explicitly use Collectors.toList().
        And collectors is much more powerful than toList() because it can do grouping, partitioning, joining, averaging, summing, etc.
        
        ->Collectors.toSet()-> remove duplicates and return a set
        ->joining() -> 
                Suppose List<String>nam=List.of("Ravi","Ramesh","Rakesh");
                String result= nam.stream().collect(Collectors.joining(","));   // Ravi,Ramesh,Rakesh
                    with prefix and suffix
                        String result= nam.stream().collect(Collectors.joining(",","[","]"));   // [Ravi,Ramesh,Rakesh]
        ->groupingBy() -> 
                Ex: List<Employee>emp;       group employees by department
                    Map<String,List<Employee>>gEmp= emp.stream().collect(Collectors.groupingBy(Employee::getDepartment));
                        conceptually,
                              IT- Ravi,Priya            Finance- Rahul,Anita
                              HR- Aman
        
    -> Group and Count
        Map<String,Long>countByDept=emp.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
            Conceptually,
                IT- 2
                Finance- 2
                HR- 1
    ->Group and calculate average salary
        Map<String,Double>avgSalaryByDept= emp.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
            Conceptually,
                IT- 55000.0
                Finance- 60000.0
                HR- 50000.0
        
        -> partitioningBy()-> this divides data into exactly two groups (of True and False).
            Ex: Map<Boolean,List<Employee>>result= emp.stream().collect(Collectors.partitioningBy(e->e.getSalary()>50000));
                Conceptually,
                    True- Ravi,Priya,Rahul
                    False- Anita,Aman
            Difference in groupingBy() and partitioningBy() 
                    is that groupingBy() can create multiple groups based on the key, 
                    while partitioningBy() creates only two groups based on a boolean condition.

    -> flatMap()-> it is used to flatten a stream of collections into a single stream of elements.
        Ex: List<List<Integer>>listOfLists= List.of(List.of(1,2),List.of(3,4),List.of(5,6));
            List<Integer>flatList= listOfLists.stream().flatMap(List::stream).toList();
                Conceptually,
                    1,2,3,4,5,6
            And if we map()       n.stream().map(list->list.stream()).toList();   // it will return List<Stream<Integer>> instead of List<Integer>

-> Primitive Streams
    Java provides specialized streams for primitive types to avoid the overhead of boxing and unboxing.
        IntStream, LongStream, DoubleStream
    Example: IntStream.range(1, 5).forEach(System.out::println); // prints 1, 2, 3, 4
                        Range and Sum
        int sum= IntStream.range(1, 5).sum(); // sum of 1,2,3,4 = 10   this is exclusive of 5
                Inclusive version
        int sum= IntStream.rangeClosed(1, 5).sum(); // sum of 1,2,3,4,5 = 15   this is inclusive of 5
        int sum= IntStream.of(1,2,3,4).sum(); // sum of 1,2,3,4 = 10
                        Average
        Optional doubleAverage= IntStream.of(1,2,3,4).average(); // average of 1,2,3,4 = 2.5
            double avg= doubleAverage.orElse(0.0); // if stream is empty, return 0.0
                                    Unboxing And Boxing
          Convert to IntStream
              IntStream s=n.stream().mapToInt(Integer::intValue);
          Convert back
                Stream<Integer> s= intStream.boxed();

!    Streams are single use
    Second usage throws IllegalStateException: stream has already been operated upon or closed
        Why? Because a stream is processing pipeline, and once it has been consumed 
        (i.e., a terminal operation has been called), it cannot be reused. 
        This is to prevent unexpected behavior and ensure that the stream's state remains 
        consistent.    Think ..... Collection-> Storage      Stream-> Processing flow
    
    -> peek() -> it is an intermediate operation that allows you to perform an action on 
    each element of the stream as it passes through, without modifying the elements 
    themselves. It is often used for debugging purposes to see the elements in the stream 
    at a certain point in the pipeline.
        Example: List<Integer>result= n.stream()
                        .filter(n->n%2==0).peek(n->System.out.println("Filtered: "+n))
                        .map(n->n*n).peek(n->System.out.println("Mapped: "+n)).toList();
            ! Avoid peek for business logic, as it is primarily intended for debugging and 
            logging. Using peek for business logic can lead to code that is harder to 
            read and maintain, and it may introduce side effects that are not immediately
             obvious.
 */

import java.util.List;

class Employee{
    private int id;
    private String name;
    private double salary;
    private String department;
    private boolean active;

    Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
    public String getDepartment() {
        return department;
    }

    public boolean isActive() {
        // Assuming an employee is active if their salary is greater than 0
        return this.salary > 0;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
}
class basics {
    public static void main(String args[]){
        List<Employee>emps= List.of(
           
            new Employee(7,"Suresh",0,"Finance"),
            new Employee(8,"Sunita",65000,"HR"),
            new Employee(9,"Rakesh",60000,"IT"),
            new Employee(10,"Rohit",70000,"Finance")
        );
        // List<Integer>gEmp=emps.stream().filter(e->e.getDepartment().equals("IT")).toList(); 
        // this thorws error because toList is introduced in java 16 and java version of 
        // codespaces is older than that. So we can use collect(Collectors.toList())
        List<Employee>gEmp=emps.stream().filter(e->e.getDepartment().equals("IT")).collect(Collectors.toList());
        // gEmp.forEach(System.out::println);
        // output Employee@2eafffde
            // Employee@59690aa4
            // Employee@6842775d
            // Employee@574caa3f
        gEmp.forEach(e->System.out.println(e.getName()+ " - " + e.getDepartment()+ " - " + e.getSalary()+ " - " + e.isActive()));
    }
    
}