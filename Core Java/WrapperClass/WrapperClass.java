/*
  Wrapper class is used to convert primitive data types into object and vice versa.
  Java provides a wrapper class for each primitive data type.
  The wrapper classes are present in java.lang package.
  
 * Primitive Data Type	Wrapper Class
    byte Byte
   short Short
   int	Integer
   long	Long
   float	Float
   double	Double
   char	Character
   boolean	Boolean
   
   Wrapper classes are used in Collections framework like HashMap, HashSet, ArrayList etc. because Collections can only store objects and not primitive data types.
   Wrapper classes are immutable i.e. once the object is created, its value cannot be changed. 
 */
class WrapperClass{
    public static void main(String[] args) {
        int a=10;
        // Integer num= new Integer(a); // converting int into Integer explicitly but this is deprecated way
        Integer i=Integer.valueOf(a); // converting int into Integer explicitly and this is modern way
        Integer j=a; // autoboxing, now compiler will write Integer.valueOf(a) internally and this automatic coversion called autoboxing
        // like when we try to add the value in arraylist then this only happen list.add(10)-> list.add(Integer.valueOf(10)) internally
        System.out.println(a+" "+i+" "+j);  // 10 10 10

        Integer x=Integer.valueOf(20);
        int y=x.intValue(); // converting Integer to int explicitly
        int z=x; // unboxing, now compiler will write x.intValue() internally

        System.out.println(x+" "+y+" "+z); //20 20 20
    }
}

/*
    Important Methods of Wrapper Class:
    1. parseInt(String s): This method is used to convert String into int.
    2. parseDouble(String s): This method is used to convert String into double.
    3. parseFloat(String s): This method is used to convert String into float.
    4. parseLong(String s): This method is used to convert String into long.
    5. parseBoolean(String s): This method is used to convert String into boolean.
    6. valueOf(String s): This method is used to convert String into Integer, Double, Float, Long, Boolean, Character.
    7. toString(): This method is used to convert Integer, Double, Float, Long, Boolean, Character into String.
    8. compareTo(): This method is used to compare two Integer, Double, Float, Long, Boolean, Character values.
    9. equals(): This method is used to compare two Integer, Double, Float, Long, Boolean, Character values.
    10. hashCode(): This method is used to return the hash code of Integer, Double, Float, Long, Boolean, Character values.


    Why wrapper classes are immutable?
    The wrapper classes are immutable because once the object is created, its value cannot be changed.
    For example, if we create an Integer object with value 10, we cannot 
    change its value to 20. If we want to change the value, we have to create 
    a new Integer object with value 20. This is because the wrapper classes are 
    designed to be immutable to ensure that they can be safely used in 
    multi-threaded environments without the need for synchronization.

    Durring comparison why we use equals() method instead of == operator?
    The == operator compares the reference of the object, not the value of the object.
    The equals() method compares the value of the object, not the reference of the object.
    For example, if we create two Integer objects with value 10, the == operator will return false because the reference of the two objects is different, but the equals() method will return true because the value of the two objects is the same.
    Therefore, we should use the equals() method to compare the value of the object instead of the == operator.
    The == operator is used to compare the reference of the object, not the value of the object. The equals() method is used to compare the value of the object, not the reference of the object. Therefore, we should use the equals() method to compare the value of the object instead of the == operator. 

    Perfromace wise primitive is fast and does not consume more memory as compared to wrapper class because wrapper class is object and object consume more memory as compared to primitive data type.
    So, we should use primitive data type instead of wrapper class whenever possible.

    When to use primitive->
    .for calculations
    .loops
    .for performance
    .Values are present

    When to use wrapper class->
    .Collections framework
    .Database Entities
    .Generics
    .Nullable Values
    .Framework API's (like Spring, Hibernate, etc.) */