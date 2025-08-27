import java.util.*;

public class pascalTri {
    public static void main(String args[]){
        Scanner s= new Scanner(System.in);
        System.out.println("Which rows element do you want? ");
        int rowNo= s.nextInt();
        System.out.println("Which column element do you want? ");
        int colNo= s.nextInt();
        int ans=1;
        for(int i=rowNo-1;i>=colNo-1;i--){
            ans*=i;
            ans=ans/colNo;
        }
        System.out.println(ans);
    }
}
