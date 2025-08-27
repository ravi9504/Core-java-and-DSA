import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class appearOnce {
   public static void appear1(int arr[], int n){
      //BRUTE FORCE APPROACH
      // for(int i=0;i<n;i++){
      //    int cnt=0;
      //    for(int j=0;j<n;j++){
      //       if(arr[i]==arr[j]){
      //          cnt++;
      //       }
      //    }
      //    if(cnt==1){
      //       System.out.println("The element that appear once in an array: "+arr[i]);
      //    }
      // }

      //             BETTER APPROACH    USING HASH ARRAY

      // int max=0;
      // for(int i=0;i<n;i++){
      //    max=Math.max(max, arr[i]);
      // }
      // int hash[]=new int [max+1];
      // for(int i=0;i<arr.length;i++){
      //    hash[arr[i]]++;
      // }
      // for(int i=0;i<arr.length;i++){
      //    if(hash[arr[i]]==1){
      //       System.out.println("The element that appear once in an array: "+arr[i]);
      //    }
      // }

      //    BETTER APPROACH 2  USING HASHING
      Map<Integer,Integer>map=new HashMap<>();
      for(int i=0;i<n;i++){
        int value= map.getOrDefault(arr[i],0);  // this is to intialize the value of every key with 0
        map.put(arr[i],value+1);
      }
      for(Map.Entry<Integer, Integer>it:map.entrySet()){
         if(it.getValue()==1){
            System.out.println("The number that appear once in an array:"+it.getKey() );
         }
      }
    
      
      //          OPTIMAL APPRAOCH
      // int xor=0;
      // for(int i=0;i<arr.length;i++){
      //    xor^=arr[i];
      // }
      // System.out.println("The number that appear once in an array : "+xor);

   }
   public static void main(String args[]){
      int arr[]={1,2,3,4,1,2,3};
      int n=arr.length;
      appear1(arr,n);
   }
   
}
