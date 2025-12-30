import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int[][] matrix;
    static int N,M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        T=Integer.parseInt(st.nextToken());
        while(T-->0){
            st=new StringTokenizer(br.readLine()," ");
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            matrix=new int[N][M];
            for(int i=0;i<N;i++){
                st=new StringTokenizer(br.readLine()," ");
                for(int j=0;j<M;j++){
                    matrix[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(isPossible());
        }
    }
    static String isPossible(){
        for(int r=0;r<N-1;r++){
            for(int c=0;c<M-1;c++){
                if(matrix[r][c]-matrix[r+1][c]>matrix[r][c+1]-matrix[r+1][c+1]){
                    return "NO";
                }
            }
        }
        return "YES";
    }
}