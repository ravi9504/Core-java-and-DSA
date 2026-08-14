// package MultiThreading;

/*
    Multiprogramming (Running more than one program on a single computer) has two types: 1) Multi-User  2) MultiTasking

    1)Multi-user :- Running multiple users' their program simultaneously on single computer or machine

    2) Multi-tasking:- Single users doing multiple things simultaneously
        i) MultiThreading is the types of multiTasking




        How to achieve multiThreading?
        Thread class, Runnable interface.. Through these two we can achieve multithreading and we have to use Thread class (by extending the Thread class with the class that required multiThreading) all the time to achieve the multithreading evenif we use the Runnable interface because Thread class has mechanism to achieve multithreading
 */



// This is example of Thread class using two different class
/*
 
class myThread extends Thread{
    public void run(){     // We have overWrite the run in using Thread Class and Runnable Interface also

        int i=1;
        while (true) {
            System.out.println(i+ "Hello");
            i++;
        }

    }
}
public class basicsMultiThreading {

    public static void main(String args[]){
        myThread m= new myThread();
        Thread t= new Thread(m);
        // or    Thread t= new Thread(new myThread());

        t.start();     // this is to start the thread and it terminates automatically when it does their work
        // After starting the thread it runs program ahead and run below code also simultaneously
        int i=1;
        while(true){
            System.out.println(i+ "World");
            i++;
        } 
    }
}
 */


 // This is the example of the Thread class using same class

/*
 
public class basicsMultiThreading extends Thread{
   public void run(){
       int i=1;
       while (true) {
           System.out.println(i+" Hello");
           i++;
       }
   }
   public static void main(String[] args) {
       basicsMultiThreading b= new basicsMultiThreading();
       Thread t= new Thread(b);
       t.start();

       int i=1;
       while (true) {
           System.out.println(i+" Hello");
           i++;
       }
   }
}
 */


 // Example of Runnable interface using two different class

 /* 

 class myRunnable implements Runnable{
    public void run(){
        int i=1;
        while (true) {
            System.out.println(i+" Hello");
            i++;
        }
    }
 }
public class basicsMultiThreading{
    public static void main(String[] args) {
        myRunnable mr= new myRunnable();
        Thread t= new Thread(mr);
        t.start();

        int i=1;
        while(true){
            System.out.println(i+"World");
            i++;
        }
    }
}
 */ 

public class basicsMultiThreading implements Runnable{
    public void run(){
        int i=1;
        while (true) {
            System.out.println(i+" Hello");
            i++;
        }
    }

     public static void main(String[] args) {
        basicsMultiThreading b= new basicsMultiThreading();
        Thread t= new Thread(b);
        t.start();

        int i=1;
        while(true){
            System.out.println(i+"World");
            i++;
        }
    }
}


/*  A condition where two thread are to try access the same resource at the same time is 
  called as Race condition.To avoid this we use 'synchronized' keyword in java. It controls the
  access of multiple threads to any shared resource.


  Example:- two threads are trying to withdraw money from the same bank account at the same time.
  Account has 1000 but two threads are trying to withdraw 700 each at the same time.If we don't use 
  synchronized keyword then both threads will check the balance and see that it is 
  1000 and both will withdraw 700 each and account will go to -400 which is not possible in real 
  life. So to avoid this we use synchronized keyword.  

public synchronized void withdraw(int amount){
    if(balance>=amount){
        balance=balance-amount;
    }
    else{
        System.out.println("Insufficient balance");
    }}

    --> About the synchronized block:
    As we know that synchronized keyword in method then Everything will be locked in this method. 
    Instead of this we can lock the critical section of the code using synchronized block.
     It will lock only that part of the code which is critical section
      and rest of the code will be free to access by other threads.

      like this public void withdraw(int amount){
      // freely accessible code
        synchronized(this){
            if(balance>=amount){
                balance=balance-amount;
            }
            else{
                System.out.println("Insufficient balance");
            }
        }
        //freely accessible code
        }


        // Custom lock object:-  And if we want dedicated lock object for the critical section 
         then we can create a custom lock object and use it in synchronized block like this
        private final Object lock= new Object();
        public void withdraw(int amount){
            // freely accessible code
            synchronized(lock){
                if(balance>=amount){
                    balance=balance-amount;
                }   
                else{
                    System.out.println("Insufficient balance");
                }
            }
            //freely accessible code
        }   It avoids exposing the objects monitor as part of you synchronization policy.
         It is a good practice to use custom lock object instead of using 'this' keyword in synchronized block.


Volatile Keyword-> It used with variable in multithreading to have visibilty guarantees to threads
     like 
        private volatile boolean running=true;  // now when one thread writes
        running= false;
        // then other threads are guaranteed to observe the updated value under the Java Memory model's volatile rules
    ! Volatile does not make everything thread-safe 
    Ex->  volatile int count;  count++;
    this is not safe...
    Because count++ is effectively :   read count-> add i-> write count
    Multiple threads can interleave(mix) those operations
    So, volatile provides guarantee but does not make compound read-modify-write operation atomic

    For atomic operation
    We have atomic classes. Java provides java.util.concurrent.atomic
    Ex:-   AtomicInteger counter= new AtomicInteger(0);

    For Increment: counter.incrementAndGet();
    For get:  counter.get();
    For set: counter.set();

    Why atomic Integer?
     the operation is atomic  
      
      Thread A------
                    |atomic Increment
      Thread B------

    AtomicLong orderId= new AtomicLong(100000);
    long id= orderId.incrementAndGet();  // this will give unique id to each thread
    it could be useful for generating simple process local sequence numbers

    Locks-> Java provides explicit locks throught java.util.concurrent.locks package. 
    It provides more extensive locking operations than can be obtained using synchronized methods and statements. 
    Reeterant Lock-------  Reenterant-> A thread that already owns the lock can reacquire the lock without any problems.
    Example:-  ReentrantLock lock= new ReentrantLock();
     public void withdraw(int amount){
        lock.lock();
        try{
            if(balance>=amount){
                balance=balance-amount;
            }
            else{
                System.out.println("Insufficient balance");
            }
        }finally{
            lock.unlock();
        }   // finally is extremely important. Because if exception occurs and we didn't unlock then 
            then lock remain hold -> other threads may wait indefinitely.
     }

     Why use ReenterantLock instead of synchronized block?
     1) ReenterantLock has more features than synchronized block like tryLock(), lockInterruptibly(), newCondition() means multiple conditions etc
     2) ReenterantLock can be fair lock
Example if(lock.tryLock()){
     try(){
        // do something
} finally{
    lock.unlock();
}
else{
    // do something else
}


    ExecutorService-> This is industry level java.
    In real backend applications we should not create thread manually because it is costly and we should use thread pool to manage the threads.
    ExecutorService executor= Executors.newFixedThreadPool(10);  // this will create thread pool of 10 threads and we can submit the task to this thread pool
    executor.submit(new Runnable(){
        public void run(){
            account.withdraw(700);
        }
    });

    Why thread pools?
    For 10000 tasks-> 10000 threads
    Instead of 10000 thread we might use 10 threads + task queue. So, we can reuse the threads and it will be more efficient and less costly.
    Tasks-> queue->Thread Pool->worker threads->execute the task->return to thread pool

    !Important Executor methods
     .execute()-> used for tasks where we don't need a returned result.
     . submit()-> used for tasks where we need a returned result. 
     It returns Future object which can be used to get the result of the task.

     Example:- Future<Integer> future= executor.submit(()->{
        return 20+30;
     });Integer result= future.get();  // this will block the thread until the result is available
     Future-> represents the result of that may become available in future.
      It is a placeholder for the result of an asynchronous computation.

      shutdown() -> This method is used to shutdown the executor service. It will not accept any new tasks and will finish the existing tasks.
      shutdownNow() -> This method is used to shutdown the executor service 
      immediately. It will try to stop all the executing tasks and will not accept any new tasks.
      awaitTermination() -> This method is used to wait for the executor service to terminate. 
      It will block the thread until the executor service is terminated or the timeout occurs.




there is a important code snapshot who helped me to learn verberose version to short version
    verberose version:- 
    Runnable r= new Runnable(){
        public void run(){
        account.withdraw(700);
        }} 
        Thread t= new Thread(r,"Thread-A");

        Now shorter version....  In this code, there is a short introduction of lambda expression 
        which is used to implement the functional interface (Runnable interface is functional interface 
        because it has only one abstract method) and we can use lambda expression to implement the functional interface
        Thread t= new Thread(()->{
            account.withdraw(700);
        },"Thread-A");
 */