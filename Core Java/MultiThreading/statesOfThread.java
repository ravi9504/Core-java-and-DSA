package MultiThreading;
/*
    (new)->start->(ready)-->run->(running)->end->(terminated)
    
    
    and running has three types:- wait, timed wait(sleep, wait) , blocked



    Every thread has its own priority and it is managed by scheduler part of JVM
    And multithreading service is provided by OS (operation system) but evenif OS does not have "JVM" has its own service
 */

 // Construcotr of the thread class:




 /*
 
 class myRun implements Runnable{
     @Override
     public void run(){}
 }
 
 class myThread extends Thread{
     public myThread(String name){
         super(name);
         setPriority(Thread.MIN_PRIORITY+2);
     }
 }
 
 public class statesOfThread {
    public static void main(String[] args) throws Exception {
         Thread t= new Thread(new myRun(),"My Run");   // here we give the argument as anonymous object of myRun class in Thread contrucotr as well as I provide the name to it
 
 
     myThread m= new myThread("Thread 1");
     System.out.println("ID of the thread"+m.threadId());   // here we can use getId also but it throws error so we use threadId       //  27
     // System.out.println("Priority of this thread"+ m.getPriority());     // 5    before setting priority means it is given by JVM
     System.out.println("Priority of this thread "+m.getPriority());  //Priority of this thread 3
     System.out.println("Class of this thread "+m.getClass()); 
     System.out.println("Name of this thread "+m.getName());
     // System.out.println("State odf this thread: "+m.getState()); //NEW
     m.start();
     System.out.println("State of the thread "+m.getState());   // RUNNABLE
     System.out.println("Is alive"+ m.isAlive());   // true
    }
 }
  */

  class myThread extends  Thread{
    public void run(){
        int i=0;
        while (true) {
             System.out.println(i++);
            try {
                Thread.sleep(100);
               
            } catch (InterruptedException e) {
                // TODO: handle exception
                System.out.println(e);
            }
        }
    }
  }
public class statesOfThread {

    public static void main(String[] args) {
        myThread t= new myThread();
        t.start();
        t.interrupt();
    }
}

// output
//  0
// java.lang.InterruptedException: sleep interrupted
// 1
// 2
// 3
// 4
// 5
// 6
// 7
// 8
// 9
// 10
// 11
// 12
// 13
// 14
// 15
// 16       forcefully closed