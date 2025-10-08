package MultiThreading;

/*
    DaemonThread:- This Thread is background thread that provide service to the other thread and terminated when main thread terminates.
    Example:- Garbage Collector is thread that run automatically by JVM and terminates when main thread terminates

    Join Thread:- This threads provide collaboration and consistency. Join thread is used for that the other thread will not start until the   Join tread does not terminate. And it also provide consistency for a few moments like 100 miliseconds

    Yeild Thread:- This thread provide more opportunity to the other thread to execute.
 */



class myThread extends Thread{
    public void run(){
        // //For checking daemon thread
        // if(Thread.currentThread().isDaemon()){
        //     System.out.println("Daemon thread");
        // }
        // else{
        //     System.out.println("User Thread");
        // }
        int i=1;
        while (true) {
            System.out.println(i++ + "Thread");
        }
    }
}

public class daemonJoinAndYeild {

    public static void main(String[] args) throws InterruptedException{
        myThread t= new myThread();
        // myThread t2= new myThread();
        // myThread t3= new myThread();
        // t.setDaemon(true);     // This line should be always above the start() unless it will give error
        // t.start();  //Daemon thread
        // t2.start();  //User Thread
        // t3.start();  // User Thread

        // try {
        //     t.sleep(1000);
        // } catch (Exception e) {
        //     // TODO: handle exception
        //     System.out.println(e);
        // }

            // t.setDaemon(true);
        //     myThread t1= new myThread();
        //     myThread t2= new myThread();
        //     t.start();
        //     t.join();      // t1 will not start until the t thread does not terminates   (This line means)
        //             System.out.println(t.getState());
        //     t1.start();
        //     t1.join();
        //             System.out.println(t.getState());
        //     t2.start();
        //     t2.join();
        //             System.out.println(t.getState());
        // int i=1;
        // while(i<100){
        //     System.out.println(i++ +"Main");
        // }

        // YEILD

        t.start();
        t.yield();  // means t object of the mythread provides more opportunity to the other thread to execute
        int i=1;
        while (true) {
            System.out.println(i++ +" Main");
        }
    }
}