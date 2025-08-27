import java.util.*;

public class cntSubSum {

    //  Better Approach this can be Brute Force Approach when we use one more loop for sum
    // public static int countSubarraySum(int arr[]) {
    //     int cnt = 0;
    //     for (int i = 0; i < arr.length; i++) {
    //         int sum = 0;
    //         for (int j = i ; j < arr.length; j++) {
    //             sum += arr[j];
    //             if (sum == 3) {
    //                 cnt++;
    //             }
    //         }
    //     }
    //     return cnt;
    // }


    //    Optimal Approach 

    public static int countSubarraySum(int arr[]){
        int cnt=0;
       Map<Integer,Integer>m= new HashMap<>();
        int prefix=0;
        m.put(0, 1);
        for(int i=0;i<arr.length;i++){
            prefix+=arr[i];
            int remove=prefix-3;
            cnt+=m.getOrDefault(remove, 0);
            m.put(prefix,m.getOrDefault(prefix,0)+1);
        }
        return cnt;
        
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, -3, 1, 1, 1, 4, 2, -3 };
        System.out.println(countSubarraySum(arr));
    }
}
