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
                    then List<Employee>pD= employee.stream().skip((long))
    
 */
class Employee{
    private int id;
    private String name;
    private double salary;


}
class basics {

    
}