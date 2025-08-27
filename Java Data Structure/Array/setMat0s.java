import java.util.Scanner;


public class setMat0s {
   // public static int[][] markCols(int j , int arr[][],int col ){
   //       for(int i=0;i<col;i++){
   //          if(arr[i][j]==0){
   //             arr[i][j]=-1;
   //          }
   //       }
   //       return arr;
   //    }
   // public static int [][] markRows(int i, int arr[][], int row ){
   //       for(int j=0;j<row;j++){
   //          if(arr[i][j]==0){
   //             arr[i][j]=-1;
   //          }
   //       }
   //       return arr;
   // }
   // public static void setMatrixZeroes(int arr[][], int row, int col){
   //    for(int i=0;i<row;i++){
   //       for(int j=0;j<col;j++){
   //          if(arr[i][j]==0){
   //             markRows(i,arr,col);
   //             markCols(j,arr,row);
   //          }
   //       }
   //    }

   //    for(int i=0;i<row;i++){
   //       for(int j=0;j<col;j++){
   //          if(arr[i][j]==-1){
   //             arr[i][j]=0;
   //          }
   //       }
   //    }
   //    for(int i=0;i<row;i++){
   //       for(int j=0;j<col;j++){
   //         System.out.print(arr[i][j]+" ");
   //       }
   //       System.out.println();
   //    }


   //   BETTER APPROACH       TC->O(2(n*m))   SC-> O(n)+O(m)

   public static void setMatrixZeroes(int arr[][], int n, int m){
     int rows[]= new int[n];
     int cols[]= new int[m];
      for(int i=0;i<n;i++){
         for(int j=0;j<m;j++){
            if(arr[i][j]==0){
               rows[i]=-1;
               cols[j]=-1;
            }
         }
      }
      for(int i=0;i<n;i++){
         for(int j=0;j<m;j++){
            if(rows[i]==-1 || cols[j]==-1){
               arr[i][j]=0;
            }
         }
      }
      for(int i=0;i<n;i++){
         for(int j=0;j<m;j++){
            System.out.print(arr[i][j]+" ");
         }
         System.out.println();
      }

   }
      //          Optimal Approach

   // public static void setMatrixZeroes(int arr[][], int n, int m){
   //    int col0=1;
   //    for(int i=0;i<n;i++){
   //       for(int j=0;j<m;j++){
   //          if(arr[i][j]==0){
   //             arr[i][0]=0;
   //             if(j!=0){
   //                arr[0][j]=0;
   //             }
   //             else{
   //                col0=0;
   //             }
   //          }

   //       }
   //    }
   //    for(int i=1;i<n;i++){
   //       for(int j=1;j<m;j++){
   //          if(arr[i][j]!=0){
   //             if(arr[i][0]==0 || arr[0][j]==0){
   //                arr[i][j]=0;
   //             }
   //          }
   //       }
   //    }
   //    if(arr[0][0]==0){
   //       for(int j=0;j<m;j++){
   //          arr[0][j]=0;
   //       }
   //    }
   //    if(col0==0){
   //       for(int i=0;i<n;i++){
   //          arr[i][0]=0;
   //       }
   //    }
   //    for (int i = 0; i <n; i++) {
   //       for (int j = 0; j < m; j++) {
   //          System.out.print(arr[i][j]+" ");
   //       }
   //       System.out.println();
   //    }
   // }


   public static void main(String[] args) {
      Scanner s= new Scanner(System.in);
      System.out.println("Give the number of row in 2d array: ");
      int row= s.nextInt();
      System.out.println("Give the number of column in 2d array: ");
      int col= s.nextInt();
      int arr[][]= new int[row][col];
      for(int i=0;i<row;i++){
         for(int j=0;j<col;j++){
            arr[i][j]=s.nextInt();
         }
      }
     
     setMatrixZeroes(arr,row,col);
   }
}
