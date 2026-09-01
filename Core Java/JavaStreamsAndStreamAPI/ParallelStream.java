/*
    We can create parallelStream by
        n.parallelStream()         instead of n.stream() where n is a collection.
            Ex: long count= n.parallelStream().filter(i->i>100).count();
    ParallelStream may use multiple thread to process the data in parallel. It is used to improve the performance of the application.
        but parallelStream is not always faster than stream. It depends on the number of elements in the collection and the complexity of the operation performed on each element.
        it has costs:   . thread Coordination, .Splitting data, .Combining results, 
                        . Context and Synchronization overhead, . Possible ordering issues, 
                        . Problems with shared mutable state

 */
public class ParallelStream {

    
}