/*
An enum (enumeration) is a special data type used to define a collection of 
constants. It is a way to define a set of named values that can be used in 
a program. Enums are used to represent a fixed set of related values, 
such as days of the week, months of the year, or colors.

like Employee can have these roles  .Developer , .Tester, .Manager, .HR etc. so we can define
these roles in enum and use it in our program.
Cannot suddenly have: .Superhero, .Alien, .Doctor

Instead of using String or int to represent these roles, we can use enum to define
these roles and use it in our program. If we define     String role="Developer"   then 
what if someone write role ="developer" or role="dev" or role="creator" and due to this
application behaves incorrectly. So, to avoid this we can use enum to define these roles like this

*/
interface Employee{
    public void doWork();
}
enum Role implements Employee{
    DEVELOPER,
    TESTER, 
    MANAGER,
    HR;

    public void doWork() {
        System.out.println("Employee is working");
    }
}

class Enum{
    public static void main(String args[]){
        Role r=Role.DEVELOPER;   // this is called type safety means java ensures only the correct type
        // value is assigned to the variable.
        // java won't allow  Role r="developer";   it gives compilation error
        System.out.println(r);  // DEVELOPER
        r.doWork();  // Employee is working
    }
}

/*
How Java sees an Enum?
-> Java internally treats it something like 
final class Role extends Enum<Role>{
    public static final Role DEVELOPER=new Role();
    public static final Role TESTER=new Role();
    public static final Role MANAGER=new Role();
    public static final Role HR=new Role();

    // Every constant is a actually an object 

    !Important   
    Enum  has constructor, methods whenever java creates enum constant, the constructor is called.
    But we cannot do  like this new Role()  compilation error because enum constructor is private by default
     and we cannot create object of enum class because Java creates the enum objects automatically when the enum class is loaded.
     Enum also can implement interface but cannot extend any class because it already extends Enum class.
}

!Important methods 
->valueOf(String name): This method is used to return the enum constant of the specified enum type with the specified name.
->ordinal(): This method is used to return the ordinal of the enum constant. The ordinal is
the position of the enum constant in the enum declaration. The first constant has an 
ordinal of 0

->values(): This method is used to return an array containing all the constants of the enum 
type in the order they are declared.
->name(): This method is used to return the name of the enum constant, exactly as declared in its enum 
declaration.
->compareTo(E o): This method is used to compare the ordinal of the enum constant with the ordinal 
of the specified enum constant. It returns a negative integer, zero, 
or a positive integer as this enum constant is less than, equal to, or greater than the specified 
enum constant.



!Important questions?
Is enum a class or interface?
-> Enum is a class because it can have methods, constructors, and fields.
Can enum extend another class?
-> No, enum cannot extend another class because it already extends the Enum class.
Can enum implement an interface?
-> Yes, enum can implement an interface because it can have methods and fields.
*/