import java.util.Scanner;

public class missingNumber {
   // //optimal appraoch 1
   // public static void missingNum(int n, int arr[] ){
   //    int s1=(n*(n+1))/2;
   //    int s2=0;
   //    for(int i=0;i<arr.length;i++){
   //       s2+=arr[i];
   //    }
   //    int missingN=s1-s2;
   //    System.out.println("Missing Number in this array is "+missingN);

   // approach 2
   public static void missingNum(int n, int arr[]){
      int xor=0;
      for(int i=0;i<arr.length;i++){
         xor^=arr[i];
      }
      System.out.println("Missing number in this array is: "+xor);
   }
   public static void main(String args[]){
      Scanner s= new Scanner(System.in);
      System.out.println("Give the number of element of an array: ");
      int n=s.nextInt();
      int arr[]= new int[n-1];
      System.out.println("Give the element of the array: ");
      for(int i=0; i<arr.length;i++){
          arr[i]=s.nextInt();
      }
      missingNum(n,arr);
   }
}
