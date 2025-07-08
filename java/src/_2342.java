import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2342 {
    static int[][][] dp;
    static int[] notes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input=br.readLine().split(" ");
        notes=new int[input.length+1];

        for(int i=1;i<=input.length;i++){
            notes[i]=Integer.parseInt(input[i-1]);
        }

        dp=new int[input.length+1][5][5];

        System.out.println(dfs(1,0,0));

    }

    static int dfs(int depth,int left,int right){
        if(notes[depth]==0){
            return 0;
        }
        if(dp[depth][left][right]!=0){
            return dp[depth][left][right];
        }

        dp[depth][left][right]=Math.min(dfs(depth+1,notes[depth],right)+move(left,notes[depth]),dfs(depth+1,left,notes[depth])+move(right,notes[depth]));
        return dp[depth][left][right];
    }
    static int move(int cur,int next){
        if(cur==next){
            return 1;
        }
        if(cur==0){
            return 2;
        }
        if(Math.abs(cur-next)==2){
            return 4;
        }
        else{
            return 3;
        }
    }
}
