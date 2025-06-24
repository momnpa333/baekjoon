import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class _15666 {
    static Set<Integer> numSet;
    static int N,M;
    static List<String> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        numSet=new TreeSet<>();

        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N=Integer.parseInt(st.nextToken()); M=Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            numSet.add(Integer.parseInt(st.nextToken()));
        }
        answer=new ArrayList<>();
        for(Integer v: numSet){
            dfs(1,Integer.toString(v),v);
        }

        for(String ans:answer){
            System.out.println(ans);
        }

    }

    static void dfs(int depth,String hist,int item){
        if(depth==M){
            answer.add(hist);
            return;
        }
        for(Integer v: numSet){
            if(v>=item)
                dfs(depth+1,hist+" "+Integer.toString(v),v);
        }

    }



}
