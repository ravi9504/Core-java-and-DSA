package inheritance;

public class overRiding {
    public static void main(String[] args) {
        sub s= new sub();
        s.display();      // Welcome to the coding world:

        sup sup= new sup();
        sup.display();     //  Hello, World!       Since the base class objecct is created so the base class method (display()) is executed

        sup sup1= new sub();
        sup1.display();   // Welcome to the coding world:     Since the derived class object is created so the base class method is overrided and 
                            //                                  the derived class method is executed

        // sub s1= new sup();      this throws error because we cannot create object of base class by taking reference of derived class.... but it's opposite is applicable.    EX:->   Since a class tv which is old and other class smart tv which is inherit tv class with some extra feature. So Smart TV can be TV but old TV can't be smart TV 






        // TV and Smart TV example
        tv t= new tv();
        t.changeChannel();     //  TV channel is changed by TV button
        t.switchON();           // TV is switched on:

        smartTv st= new smartTv();
        st.changeChannel();      //Smart channel is changed by using remote..
        st.switchON();           // Smart TV is switched on by remote..
        st.browse();    // Smart TV is browsing..





        tv t1= new smartTv();      // this method is called DYNAMIC METHOD DISPATCH:-> By holding reference of super class and creating an object of derived class.    why it is called because by creating object it creates in heap memory which is dynamic



        t1.changeChannel(); // Smart channel is changed by using remote..
        t1.switchON();  //Smart TV is switched on by remote..
        // t1.browse();    this method is not called because the reference has no knowledge about this method becasue of reference of super class 

        // smartTv t2= new tv();    this throws error we cann't create object of base class by taking reference of derived class or subclass
    }
}
class sup{

    void display(){
        System.out.println("Hello, World!");
    }
    void print(){
        System.out.println("Ravi Raushan");
    }
}
class sub extends sup{
    @Override
    void display(){
        System.out.println("Welcome to the coding world: ");     // here derived class display method override the base class display method..(having same name of method in both base and derived class then base class method is overrided when the derived class object is created.. )
    }
    void print2(){
        System.out.println("Hi...!");
    }
}




// Example TV and Smart TV

class  tv{
    public void switchON(){ System.out.println("TV is switched on: ");}
    public void changeChannel(){
        System.out.println("TV channel is changed by TV button");
    }

}
class smartTv extends  tv{
    @Override
    public void switchON(){System.out.println("Smart TV is switched on by remote..");}

    @Override    // this is an annotation
    public void changeChannel(){System.out.println("Smart channel is changed by using remote.. ");}
    public void browse(){
        System.out.println("Smart TV is browsing..");
    }
}




//                                                      !IMPORTANT NOTE    


//                                      IN dynamic dispatch method if the super class method is overrided in derived class then the method of derived classm will execute or call  and also then extra method of derived class is not applicable to call or execute in dynamic method dispatch..







// //                                                          Extra Knowledge






// package inheritance;

// class A{}
// class B extends A{}
// class sup{
//     public A display(){
//         System.out.println("Super Display");
//         return new A();
//     }
// }
// class sub extends sup{
//     // public A display(){
//     //     return new A();// return the object of A class..      // this is also overriding because both method had same signature 'public A' 
//     // }
//     public B display(){
//         return new B();      // this is also overriding because B class extends A so if the method is return A object or B object is same.
//     }
// }

// // And One more:-> overrided is applicable in different access specifiers if super class has more strict access specifiers than the sub class or derived class and if super class or base class has less strict access specifiers then it is not an overriding method

// public class overRiding {

//     public static void main(String[] args) {
        
//     }
// }





// Difference between Overloading and Overriding 

/*
    In overriding, the name of the method is same of different class whereas In overloading the name of the method is same of the same class 
    In overriding, the parameter of the method cann't be different and also return type but In overloading, the parameter can be different and also the return type.. 


    Method using Final and Static keyword cannot be overrided
 */


