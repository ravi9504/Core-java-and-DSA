import java.util.ArrayList;
import java.util.Scanner;

public class optUnionArr {
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
      System.out.println(unionArr(arr1,arr2));
   }
   static ArrayList unionArr(int arr1[], int arr2[]){
      int n1= arr1.length;
      int n2= arr2.length;
      int i=0;
      int j=0;
      ArrayList<Integer>arr= new ArrayList<>();
      while(i<n1 && j<n2){
         if(arr1[i]<=arr2[j]){
            if(!arr.contains(arr1[i]) || arr.size()==0){
               arr.add(arr1[i]);
            }
            i++;
         }
         else{
            if(!arr.contains(arr2[j]) || arr.size()==0){
               arr.add(arr2[j]);
            }
            j++;
         }
      }
      while(i<n1){
         if(arr.size()==0 || !arr.contains(arr1[i])){
            arr.add(arr1[i]);
         }
         i++;
      }
      while(j<n2){
         if(arr.size()==0 || !arr.contains(arr2[j])){
            arr.add(arr1[j]);
         }
         j++;
      }
   
      return arr;
   }
}
