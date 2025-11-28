import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static boolean[][] bell;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        bell=new boolean[N][M];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                bell[i][j]= Objects.equals(st.nextToken(), "1");
            }
//            System.out.println(Arrays.toString(bell[i]));
        }
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(!isPossible(bell[i],bell[j])){
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
    static boolean isPossible(boolean[] a,boolean[] b){
        boolean op1=false;
        boolean op2=false;
        for(int i=0;i<M;i++){
            if(a[i] && !b[i]){
                op1=true;
            }
            else if(!a[i] && b[i]){
                op2=true;
            }
            if(op1 && op2){
                return false;
            }
        }
        return true;
    }

}


