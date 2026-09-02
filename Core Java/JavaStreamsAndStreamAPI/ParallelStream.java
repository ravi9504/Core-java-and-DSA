/*
    We can create parallelStream by
        n.parallelStream()         instead of n.stream() where n is a collection.
            Ex: long count= n.parallelStream().filter(i->i>100).count();
    ParallelStream may use multiple thread to process the data in parallel. It is used to improve the performance of the application.
        but parallelStream is not always faster than stream. It depends on the number of elements in the collection and the complexity of the operation performed on each element.
        it has costs:   . thread Coordination, .Splitting data, .Combining results, 
                        . Context and Synchronization overhead, . Possible ordering issues, 
                        . Problems with shared mutable state


        Example : List<Integer>result= new ArrayList<>();
                    n.parallelStream().forEach(result::add);
                  ArrayList is not safe for concurrent modification. Instead prefer stream collection
                    List<Integer>result=n.parallelStream().filter(i->i%2==0).toList();


Common Stream mistakes:::::
    Using forEach to build collections like above example using arraylist
    Reusing streams
    Mutating the source while streaming
        Ex: num.stream().forEach(num::add);  // num is the source collection, it is being modified while streaming
    Using streams for everything





    Stateless and Stateful operation
    Each element can generally be processed based primarily on the element itself. Then this operation said to be stateless. Ex. filter(), map(), peek()
    The operation may need information from other elements. And this operation is said to be stateful operation. Ex. sorted(), distinct()

    Q. Why limit can be very efficient?
    Execution can go like this filter---> reject
                                filter--> accept
                                filter--> reject
                                filter--> accept
                                limit() reached  ---- stop
    So the remaining element may not be processed at all for this pipeline. And this is 
    known as short-circuiting behaviour (this means as soon as the result or answer we get)



    Normal stream is sequential stream means one worker doing the all the job one by one.

    See you have 10 million numbers and ever number requires expensive calculation.
    With 1 thread to do this job is way more difficult. But in parallelstream 
    multiple portions is being processed. 
    There is a point if you have suitable work for parallel processing and our machine has enough 
    CPU resources, then this can be faster. 
    ! Parallel procession has overhead that's why parallelStream() does not automatically mean faster.

    What is overhead?
    Now imagine you have 10 books to shift to other shelf.
    Now you took help of 10 people to do this things. Now you have to 
    .explain the job    .Divide the books .give books to each person  .coordinate them
    .make sure everything is done  . collects the book/ results
    
    if you do this things by your own then it is more simpler and less time consuming. 
    This situation called overhead. Means no need to make complex but you did.


    Why ArrayList is unsafe for prallelStream()?
    Due to race consition ( means accessing array multiple thread at a 
    same time that make output inconsistent and unexpected result)
    Conceptually
    prallelstream do 
        Thread A------ partial result
        Thread B------ partial result
        Thread C------ partial result
         Framework combines them------ final list
    ArrayList do...
        Thread A-------|
        Thread B-------|--same ArrayList---- shared modification
        Thread C-------|


        Now in parallelstream() we need original order of elememt then 
        we use forEachOrdered() to print original order of element  but there is a trade off
        in we use this then we lost some of the benifit of parallelism so 

    Q. Where do the threads come from?
        parallelStream() does not normally create a new thread for every element.
        Prallel stream use java's Fork/Join framework.
        Conceptually
                prallelstream->fork/join framework-> worker threads-> task1, task2, task3
                Here work is divided into task that worker  threads execute
    What is fork/join framework?
    Fork-> divide the work
    join-> combine the work

    Operations present -> divided into small processes-> exceutes the operations by multiple threads
    -> combine the result-> final result
 */




public class ParallelStream {

    
}