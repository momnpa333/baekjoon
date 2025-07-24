import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _15664 {
    static int N,M;
    static int[] seq;
    static Set<String> check;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check=new HashSet<>();

        seq=new int[N];

        st=new StringTokenizer(br.readLine()," ");

        for(int i=0;i<N;i++){
            seq[i]=Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.toString(seq));
        Arrays.sort(seq);
        int[] cur=new int[M];
        dfs(0,0,cur);
    }
    static void dfs(int depth,int start,int[] cur) throws IOException {
        String tmp="";
        if(depth==M){
            for(int i=0;i<M;i++){
                tmp+=cur[i]+" ";
            }
            if(!check.contains(tmp)){
                check.add(tmp);
                System.out.println(tmp);
            }
            return;
        }
        for(int i=start;i<N;i++){
            cur[depth]=seq[i];
            dfs(depth+1,i+1,cur);
        }

    }


}
