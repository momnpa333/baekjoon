import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int[][][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; //= new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp=new int[51][51][51];
        while(true){
            st=new StringTokenizer(br.readLine()," ");
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());

            if(a==-1 && b==-1 && c==-1) return;
            int v=w(a,b,c);
            //w(1, 1, 1) = 2
            System.out.printf("w(%d, %d, %d) = %d\n",a,b,c,v);

        }
    }
    static int w(int a,int b,int c){
        if(a<=0 || b<=0 || c<=0){
            return 1;
        }
        if(dp[a][b][c]!=0){
            return dp[a][b][c];
        }
        if(a>20 || b>20 || c>20){
            dp[a][b][c]=w(20,20,20);
            return dp[a][b][c];
        }
        if(a<b && b<c){
            dp[a][b][c]=w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
            return dp[a][b][c];
        }
        dp[a][b][c]=w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        return dp[a][b][c];
    }
}

//if a <= 0 or b <= 0 or c <= 0, then w(a, b, c) returns:
//    1
//
//    if a > 20 or b > 20 or c > 20, then w(a, b, c) returns:
//w(20, 20, 20)
//
//if a < b and b < c, then w(a, b, c) returns:
//w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
//
//otherwise it returns:
//w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)

