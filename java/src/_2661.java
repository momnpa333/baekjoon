import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2661 {
    static int N;
    static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N=Integer.parseInt(st.nextToken());
        dfs("");
        System.out.println(answer);

    }
    static void dfs(String num){
        if(answer!=null){
            return;
        }
        if(num.length()>=N){
            answer=num;
            return;
        }
        for(int i=1;i<=3;i++){
            String st=num+i;
            if(isGood(st)){
                dfs(st);
            }
        }
    }
    static boolean isGood(String st){
        for(int i=1;i<st.length();i++){
            for(int j=0;j<st.length();j++){
                if(st.length()<j+i+i){
                    break;
                }
                if(st.substring(j,j+i).equals(st.substring(j+i,j+i+i))){
                    return false;
                }
            }
        }
        return true;
    }
}
