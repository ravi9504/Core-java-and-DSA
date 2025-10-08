package MultiThreading;

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
