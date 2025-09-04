package ABSTRACT;
/*
    * We cannot create the object of the Abstract class but we can take reference during _Dynamic Dispatch Method_

    * If any class inherits the abstract class then it is being an abstract class automatically but if in inherited class all the abstract method of abstract class is overrided and defined then it can be concrete class     
*/


/* 
abstract class sup{

    sup(){
        System.out.println("Super constructor");
    }
    abstract  public void meth1();
}
class sub extends sup{
    @Override
    public void meth1(){
        System.out.println("Meth1 in sub class");
    }
}
    */

abstract class hospital{
    abstract public void emergency();
    abstract public void appointment();
    abstract public void admit();
    abstract public void billings();
}
class myHospital extends hospital{
    @Override   
    public void emergency(){
        System.out.println("Emergency Kit is available in myHospital");
    }
    @Override   
    public void appointment(){
        System.out.println("Apointment desk is available in myHospital");
    }
    @Override   
    public void admit(){
        System.out.println("Admitting section for the pastient is available in myHospital");
    }
     @Override   
    public void billings(){
        System.out.println("Billing system is available in myHospital.");
    }
    public boolean isApplicable(){
        return true;
    }
}


abstract class shape{
    abstract public void perimeter();
    abstract public void area();
}
class rectangle extends shape{
    public int length;
    public int breadth;
    @Override
    public void perimeter(){
        System.out.println(2*(this.breadth+this.length));
    }
    @Override
    public void area(){
        System.out.println(this.length*this.breadth);
    }
}
class circle extends shape{
    public int radius;
    @Override
    public void perimeter(){
        System.out.println(2*Math.PI*radius);
    }
    @Override
    public void area(){
        System.out.println(Math.PI*Math.pow(radius, 2));
    }
}

public class basicsAbs {
    public static void main(String args[]){
        // sup s= new sub();
        // s.meth1();

        hospital h= new myHospital();
        h.admit();
        h.appointment();
        h.billings();h.emergency();
        // h.isApplicable();  this throws error because in dynamic dispatch method we cannot use the derived class method whose object is created by holding reference of the base class that has no knowledge about the dervied class method



        rectangle r= new rectangle();
        r.length=10;
        r.breadth=12;
        circle c= new circle();
        c.radius=25;

        shape s1= c;  // here we use it to reuse the initialized objects
        shape s2= r;  //  here we use it to reuse the initialized objects

        s1.area();
        s1.perimeter();

        s2.area();
        s2.perimeter();
        
    }
}



// Abstract class cannot be final and Static . And abstract method cannot be final and static

// Abstract class cannot be final because final class cannot be extended and abstract class mean to for extended



// We will know more about static and final