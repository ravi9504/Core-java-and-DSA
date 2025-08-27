public class OneformatSpecifier {
    public static void main(String[] args) {
        
        int x=10;
        float y=0.0012f;
        char z= 'A';
        System.out.printf("Hello %e \n",y);    //    Hello 1.200000e-03   float into Exponential
        System.out.printf("%o", x);   
        // 12     conversion of 10 in octal
        System.out.printf("%x", x);   // a  int to hex
        

        float a= 2423.34324f;
        System.out.printf("%4.2f",a);
        // 2423.34     4--> width of the number in output    .--> flags means +,-,. and all   2--> width after flags f-> precision    go to formatSpecifier.png

    }

}
