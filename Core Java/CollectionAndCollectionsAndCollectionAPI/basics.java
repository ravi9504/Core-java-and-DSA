import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.LinkedList;

class collections{
/*
 Collections is a utility class... It provides static methods for working with collections
    Ex:- Collections.sort(); // sorting in natural order (ascending order)
        -Collections.sort(num,Collections.reverse())// sorting in descedning order 
         // .reverse() for reverse the order of collections
        -Collections.shuffle(); // Randomly rearrange the List useful for things such as Random Quiz questions, Randomized games
        -Collections.max() and min() // for maximum and minimum
        -> Collections.binarySearch(n,30);  // searces a sorted list
 */
 public void fun(){
    List<Integer> num = new ArrayList<>();
    num.add(10);
    num.add(50);
    num.add(30);
    num.add(20);
    num.add(10);
    Collections.sort(num); // sorting in natural order (ascending order)    [10, 20, 30, 50]
    System.out.println(num); 

    Collections.shuffle(num);  // Randomly rearrange the List   [20, 50, 10, 10, 30]
    System.out.println(num);
   

    int max= Collections.max(num); // for maximum
    System.out.println(max);
    int min= Collections.min(num); // for minimum
    System.out.println(min);

    Collections.sort(num,Collections.reverseOrder()); // sorting in descedning order  [50, 30, 20, 10]
    System.out.println(num);
    Collections.reverse(num); // .reverse() for reverse the order of collections  [10, 20, 30, 50]
    System.out.println(num);
    int index= Collections.binarySearch(num,30);  // searces a sorted list
    System.out.println(index); 
    int frequency= Collections.frequency(num,10); // returns the number of occurrences of the specified element in the specified collection.
    System.out.println(frequency);


 }
    


}
class collection {
/*
    Collection is an interface....     public interface Collection<E>
    Example:- Collection<String> names= new ArrayList<>();

    Why does collections extend Iterable?
    Because it allows us to interate over elements. We can write
        for(String name:names){
        System.out.println(name);         // this is called enhanced for loop
        }
*/
    public void fun(){
        Collection<String> names= new ArrayList<>();
        names.add("Amit");
        names.add("Rohit");
        names.add("Sahil");
        names.add("Amit");
        for(String name:names){
            System.out.println(name);         // this is called enhanced for loop
        }
   
    // Iterator is based on iterator
    //Ex
    Iterator<String> it= names.iterator();
    while(it.hasNext()){
        System.out.println(it.next());}

        //Generics-> Provides type safety to the collection. It allows us to specify the type 
        // of objects that a collection can hold. For example, Collection<String> names= new ArrayList<>(); 
        // means that the collection can only hold String objects. If we try to add an object of a different type, 
        // it will result in a compile-time error. Ex
        // Collection num= new ArrayList(); // this is not type safe
        // nums.add(10);
        // nums.add("Hello"); // this is not type safe
        // Here the collection can hold any type of object, which can lead to runtime errors if we try to retrieve an object of a different type.
        Collection<Integer> nums= new ArrayList<>(); // this is type safe
        nums.add(10);
 }
 public void impMethod(){
    /*
     Some important methods of Collection interface are:
        - add(E e): Adds the specified element to the collection.
        - remove(Object o): Removes the specified element from the collection.
        - removeAll(Collection o): Removes all the element that are also present in another 
                               collection Ex: employees.removeAll(resignedEmployees).
        - contains(Object o): Returns true if the collection contains the specified element.
        - containsAll(Collection c): whether all elements of another collection exist
        - retainAll(Collection c): Keeps only elements that exist in another collection
        - size(): Returns the number of elements in the collection.
        - isEmpty(): Returns true if the collection is empty.
        - clear(): Removes all elements from the collection.
        - iterator(): Returns an iterator over the elements in the collection.
     */
    List<String> emp= new ArrayList<>();
    emp.add("Amit");  
    // used to add one element and returns boolean because some collection can reject duplicates
    emp.add("Rohit");
    emp.add("Sahil");

    System.out.println(emp);
    List<String> emp2= new ArrayList<>();
    emp2.add("Ravi");
    emp2.add("Mohit");
    emp2.add("Mayank");
    emp2.add("Amit");
    emp2.add("Sahil");

    System.out.println(emp2);
    emp.addAll(emp2); // adds all the elements from another collection
    // emp2.remove("Ravi"); // removes an element 
    // emp2.remove(0); // here in remove method , we give index of element instead of value
    // Here 0 does mean removing the value 0.      !Interview Trap
    // If we want to remove value 1 then  number.remove(Integer.valueOf(1))

    /*  .removeIf(Condition) : removing employee having some condition like 
     ex:  emp.removeIf( emp-> emp.startsWith("A"));

     In modern java it is more clean by using lambda expression    
     emp->emp.startWith("A");

     */

    // .toArray() -> Converting collection into an array   Ex String []ar= names.toArray(new String[0]);
    // .stream()-> allows you to process collection daya using the stream api
    // Example:- emp.stream().filter(name->names.startWith("R")).forEach(System.out::println)
 }
  public void list(){
        List<Integer>l= new ArrayList<>();
        l.add(6); // to add the element in the list
        l.add(1,5);  // to add the element in list on specific index
        l.add(3);
        l.add(8);
        l.set(3, 7); // to set or replace the value at specific index with the given value
        int i=l.lastIndexOf(3);
        int j= l.indexOf(6);
        System.out.println(i + " " + j);
        System.out.println(l.subList(0, 2)); 
        // here 0 is inclusive and 2 is exclusive
        ListIterator<Integer> li= l.listIterator();
        while(li.hasNext()){
            // int previous = li.previous();
            int next= li.next();
            System.out.print(next +" ");
        }
        System.out.println();
        while(li.hasPrevious()){
            int previous= li.previous();
            System.out.print(previous+ " ");
        }

        /*
            Operation                           Time Complexity
            get(i)                                 O(1)
            set(i)                                 O(1)
            add(end)                               O(1)
            add(i)                                 O(n) due to shift the element
            remove(i)                              O(n)
            contains()                             O(n)
 */
    }

    public void linkedList(){
        List<Integer>lis= new LinkedList<>();
        lis.add(4); lis.add(5); lis.add(7); lis.add(25);  lis.add(3);
        System.out.println(lis.get(2) + " "+ lis.get(3)); // used to get the data of specific of index of the list if it fails then throws exception
        // lis.removeFirst()    lis.removeLast()    used to remove the element based on index of first or last if it fails then it throws NoSuchElementException
        // lis.offerFirst()  lis.offerLast()  used to retrieve the data from the first and last respectively and return true on success and if it fails then it return false
        // lis.peakFirst()  lis.peakLast() used to retrieve the data from the first and last respectively and it throws null instead of throwing exception
        // lis.pollFirst()  list.pollFirst() used to retrieve the data from the first and last respectively and it throws null instead if raising the exception
    }

    public void hashMap(){
        /*
           .put()-> insert the key and values
                emp.put(101,"Ravi");
                emp.put(102,"Amit"); if the key is already exist emp.put(101,"Rahul");
                Now 101-> Rahul old value Ravi is replaced because Map allows unique key,duplicate values
            .get()-> retrieve the value 
                emp.get(101); -> Ravi
                emp.get(999); -> null // key does not exist
            
         */
    }

   
}
class collectionFramework{
    /*
     Java  Collection Framework(JCF)/api is the complete architecture of interfaces, class and utilities used to 
    store and manipulate group of Objects.
    It solves the problem of  ->fixed size like you have an array of 5 elements and suddenly you need to store 
    100 products . -> Searching can be inefficient  example empId with 1056 in 10000 emp is difficult
    -> Different requirements need different data structure like storing data with duplicates
    sometimes dupicates not allowed, sometimes key value pair etc.  

    JCF provides Interfaces, Implementations, Algorithms, Utility Methods, Iteration mechanism.
                                  Iterable
                                    |
                                JCF(Java Collection Framework)
            |                          |                            |
            Queue                   List                            Set
            | Priority Queue        | ArrayList                     |HashSet
            |  ArrayDeque           | LinkedList                    | LinkedHashSet
            |  Vector               | Stack                         | TreeSet

Map separately    Map has HashMap, LinkedHashMap, TreeMap
! Map is a part of Collections framework but Map does not extend collection

Collection Framework ecosystem
CF has Interfaces,Implementation, Map Hierarchy, Utility Algorithms
        Interfaces have Collection,List, Set, Queue, Deque
        Implementations have ArrayList,LinkedList,HashSet,TreeSet, PriorityQueue, ArrayDeque
        Map Hierarchy have HashMap, LinkedHashMap, TreeMap, ConcurrentHashMap
        Uitlity Algorithms have sort(), reverse(), shuffle(), max(), min(), frequency()


     */

}

class basics{
    public static void main(String args[]){
        
        // collections c= new collections();
        // c.fun();
        collection cl= new collection();
        // cl.fun();
        // cl.list();
        cl.linkedList();
    }
}

/*
        iterator()      collection method
    Why do we need Iterator?
    -> Suppose you want to remove elements while iterating like 
            for(String name= names){
            if(names.equals("Ravi")){
            names.remove(name);
            }
            }
            this result ConcurrentModificationException (unchecked runtime exception in java that occurs when collection is structurally modified 
            while it is being iterated over) this excpetion can be in single threaded and multi threaded enoviornment

            Why does it happen?
            -> Collection classes like ArrayList, HashMap, HashSet provide fail-fast iterators. 
            The Counter-> Collections tracks its strucural changes using internal counter called modCount.
            The Check-> When an iterator is created, it takes a snapshot of this value (expectedModCount).
            Exception-> During every loop, iterator compares modCount and expectedModCount. If not match then throws exception 

            Common Triggers
        -> Enhanced For Loop : For uses an iterator behind the scenes. If we call the collections own 
            remove() or add() method inside this loop then iterator loses sync.

            How to avoid it?
            -> use iterator.remove(); /. removing elements, use an explicit iterator and call its own 
            remove() method. The iterator handles updating the counter internally so it does not fail.

        


            ! Set has no extra method they have collection method. It has no indexing and ordering properties
    
    HashSet declaration -> No duplicates allowed and no guaranteed iteration order
    Set<String>s=users= new HashSet<>();   // It is based on hashing
    HashSet is fast. Conceptually "Ravi"->hashCode()-> hashValue->bucket

    LinkedHashSet declaration -> maintains insertion order 
    Set<String>skills= new LinkedHashSet<>();
    It is useful when no duplicates + predicatable insertion order

    TreeSet declaration ->  keep elements sorted into its ordering 
        Set<Integer> n= new TreeSet<>();

        operations   add, remove, contains -> O(log n)


    Queue is designed for the processing the elements
    Methods with difference 
    Operation                   Exception version                  Special Version
    Insert                          add()                               offer()
    Remove                          remove()                            poll()
    Inspect                         element()                           peak()
    
    For an empty queue remove, element give excpetion 
    But poll and peak give null

    PriorityQueue does not behave like a normal FIFO queue. It processes according to priority/order
    ex-  PriorityQueue<Integer>q= new PriorityQueue<>();
         q.add(50); q.add(10)
         Now q.poll() return 10 because the smalles element has the highest priority under natural ordering
         RealWorld priorityQueue
            Hospital Emergency System
                -Normal Patient
                -Critical Patient
                -Emergency patient
    
    Deque-> Double Ended Queue can perform addFirst(), addLast(), removeFirst(), removeLast(),
            removeLast(), peekFirst(), peekLast()
    
    ArrayDeque- important implementation of deque 
                                Deque<String>ad= new ArrayDeque
                            can use it as queue
                                ad.offerLast("A"),ad.pollFirst("B")
                            can use it as stack 
                                ad.push("A"),ad.pop()
        Modern java code generally prefers ArrayDeque over the stack class
 */