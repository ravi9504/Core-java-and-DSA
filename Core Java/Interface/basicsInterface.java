package Interface;


/*  All interface is like by default abstract class and abstract method (by default) in interface.
    To inherits the interface Java use 'implements'
    
*/

interface test{
    void meth1();
    void meth2();
}
interface test1 extends  test{
    void meth4();
    default void meth5(){
        System.out.println("This is default method it is used java 8 version onwards"); // but this method cannot be accessed by '.' operation
    }
    // use of default mehtod is that if we create the method is abstract, we have to override the method but now in default method no need of overriding and it is accessible through implemented class.....     
    // One more use of defalut method is that if in future we want to modify the interface then the call will become abstract so that it was not possible to modifing the interface so we use default method to modify the interface..



    // In java 9, private method is also allowed without abstract keyword. And the use of that private method is being by default method 
    private void meth6(){
        System.out.println("This is meth6 which is private but it is used by default method");
    }
    default void methd(){
        meth6();
    }

}
class my implements test1{    // if we inherits the interface then class will also become abstract so that we have to override the interface's method
   public void meth1(){
        System.out.println("This is meth1 which is overrided from test interface");
    }
    public void meth2(){
        System.out.println("this is meth2 which is overrided from test interface");
    }
    public void meth4(){
        System.out.println("The extended method of interfaces meth4");
    }
    public void meth3(){
        System.out.println("this is meth3");
    }

}



class  phone{
    public void call(){     // If the method of the class is created without access specifiers then it can be access within the package only means without access modifier create method in class is private for the outside of the package and public for the outside of the class
        System.out.println("Phone call");
    }
    public void sms(){
        System.out.println("Phone sending sms");
    }
}
interface iCamera{
    public void click();     // the method in interface is by default public because if it is private then it cann't be overrided . So the method is written with the public access specifier or without access specifier
    void record();
}
interface iMusicPlayer{
    void play();
    void stop();

}

class smartPhone extends phone implements iCamera,iMusicPlayer{   // we can implements one or more interfaces at a time or in a class
    public void click(){
        System.out.println("The photo is clicked");
    }
    public void record(){
        System.out.println("The video is recorded");
    }
    public void play(){
        System.out.println("the music is started.");
    }
    public void stop(){
        System.out.println("The music is stopped");
    }
    public void videoCall(){
        System.out.println("The video call is called");
    }
}



// callback Method

interface member{
    /* static final */ int X=10;   // In interface the contant can be declared and defined but the variable name should be in Capital letter. The variable is by deafault 'static' and 'final'    Do's

    void callback();  //   In interface, the method is public and abstract by default.. and it cannot be private

    public static void name(){
        System.out.println("My name is Ravi Raushan");    // interface can have static method ... then how will I access
    }
}
class store{
    member memb[]= new member[100];
    int count=0;
    void resgister(member m){
        memb[count++]=m;
    }
    void inviteSale(){
        for(int i=0;i<count;i++){
            memb[i].callback();
        }
    }
}
class customer implements member{
    String name;

    public customer(String name) {
        this.name=name;
    }
    public void callback(){
        System.out.println("Ok, I'll visit the store  " +name);
    }
    
}


public class basicsInterface {
    public static void main(String[] args) {
        test t=new my();
        t.meth1();
        t.meth2();  // Since we create the reference of the test interface so that we can use that method of which it will have knowledge about 
        my my= new my();
        my.meth1();my.meth2();my.meth3();my.meth4();my.meth5();my.methd();
        


    /*    
        smartPhone sp= new smartPhone();
        sp.call(); sp.click(); sp.play();sp.record();sp.sms();sp.stop();sp.videoCall();

        phone p= new smartPhone();
        p.call();
        p.sms();

        iCamera i= new smartPhone();
        i.click(); i.record();

        iMusicPlayer iM= new smartPhone();
        iM.play(); iM.stop();
    */
/* 
    customer c1= new customer("Ravi ");
    customer c2= new customer("Mayank ");

    store s = new store();
    s.resgister(c2);
    s.resgister(c1);

    s.inviteSale();



    // accessing the variable and static method of interface
    System.out.println(member.X);
    member.name();  // yes it can be accessed

    */
    }




}
