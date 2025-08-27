public class twoString {
    public static void main(String[] args) {
        String str="Java Program";
        // Now this str reference(object) is created in pool (stack) 
        String str2= new String("Java");
        // Now this str reference is created in Heap memory and no more creation of "java" literals because it is already there 

        System.out.println(str);    //   Java Program
        System.out.println(str2);  // Java

        char c[]= {'H','H','H','H'};
        String str3= new String(c);
        System.out.println(str3);    // HHHH


        byte b[]={65,66,67,68};
        String str4= new String(b);
        System.out.println(str4);//ABCD



        str3= new String(c,1,3);
        System.out.println(str3);    // HHH


        // Similarly we can use this method in all by giving 1st string and last string 



        String a= "Java";
        String j= new String("Java");
        System.out.println(a==j);    //   false






        String str6= "   Ravi Raushan   ";
        System.out.println(str6.length());  // this method return integer         18

        System.out.println(str6.trim());   // Ravi Raushan   this method return string

        System.out.println(str6.substring(4, 10));   //  avi Ra     this method also return string

        System.out.println(str6.toLowerCase());
        System.out.println(str6.toUpperCase());
        //     ravi raushan     RAVI RAUSHAN   these methods also return string
        
        System.out.println(str6.replace("R", "c"));   // cavi caushan

        String s="www.organisation.com";

        System.out.println(s.startsWith("www"));   // true   this method return boolean

        System.out.println(s.endsWith("com"));   // true   this method also return boolean

        System.out.println(s.charAt(6));   //  g      -->char

        System.out.println(s.indexOf("."));  //3    --> int 
        System.out.println(s.indexOf(".",4));   // 16    --> int

        System.out.println(s.lastIndexOf("."));   // 16       --> int


        String k="java";
        System.out.println(a.equals(k) ); // false
        System.out.println(k.equals(a));   // false

        System.out.println(a.equalsIgnoreCase(k));//true
        System.out.println(k.equalsIgnoreCase(a));  // true
        System.out.println(a.compareTo(k));  // -32   this is the difference between of their ascii 

        System.out.println(k.compareTo(a));   // 32

        System.out.println(a.equalsIgnoreCase(k));  //true

        System.out.println(a.contains("ava"));//true

        String ss="the great wall";
        String os=" of china";
        System.out.println(ss.contains(os));  //false

        System.out.println(ss.concat(os));  //the great wall of china



        // REGEX                description
        //  .                   Any Character
        //  [abc]               Exaclty given letters

        // [abc][vz]            Either first or second set

        // [^abc]               Except abc
        // [a-z1-9]             a-z or 1-9
        // A|B                  A or B
        // XZ                   Exactly XZ

        String s7= "a";
        System.out.println(s7.matches("[abc]"));  //true

         System.out.println(s7.matches("[^abc]"));   //false

            // Meta Characters

        // Regular Expression       description
        // \\d                      Digits
        //  \\D                     Not digits
        // \\s                      Space 
        // \\S                      Not Space
        // \\w                      Alphabets or digit

        // \W                      Neither alphabet or digit

        System.out.println(s7.matches("\\d"));  //false






        // Quantifiers

        // Regex              Description
        // *                  0 or more time
        // +                  One or more 
        // ?                  0 or 1 time
        // {X}                X times
        // {X,Y}              Between X and Y time


        s7= "aewfojdsjfjdsf";
        System.out.println(s7.matches(".*"));
        //true

        System.out.println(s7.matches("f*"));
        // false

        s7="aaabbbcc";
        System.out.println(s7.matches("[abc]{3,7}"));  //false
        s7="abac@gmail.com";
        System.out.println(s7.matches("\\w*@gmail(.*)"));   //true





        //Challenges

// 1
        // Find if the email id is on gmail or not 
        //Find username and domain name from email

        String strr="programmer@gmail.com";
        boolean flag= strr.matches("\\w*@gmail.*");
        if(flag==true){
            System.out.println("Given "+strr+" is on gmail");
        }
        int n=strr.indexOf("@");
        int m=strr.lastIndexOf(".");
        System.out.println("username is: "+strr.substring(0, n));
        System.out.println("Domain is: "+strr.substring(m+1, strr.length()));

// 2

        // Find if a Number is Binary or not 
        //Find is a Number is Hexa-Decimal or not 
        // Find is the Date format(dd/mm/yyyy)
        int b= 10110001;
        String strr1=String.valueOf(b);
        System.out.println(strr1.matches("[01]+"));  // true


        String b1="234AB";
        System.out.println(b1.matches("[0-9A-F]+"));  // true



        String date= "20/12/2004";
        System.out.println(date.matches("[0-3][0-9]/[01][0-9]/[0-9]{4}"));   //true

// 3

        //Remove Special characters form a string
        // Remove extra spaces form a string
        // Find number of words in a string 

        String strr3= "a!B@c#1$2%3";
        String c=strr3.replaceAll("[^a-zA-Z0-9]+", "");
        System.out.println(c);

        String strr4= "abc  de  fgh  ijk";
        String c1=strr4.replace(" ", "");

        System.out.println(c1);
        String words[]= strr4.split("\\s+");
        System.out.println(words.length);
    } 
}
