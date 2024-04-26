import java.util.Arrays;
import java.util.Scanner;

public class _7568 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[][] arr=new int[N][3];

        for(int i=0;i<N;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
            arr[i][2]=1;
        }
        for(int[] tar:arr){
            for(int []comp:arr){
                if(tar[0]<comp[0]&&tar[1]<comp[1]){
                    tar[2]++;
                }
            }
        }
        for(int i=0;i<N;i++){
            System.out.print(arr[i][2]+" ");
        }

    }

}