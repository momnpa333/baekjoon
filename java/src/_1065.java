import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1065 {
    static int N;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        for(int i=1;i<=N;i++){
            if(solve(i)){
                ans++;
            }
        }

        System.out.println(ans);
    }

    static boolean solve(int n){
        int gap;
        String num=String.valueOf(n);
        if(num.length()==1){
            return true;
        }
        gap=(num.charAt(1)-num.charAt(0))-'0';
        for(int i=1;i<num.length();i++){
            if(num.charAt(i)-num.charAt(i-1)-'0'!=gap){
                return false;
            }
        }
        return true;
    }

}
