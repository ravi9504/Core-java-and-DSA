import java.util.*;

public class rearrangeArrayEl {
   public static void rearrangeArrayPosNeg(ArrayList<Integer>arr){
      //   Brute force appraoch 
      
      // int n =arr.length/2;
      // int posArr[]=new int[n];
      // int negArr[]= new int[n];
      // int i=0;
      // int j=0;
      //    int k=0;
      // while(i<arr.length){
         
      //    if(arr[i]<0){
      //       negArr[j]=arr[i];
      //       j++;
      //       i++;
      //    }
      //    else{
      //       posArr[k]=arr[i];
      //       k++;i++;
      //    }
      // }
      // for( i=0;i<n;i++){
      //    arr[2*i]=posArr[i];
      //    arr[2*i+1]=negArr[i];
      // }
      // for( i=0;i<arr.length;i++){
      //    System.out.print(arr[i]+" ");
      // }


      //          Optimal appraoch   TC- O(n)    SC-> O(n) for giving answer
      // int posIndex=0,negIndex=1;
      // int ans[]=new int[arr.length];
      // for(int i=0;i<arr.length;i++){
      //    if(arr[i]<0){
      //       ans[negIndex]=arr[i];
      //       negIndex+=2;
      //    }
      //    else{
      //       ans[posIndex]=arr[i];
      //       posIndex+=2;
      //    }
      // }
      // for (int i=0;i<arr.length;i++) {
      //    System.out.print(ans[i]+" ");
      // }







      //             Approach when the (no. of neg element)!=(no. pos element)
      ArrayList<Integer>pos=new ArrayList<>();
      ArrayList<Integer>neg= new ArrayList<>();
      for(int i=0;i<arr.size();i++){
         if(arr.get(i)<0){
            neg.add(arr.get(i));
         }
         else{
            pos.add(arr.get(i));
         }
      }
      if(pos.size()<neg.size()){
         for(int i=0;i<pos.size();i++){
            arr.set(2*i,pos.get(i));
            arr.set(2*i+1, neg.get(i));
         }
         int index=pos.size()*2;
         for(int i=pos.size();i<neg.size();i++){
            arr.set(index, neg.get(i));
            index++;
         }
      }
      else{
         for(int i=0;i<neg.size();i++){
            arr.set(2*i, pos.get(i));
            arr.set(2*i+1, neg.get(i));
         }
         int index=neg.size()*2;
         for(int i=neg.size();i<pos.size();i++){
            arr.set(index, pos.get(i));
            index++;
         }
      }
      for(int i=0;i<arr.size();i++){
         System.out.print(arr.get(i)+" ");
      }
   }   public static void main(String[] args) {
      ArrayList<Integer>arr= new ArrayList<>();
      arr.add(5);
      arr.add(6);
      arr.add(-4);
      arr.add(-2);
      arr.add(7);
      arr.add(3);
      arr.add(1);
      arr.add(-5);
      arr.add(8);
      arr.add(-9);
      arr.add(9);
      arr.add(10);
      arr.add(3);
      rearrangeArrayPosNeg(arr);
       
       }
   }

