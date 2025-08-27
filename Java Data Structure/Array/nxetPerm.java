import java.lang.reflect.Array;
import java.util.*;

public class nxetPerm {
   /*             leetcode solution
   class Solution {
    public void swap(int nums[], int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void reverse(int nums[], int start){
        int i=start;
        int j=nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int ind=-1;
        int n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind=i;
                break;
            }
        }
        if(ind==-1){
            reverse(nums,0);
            return ;
        }
        for(int i=n-1;i>ind;i--){
            if(nums[i]>nums[ind]){
                swap(nums,ind,i);
                break;
            }
        }
        reverse(nums,ind+1);
    }
} */
   public static List<Integer> nextPermutation(List<Integer>arr){
      int n=arr.size();
   int ind =-1;
   for(int i=n-2;i>=0;i--){
      if(arr.get(i)<arr.get(i+1)){
         ind=i;
         break;
      }
   }
   if(ind==-1){
      Collections.reverse(arr);
      return arr;
   }
   for(int i=n-1;i>ind;i--){
      if(arr.get(i)>arr.get(ind)){
         int temp=arr.get(i);
         arr.set(i, arr.get(i));
         arr.set(ind,temp);
         break;
      }
   }
   List<Integer>sublist= arr.subList(ind+1, n);
   Collections.reverse(sublist);
   return arr;
   }
   public static void main(String[] args) {
   List<Integer>arr= new ArrayList<>();
   arr.add(2);
   arr.add(1);
   arr.add(5);
   arr.add(4);
   arr.add(3);
   arr.add(2);
   arr.add(0);
   arr.add(0);
   System.out.println(nextPermutation(arr));
   }   
}
