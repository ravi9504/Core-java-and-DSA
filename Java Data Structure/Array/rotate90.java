import java.util.*;

public class rotate90 {

   // Brute force approach TC->O(n^2) SC->O(n^2)
   public static void rotate90degreeMatrix(int matrix[][]) {
      // int ans[][]= new int[4][4];
      // for(int i=0;i<4;i++){
      // for(int j=0;j<4;j++){
      // ans[j][3-i]=matrix[i][j];
      // }
      // }
      // for (int i = 0; i < 4; i++) {
      // for (int j = 0; j < 4; j++) {
      // System.out.print(ans[i][j]+" ");
      // }
      // System.out.println();
      // }
      // for (int i = 0; i < 4; i++) {
      // for (int j = 0; j < 4; j++) {
      // System.out.print(matrix[i][j]+" ");
      // }
      // System.out.println();
      // }

      // Optimal Appraoch

      for (int i = 0; i < 4; i++) {
         for (int j = 0; j < 4; j++) {
            System.out.print(matrix[i][j] + " ");
         }
         System.out.println();
      }

      int n = matrix.length;
      // transpose
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
         }
      }
      for (int i = 0; i < 4; i++) {
         for (int j = 0; j < 4; j++) {
            System.out.print(matrix[i][j] + " ");
         }
         System.out.println();
      }
      // reverse the row
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n / 2; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[i][n - 1 - j];
            matrix[i][n - 1 - j] = temp;
         }
      }
      for (int i = 0; i < 4; i++) {
         for (int j = 0; j < 4; j++) {
            System.out.print(matrix[i][j] + " ");
         }
         System.out.println();
      }

   }

   public static void main(String[] args) {
      int matrix[][] = new int[4][4];
      matrix[0][0] = 1;
      matrix[0][1] = 2;
      matrix[0][2] = 3;
      matrix[0][3] = 4;
      matrix[1][0] = 5;
      matrix[1][1] = 6;
      matrix[1][2] = 7;
      matrix[1][3] = 8;
      matrix[2][0] = 9;
      matrix[2][1] = 10;
      matrix[2][2] = 11;
      matrix[2][3] = 12;
      matrix[3][0] = 13;
      matrix[3][1] = 14;
      matrix[3][2] = 15;
      matrix[3][3] = 16;

      rotate90degreeMatrix(matrix);
   }
}
