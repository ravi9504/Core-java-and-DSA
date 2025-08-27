import java.util.HashMap;
import java.util.Map;

public class majorityEl {
   public static int majority(int arr[], int n) {
      //                            BRUTE FORCE APPROACH
      // for (int i = 0; i < n; i++) {
      //    int cnt = 0;
      //    for (int j = 0; j < n; j++) {
      //       if (arr[i] == arr[j]) {
      //          cnt++;
      //       }
      //    }
      //    if (cnt >= (n / 2)) {
      //       return arr[i];
      //    }

      // }
      // return -1;



      // //                         BETTER APPROACH USING HASHING 
      // HashMap<Integer,Integer>m= new HashMap<>();
      // for(int i=0;i<n;i++){
      //    int value= m.getOrDefault(arr[i],0);
      //    m.put(arr[i], value+1);
      // }
      // for(Map.Entry<Integer,Integer>it: m.entrySet()){
      //    if(it.getValue()>(n/2)){
      //       return it.getKey();
      //    }
      // }
      // return -1;



      //                      OPTIMAL APPROACH USING MOORE'S VOTING ALGO
      int cnt=0;
      int el=0;
      for(int i=0;i<n;i++){
         if(cnt==0){
            cnt=1;
            el=arr[i];
         }
         else if(arr[i]==el) cnt++;
         else cnt--;
      }
      for(int i=0;i<n;i++){
         if(arr[i]==el){
            cnt++;
         }
      }
      if(cnt>(n/2)) {return el;}
      return -1;
   }

   public static void main(String arg[]) {
      int arr[] = {
            1, 2, 5, 5, 4, 7, 5, 5, 7, 8, 9, 5, 5, 5, 5,5
      };
      int n = arr.length;
      System.out.println("The majoity element of the given array is: "+majority(arr, n));
   }
}
