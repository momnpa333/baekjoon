import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[] A;
    static char[] B;
    static int[][] lca;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        A=br.readLine().toCharArray();
        int L=A.length;
        B=new char[L];
        for(int i=0;i<L;i++){
            B[i]=A[L-i-1];
        }
        lca=new int[L+1][L+1];

        for(int i=1;i<=L;i++){
            for(int j=1;j<=L;j++){
                if(A[i-1]==B[j-1]){
                    lca[i][j]=lca[i-1][j-1]+1;
                }
                lca[i][j]=Math.max(lca[i][j],lca[i-1][j]);
                lca[i][j]=Math.max(lca[i][j],lca[i][j-1]);
            }
        }
        System.out.println(L-lca[L][L]);



    }
}

