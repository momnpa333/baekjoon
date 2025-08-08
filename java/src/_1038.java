import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1038 {
    static int N;
    static int[][] dp;
    static String answer="";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        dp=new int[10][11];

        for(int i=0;i<10;i++){
            dp[i][1]=1;
        }
//        dp[0][1]=0;
        for(int i=2;i<=10;i++){ //자리수
            for(int j=0;j<10;j++){  //가장 큰 수
                for(int k=0;k<j;k++){
                    dp[j][i]+=dp[k][i-1];
                }
            }
        }
        int cur=-1;
        A:
        for(int i=1;i<=10;i++){
            for(int j=0;j<10;j++){
                cur+=dp[j][i];
                if(cur>=N){
                    answer+=j;
                    findAns(i,j,cur-dp[j][i]);
                    break A;
                }
            }
        }
        if(answer.isEmpty()){
            System.out.println(-1);
        }
        else{
            System.out.println(answer);
        }
//        for(int i=0;i<10;i++){
//            System.out.println(Arrays.toString(dp[i]));
//
//        }
    }
    static void findAns(int idx,int num,int cur){
        if(idx==1){
            return;
        }
        for(int i=0;i<num;i++){
            cur+=dp[i][idx-1];
            if(cur>=N){
                answer+=i;
                findAns(idx-1,i,cur-dp[i][idx-1]);
                return;
            }
        }
    }


}
