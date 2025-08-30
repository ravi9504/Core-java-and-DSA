package OOPS;

public class basicOops {
    public static void main(String[] args) {
        rectangle r= new rectangle();    // this is a way to create an object of the class 
        r.length=12;      // this is a way to give input to the variable of the other class with help of object
        r.breadth=20;
        System.out.println("Area of rectangle is: "+r.area());   // r.area() is a way to access the the medthod of the other class with the help of object
        System.out.println("Perimeter of rectangle is: "+r.perimeter());
        System.out.println("Given rectangle is square :"+r.isSquare());





        rectangle1 r1= new rectangle1();
        r1.setBreadth(24);
        r1.setLength(24);

        System.out.println("Area of the rectangle1 is: "+r1.area());
        System.out.println("Perimeter of the rectangle1 is: "+r1.perimeter());
        System.out.println("Given rectangle1 is square: "+r1.isSquare());
        System.out.println("Length of the reactangle is: "+r1.getLength());
        System.out.println("Breadth of the rectangle is: "+r1.getBreadth());
        




    }   
}
class rectangle {
    public int length;
    public int breadth;
    public double area(){
        return length*breadth;
    };
    public double perimeter(){
        return 2*(length+breadth);
    };
    public boolean isSquare(){
        boolean result=length==breadth?true:false;
        return result;
    }
    
}

class rectangle1 {

    private int length;
    private int breadth;

    void setLength(int l){     // setter: this is a way to access the private member of the class outside using methods
        if(l>0){
            length=l;
        }
        else{
            length=0;
        }
    }
    void setBreadth(int b){
        if(b>0){
            breadth=b;
        }
        else{
            breadth=0;
        }
    }

    int getLength(){
        return length;
    }
    int getBreadth(){
        return breadth;
    }

    public double area(){
        return length*breadth;
    }
    public double perimeter(){
        return 2*(length+breadth);
    }
    public boolean isSquare(){
        if(length==breadth){
            return true;
        }
        else{
            return false;
        }
    }
    
}
