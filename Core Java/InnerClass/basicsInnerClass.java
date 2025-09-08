package InnerClass;

/*
    Inner Class like there are one or more class in a class. And there are 4 types of inner class 1.Nested Inner Class  2.Local Inner Class  3.Anonymous Inner Class  4.Static Inner Class
 */

 // Nested Inner Class
 /* 
class outer{
    int x=10;

    class inner{
        int y=12;
        void display(){
            System.out.println(x);
            System.out.println(y);  // We can access the variable and method of the outer class in inner class directly
        }
    }
    void display(){
        inner i= new inner();   //  we cannnot access the variable or method directly unless we created its object
        System.out.println(i.y);
    }
}

*/

// Local Inner Class:->  This class is created in method of outer class and that inner class has no recognization in outside of that outer class means we cannot create the object of the inner class in ' main ' method according to block scope.
/* 
class  outer{
    void display(){
        class inner{
            void display(){
                System.err.println("hello");
            }
        }
        inner i=new inner();
        i.display();
    }
}
*/
// Anonymous Inner Class:->  This class is defined during the creation of the object. Usually, This is useful for interfaces and abstract classes

// abstract class my{
//    abstract  void display();
// }
// class test{
//     public void meth(){
//     my m= new my() {    // as we know we can take the reference of abstract class but we cannot create its object but here java created an object of an anonymous class (nameless class)
//         void display(){
//             System.out.println("Here is anonymous inner class") ;
//         }
//     };
//     m.display();  
// }
// }


// Static Inner Class-> class is same as nested class but in this we can directly access the inner class outside the outer class

class  outer{
    static int x=10;
    int y=20;
    static class inner{
        void display(){
            System.out.println(x);
            // System.out.println(y);// here it throws error because we cannot access the non static var in static class
        }
    }
}

/*
        File demonstration: As we know for every class one new file is created as we compile.So how can the file is created for inner class and here it is like that 'outer$inner.class'
 */
public class basicsInnerClass {
    public static void main(String args[]){
    // outer o= new outer();
    // o.display();

    // How can we access the inner class...
    // Often there is no need of accessing the inner class because it usually accesses by outer class already but you should know
    // outer.inner i= new outer().new inner();
    // System.out.println(i.y);
    // i.display();

// anonymous inner class
        // test t= new test();
        // t.meth();

    // Static inner class
    outer.inner i= new outer.inner();  // difference is that in Nested Inner class object creation is like 'new outer.new inner' but here 'new outer.inner'
    i.display();


    test t= new test();
    t.display();
    }
}


abstract class hell{
    abstract public void show();
}
class test {
    public void display(){
        // hell h= new hell() {
        //     public void show(){System.out.println("hello");}
        // };
        // h.show();

        // Alternate method
        new hell() {
            public void show(){
                System.out.println("Hello");
            
        };
    }.show();  // this is anonymous object of anonymous class
}
}