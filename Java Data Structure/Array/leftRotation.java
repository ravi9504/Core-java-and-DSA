//                              Brute Force Approach

import java.util.Scanner;

class leftRotation{
   // public static void leftRotate(int arr[], int d,int n){
   //    // int temp[]= new int[d];
   //    // for (int i = 0; i < temp.length; i++) {
   //    //    temp[i]=arr[i];
   //    // }
   //    // for (int i = d; i <n; i++) {
   //    //    arr[i-d]=arr[i];
   //    // }
   //    // for (int i = n-d; i <n; i++) {
   //    //    arr[i]=temp[i-(n-d)];
   //    // }
      
   //    for (int i = 0; i < n; i++) {
   //       System.out.print(arr[i]+" ");
   //    }
   // }
   public static void main(String[] args) {
      Scanner s= new Scanner(System.in);
      System.out.println("How many number of places you want to rotate.");
      int d= s.nextInt();
      System.out.println("How many number of element in an array should be?  ");
      int n=s.nextInt();
      System.out.println("Now give the element of the array in which you want to do operation of left rotation.");
      int arr[]= new int[n];
      for(int i=0;i<n;i++){
        arr[i]=s.nextInt();
      }
      
     leftRotate(arr, n,d);
   }


   //                        optimal solution

   public static void leftRotate(int arr[],int n,int d){
      // if(n==0){
      //    return;
      // }
      // d=d%n;
      // if(d<0){
      //    d=d+n;
      // }
      reverseArray(arr, 0, d-1);
      reverseArray(arr, d, n-1);
      reverseArray(arr, 0, n-1); 
      for ( int i = 0; i < n; i++) {
         System.out.print(arr[i]+" ");
      }
   }
   public static void reverseArray(int arr[], int start, int end){
      while (start<end) {
         int temp=arr[start];
         arr[start]=arr[end];
         arr[end]=temp;
         start++;
         end--;
      }
   }
   
}