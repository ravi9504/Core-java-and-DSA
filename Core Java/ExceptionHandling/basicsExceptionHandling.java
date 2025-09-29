package ExceptionHandling;
// and a part that should be execute always whether there is exception or not anf for this we use 'finally' (last part of the try-catch block) 



/*
here object is mother class of all java classes.

    object
        ^
        |
        Throwable-->     Error
            |                                                                    EX
            ------->   Exception
                 _    
                |        |->classNotFoundException      --> If you are using an object the class that does not exist
                |        |->IOException                  --> If you accessing file that does not exist
                |        |-> InterruptedException        -->  related to multithreading...  if the threads stops abnormally then program throws this error
                |_       |-> NumberFormatException       --> If you gave number as an input in string form
                 _       |-> RuntimeException            --> This error thorws at run time
                |                |->ArithmeticException          --> division by 0
                |                |-> IndexOutOfBoundException    --> it has ArrayIndexOutOfBoundException and StringIndexOutOfBoundException
                |_                |->NullPointerException         --> you have a reference but there is no object


     ClassNotFoundException, IOException, InterruptedException, NumberException are checked Exception---> Means it must be operated through 'try-catch block'
     RuntimeException(ArithmeticException, IndexOutOfBoundException,NullPointerException) are unchecked Exception--> Means java will not force you to handle it (managed by jvm)
 */

public class basicsExceptionHandling {
    

      // Throws and throw
      
//  Throw and Throws difference 
/*
    'Throw is used to handle that what a program has exception'
    'Throws is used specify that method throws exception'
 */
    
      public static int meth1 (int l,int b )throws bankingException{
            if(l<0|| b<0){
                throw new bankingException(); 
            }
            else{
                int a=l*b;
                return a;
            }
        }
    public static void main(String args[]){
       /*  int a=10, b=0,c;
        c=a/b;
        System.out.println(c);
        System.out.println("bye");
        // the error is manage by 'JVM' and the error is 'java.lang.ArithmeticException: / by zero'
        */
/* 
 
int a=10; int b=0;int c;

try {
c=a/b;
System.out.println(c);    
} catch (Exception e) {
    System.out.println(e);// java.lang.ArithmeticException: / by zero   here we can see this thown error is same as the error during the runtime means it means if we fail to manage the runtime error the JVM manages it and throw the error
} finally {
    System.out.println("Bye"); // AS we discussed at the top this part will execute
}
*/

        /* 
         Nested try{...} catch{....}


         int arr[]={10,15,20,30,0};
         
         try {
             int c=arr[0]/arr[4];
             System.out.println(c);
             try {
                 System.out.println(arr[10]);
             } catch (ArrayIndexOutOfBoundsException e) {
                 System.out.println("Array's index is not valid");
             }
         } catch (ArithmeticException e) {
             System.out.println("The denominator should not be zero.");
         }
        */
                // Important Note-> Parent class of exception should be after the child class  because if parent class excutes before child class then the child class does not execute because it handled all child exception
        

        // Various method of Exception class -> String getMessage(), String toString(), void printStackTrace()
        // EX

        /*
         
        try {
            int a=0;
            int b=10;
            int c=b/a;
        } catch (Exception e) {
            // System.out.println(e.getMessage());    // output   (  / by zero    )
            System.out.println(e);   // output    java.lang.ArithmeticException: / by zero        if we write 'e' then it automaticall call toString method





            // printStackTrace
            System.out.println(meth3());
              this is output of the above line means this exception trace the error and th
              at ExceptionHandling.basicsExceptionHandling.meth1(basicsExceptionHandling.java:77)
           at ExceptionHandling.basicsExceptionHandling.meth2(basicsExceptionHandling.java:81)
           at ExceptionHandling.basicsExceptionHandling.meth3(basicsExceptionHandling.java:84)
           at ExceptionHandling.basicsExceptionHandling.main(basicsExceptionHandling.java:69)
             
    
            
    
       }
       static int meth1(){
           int a=10;
           int b=0;
           int c=a/b;
           return c;
       }
      static  int meth2(){
           return meth1();
       }
       static int meth3(){
           return meth2();
       }
        }
         */
        
        // try {
        //     int a=400;
        //     if(a>5000){
        //         System.out.println("Amount in your bank account is more than minimum required amount.");
        //     }
        //     else{
        //         throw new bankingException();
        //     }
        // } catch (bankingException bException) {
        //     System.out.println(bException);
        // }
        


        // example of throw and throws 
        /*
                whenever a method throw an exception then that method should be handle through the try and catch block
        
        try {
            meth1(-5, 10);
        } catch (bankingException e) {
            System.out.println(e);
        }
           */
 
        
    }
    




    
    // static void fun1(){
        //     FileInputStream f1= new FileInputStream("My.txt");   // this is the example of checked exception this has to be handle with the help of try-catch block or throws
        // }
        
        
      
    }

class bankingException extends Exception{
    public String toString(){
        return "The amount is your account is less than 5000 that is less than minimum required amount in your account";
    }
}








