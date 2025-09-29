package StaticAndFinal;

class hondaCity{
    static int price=10;   // Memory of the static variable in method area. It is shared by all objects (means all objects have same value evenif any objects modify the value )
    int a,b;
}
public class basicsSaF {
    public static void main(String[] args) {
        hondaCity h1= new hondaCity();
        hondaCity h2= new hondaCity();
        System.out.println(h1.price);  // 10
        System.out.println(h2.price);  // 10
        System.out.println(hondaCity.price);//10  // this static variable can be accessed by using class name only
        h1.price=20;
        System.out.println(h1.price);  // 20
        System.out.println(h2.price); //20
        System.out.println(hondaCity.price);  //20
    }
}
