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
 */
class basics {

    
}