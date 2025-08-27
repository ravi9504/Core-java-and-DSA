import java.util.*;

public class kadanesAlgo {
   public static void solution(int arr[], int n ){

      //             BRUTE FORCE APPROACH                    TC-O(n^3)
     /*  int maxi=Integer.MIN_VALUE;
      for(int i=0;i<n;i++){
         for(int j=i;j<n;j++){
            int sum=0;
            for(int k=i;k<j;k++){
               
               sum+=arr[k];
               maxi=Math.max(maxi, sum);
            }
         }
      }
*/
      // BETTER APPROACH  TC=O(n^2)

     /*  int maxi=Integer.MIN_VALUE;
      for(int i=0;i<n;i++){
         int sum=0;
         for(int j=i;j<n;j++){
            sum+=arr[j];
            maxi=Math.max(maxi, sum);
         }
      }
         */


         //             OPTIMAL APPROACH
      
        /*  int maxi=Integer.MIN_VALUE;
         int sum=0;
         for(int i=0;i<n;i++){
             sum+=arr[i];
            if(sum>maxi){
               maxi=sum;
            }
            if(sum<0){
               sum=0;
            }
         }
*/
         // Now also print that subarray
         int ansStart=-1;
         int ansEnd=-1;
         int sum=0;
         int Start=0;
         int maxi=Integer.MIN_VALUE;
         for(int i=0;i<n;i++){
            if(sum==0) Start=i;
            sum+=arr[i];
            if(sum>maxi){
               maxi=sum;
               ansStart=Start;
               ansEnd=i;
            }
            if(sum<0){
               sum=0;
            }
         }
         for(int i=ansStart;i<=ansEnd;i++){
            System.out.print(arr[i]+" ");
         }
         System.out.println();
      System.out.println("The greatest sum of the subarray of given array is: "+maxi);
   }
   public static void main(String[] args) {
      int arr[]={-2,-3,4,-1,-2,1,5,-3};
      int n=arr.length;
      solution(arr,n);
   }
}
