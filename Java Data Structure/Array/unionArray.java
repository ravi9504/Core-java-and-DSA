import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class unionArray {
   public static void main(String[] args) {
      Scanner s= new Scanner(System.in);
      System.out.println("What is number of element in an array:");
      int n1 = s.nextInt();
      int arr1[]=new int[n1];
      System.out.println("What is the number of element in second array:");
      int n2=s.nextInt();
      int arr2[]=new int[n2];
      System.out.println("Give the element to the array1...");
      for (int i = 0; i < n1; i++) {
         arr1[i]=s.nextInt();
      }
      System.out.println("Give the element to the array2...");
      for (int i = 0; i < n2; i++) {
         arr2[i]=s.nextInt();
      }
      unionArr(arr1,arr2);
   }
   static void unionArr(int arr1[], int arr2[]){
      HashSet<Integer>st= new HashSet<>();
      for (Integer i : arr1) {
         st.add(i);
      }
      for (Integer i : arr2) {
         st.add(i);
      }
      for (Integer i : st) {
         System.out.print(i+" ");
      }
     
   }  
}
