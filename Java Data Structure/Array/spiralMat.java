import java.util.*;

public class spiralMat {
    public static void spiralMatrix(int mat[][],int n, int m){
        int left=0, right=m-1;
        int top=0, bottom=n-1;
        ArrayList<Integer>ans= new ArrayList<>();
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                ans.add(mat[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                ans.add(mat[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i=right;i<=left;i++){
                    ans.add(mat[bottom][i]);
                }
                bottom--;
            }
            if(right<=top){
                for(int i=bottom;i>=top;i--){
                    ans.add(mat[i][left]);
                }
                left++;
            }
        }
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat.length;j++){
                System.out.print(mat[i][j]);
            }
            System.out.println();

        }
    }
    public static void main(String args[]) {
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

      spiralMatrix(arr, row, col );
    }
}
