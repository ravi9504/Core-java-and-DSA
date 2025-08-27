import java.util.*;

public class sortZerosOnesTwos {
   public static void solution(int arr[], int n){
         //     BRUTE FORCE APPROACH 
      //   ArrayList<Integer>a= new ArrayList<>();
      //   for(int i=0;i<n;i++){
      //       a.add(arr[i]);
      //   }
      //   Collections.sort(a);
      //   System.out.println(a);




      //                   BETTER APPROACH  
      int cnt=0,cnt1=0,cnt2=0;  
      for(int i=0;i<n;i++){
         if(arr[i]==0) cnt++;
         else if(arr[i]==1)  cnt1++;
         else cnt2++;
      }
      for(int i=0;i<cnt;i++){
            arr[i]=0;
      }
      for(int i=cnt;i<cnt1+cnt;i++){
         arr[i]=1;
      }
      for(int i=cnt1+cnt;i<n;i++){
         arr[i]=2;
      }
         for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
         }

      //    OPTIMAL APPROACH NAMED    (DUTCH NATIONAL FLAG ALGO)   in this  intitution is very important
      // int mid=0;
      // int low=0;
      // int high=n-1;
      // for(int i=0;i<n;i++){
      //    if(arr[mid]==0){
      //       int temp=arr[mid];
      //       arr[mid]=arr[low];
      //       arr[low]=temp;
      //       low++;
      //       mid++;
      //    }
      //    else if(arr[mid]==1){
      //       mid++;
      //    }
      //    else{
      //        int temp=arr[mid];
      //       arr[mid]=arr[high];
      //       arr[high]=temp;
      //       high--;
      //    }
      // }
      // for(int i=0;i<n;i++){
      //    System.out.print(arr[i]+" ");
      // }
   }
   public static void main(String[] args) {
      int arr[]={1,0,2,0,1,1,0,2,0,1,0,2};
      int n=arr.length;
      solution(arr,n);
}
}
