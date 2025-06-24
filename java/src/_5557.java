import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _5557 {
    static int N;
    static int[] nums;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        dp = new long[N+1][21];
        nums=new int[N+1];
        for(int i=1;i<=N;i++){
            nums[i]=Integer.parseInt(st.nextToken());
        }
        dp[1][nums[1]]=1;
        for(int r=2;r<N;r++){
            for(int result=0;result<21;result++){
//                System.out.printf("r:%d result:%d\n",r,result);
                if(result-nums[r]>=0 && dp[r-1][result]!=0 ){
                    dp[r][result-nums[r]]+=dp[r-1][result];
                }
                if( result+nums[r]<21 && dp[r-1][result]!=0){
                    dp[r][result+nums[r]]+=dp[r-1][result];
                }
            }
        }
        System.out.println(dp[N-1][nums[N]]);

    }
}
