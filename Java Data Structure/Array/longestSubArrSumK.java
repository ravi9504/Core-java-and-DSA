import java.util.HashMap;
import java.util.Map;

public class longestSubArrSumK {
   public static void longestSubArray(int arr[], int n,int l){

      //                               BRUTE FORCE APPROACH
      /*
      int length=0;
      int len=0;
      for(int i=0;i<n;i++){
         for(int j=i;j<n;j++){
            int s=0;
            // for(int k=i;k<j;k++){
            //    s+=arr[i];               // these four lines is used to minimize the time complexity from n^3 to n^2 in 
            //    if(s==l){                                          brute force approach
            //      length=Math.max(len, j-i+1);
            //    }
            // }
            s+=arr[i];
            if (s==l) {
               length=Math.max(len, j-i+1);
            }
         }
      }
      System.out.println("The longest array having sum: "+length);
      */

      //                            BETTER APPROACH USING HASHING
      // This approach is optimal for those case in which the element of the array is -ve,+veand 0s but when element of the array is +ve and 0s then int that case one optimal solution is in the way....
      // Map<Integer,Integer>map= new HashMap<>();
      // int maxlen=0;
      // int sum=0;
      // for(int i=0;i<arr.length;i++){
      //    sum+=arr[i];
      //    if(sum==l){
      //       maxlen=Math.max(maxlen, i+1);
      //    }
      //    int rem=sum-l;
      //    if(map.containsKey(rem)){
      //       int len=i-map.get(rem);
      //       maxlen=Math.max(maxlen, len);
      //    }
      //    if(!map.containsKey(sum)){
      //       map.put(sum, i);
      //    }
         
      // }
      // System.out.println("The longest array having sum "+l+" :"+maxlen);

      //                OPTIMAL APPROACH
      int right =0;
      int left=0;
      int maxlen=0;
      int i=0;
      int sum=0;
      while(right<n){
         while(right>=left && sum>l ){
            sum-=arr[left];
            left++;
         }
         if(sum==l) maxlen=Math.max(maxlen,right-left+1);
         right++;
         if(right<arr.length){
            sum+=right;
         }
      }
      System.out.println("The logest array having the sum is "+l+" : "+maxlen);
   }

   public static void main(String[] args) {
      int arr[]={1,2,3,1,1,1,5,3,4,6};
      int n=arr.length;
      int l=3;
      longestSubArray(arr,n,l);
   }
}
