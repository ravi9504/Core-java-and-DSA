import java.util.*;


public class twosum {
   static void sumEqualsTwoElement(int arr[], int sum){
      //                   BRUTE FORCE APPROACH        time-complexity is similar to O(n^2) and space-complexity=0(1)
   /*    for(int i=0;i<arr.length-1;i++){
         for(int j=i+1;j<arr.length;j++){
            int sum1=arr[i]+arr[j];
            if (sum1==sum) {
               System.out.println("The element that is equal to "+sum+" is "+(i+1)+" and "+(j+1));
            }
         }
      }
         */


         //          BETTER APPROACH  USING HASHING   time-complexity O(nlogn)  space-complexity O(n)
       /*   Map<Integer,Integer>m=new HashMap<>();
         for(int i=0;i<arr.length;i++){
            int rem=sum-arr[i];
            if(m.containsKey(rem)){
               
               System.out.println("The element that is equal to "+sum+" is "+(i)+" and "+(m.get(rem)));
            }
            else{
               m.put(arr[i], i);
            }
         }
            */


            //                OPTIMAL APPROACH  USING TWO POINTER APPROACH
            //   this approach is applicable when the array is sorted but when it is not sorted then hashing approach is optimial for that 
            int right=arr.length-1;
            int left=0;
            while (left<right) {
               int sum1=arr[left]+arr[right];
               if(sum1>sum){
                  right--;
               }
               else if(sum1<sum){
                  left++;
               }
               if(sum1==sum){
                  System.out.println("The element that is equal to "+sum+" is "+left+" and "+right);
                  left++;
                  right--;
               }
            }
   }
   public static void main(String args[]){
      int arr[]={
         1,2,3,4,6,7,8,9,12
      };
      int sum=14;
      sumEqualsTwoElement(arr,sum);
   }
}
