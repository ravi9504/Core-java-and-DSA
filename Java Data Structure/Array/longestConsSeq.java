import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class longestConsSeq {
   public static boolean ls(ArrayList<Integer>arr,int num){
      for(int i=0;i<arr.size();i++){
         if(arr.get(i)==num){
            return true;
         }
      }
      return false;
   }
   public static int longestConsecutiveSeq(ArrayList<Integer>arr){

      //                Brute force approach TC->O(n^2)   SC-> O(1)
     /*  int n= arr.size();
      int maxlen=Integer.MIN_VALUE;
      for(int i=0;i<n;i++){
         int x=arr.get(i);
          int len=1;
        while (ls(arr,x+1)==true) {
         x=x+1;
         len=len+1;
        }
        maxlen=Math.max(maxlen, len);
      }
      return maxlen;
      */




      //                   Better appraoch       TC->O(n)+O(nlogn)   SC-> O(1)

    /*   Collections.sort(arr);
      int lastSmaller= Integer.MIN_VALUE;
      int cnt=0;
      int longest=1;
      for(int i=0;i<arr.size();i++){
         if((arr.get(i)-1) ==lastSmaller){
            cnt+=1;
            lastSmaller=arr.get(i);
         }
         else if(lastSmaller !=arr.get(i)){
            cnt=1;
            lastSmaller=arr.get(i);
         }
         longest=Math.max(longest, cnt);
      }
      return longest;
      */




      // Optimal appraoch      
      int n=arr.size();
      if(n==0){
         return 0;
      }
      int longest=1;
      Set<Integer>st=new HashSet<>();
      for(int i=0;i<n;i++){
         st.add(arr.get(i));
      }
      for (Integer i : st) {
         if(!st.contains(i-1)){
            int cnt=1;
            int x=i;
            while (st.contains(x+1)) {
               x+=1;
               cnt+=1;
            }
            longest=Math.max(cnt, longest);
         }
      }
      return longest;
   }

   public static void main(String[] args) {
      ArrayList<Integer>arr= new ArrayList<>();
      arr.add(102);
      arr.add(4);
      arr.add(100);
      arr.add(1);
      arr.add(101);
      arr.add(3);
      arr.add(2);
      arr.add(1);
      arr.add(1);
      System.out.println(longestConsecutiveSeq(arr));
   }
}