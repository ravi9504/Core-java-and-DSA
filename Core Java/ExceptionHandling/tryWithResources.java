import java.io.FileInputStream;
import java.util.Scanner;

//              Try with resources   (is introduced in Java 7 which help to close the resources automatically once it is done(autoclosable))

        /*
            As we use some resources (that is outside from program like reading file) and we don't close it. Then evenif we program does not need anymore but it is like program is using it.
            // Example of try without resources 
         */

public class tryWithResources {

    // Try without resources example

    // static Scanner s;
    // static FileInputStream f;

    static void Divide() throws Exception{     // this line means that this method can throw an exception and it should be handle through try and catch block if it is checked exception
    //     f=new FileInputStream("C:/Users/ravir/Downloads/my.txt");
    //     s=new Scanner(f);
    //     try{
    //     int a=s.nextInt();
    //     int b=s.nextInt();
    //     int c=s.nextInt();
    //     System.out.println(a/b);
    //     }
    //     finally{
    //         s.close();
    //         f.close();
    //     }


    // try with resources

    try(FileInputStream f=new FileInputStream("C:/Users/ravir/Downloads/my.txt"); Scanner s= new Scanner(f)){
        int a= s.nextInt();
        int b=s.nextInt();
        int c=s.nextInt();
        System.out.println(a/b);
    }
    }
    public static void main(String args[]){
        try{
        Divide();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}


/* why TRY WITH RESOURCES is  important in industry?
Imagine your backend recieves 1000 requests per second and each request is opening a file and not closing it.
 Then after some time your server will run out of resources and it will crash. 
 So to avoid this we use try with resources which automatically closes the resources
  once it is done. */

