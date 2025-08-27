import java.util.ArrayList;
import java.util.Collections;

public class leaderArray {
   public static ArrayList<Integer> retLeaderArr(ArrayList<Integer>arr){
   int n=arr.size();
   ArrayList<Integer>arr1= new ArrayList<>();

   //             Brute Force Approach  TC~>O(n^2)  SC-> O(n)
  /*  
   
      for(int i=0;i<n;i++){
         boolean isLeader=true;
         for(int j=i+1;j<n;j++){
            if(arr.get(i)<arr.get(j)){
               isLeader=false;
               break;
            }
         }
         if(isLeader==true){
            arr1.add(arr.get(i));
         }
      }
   return arr1;
   */


   //          Optimal Approach              TC-> O(n)+O(nlogn)      SC->   O(1)
   
   int max= Integer.MIN_VALUE;
   for(int i=n-1;i>=0;i--){
      if(max<arr.get(i)){
         max=arr.get(i);
         arr1.add(max);
      }
   }
   Collections.reverse(arr1);
   return arr1;
}
   public static void main(String args[]){
      ArrayList<Integer>arr= new ArrayList<>();
      arr.add(13);
      arr.add(9);
      arr.add(10);
      arr.add(12);
      arr.add(10);
      arr.add(3);
      arr.add(0);
      arr.add(6);
      System.out.println(retLeaderArr(arr));

   }
}
