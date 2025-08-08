import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _15961 {
    static int N;
    static int D;
    static int K;
    static int C;
    static int[] convey;
    static int answer;
    static HashMap<Integer,Integer> sushiSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        D=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());

        convey=new int[N+K-1];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine(),"");
            convey[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=N;i<N+K-1;i++){
            convey[i]=convey[i-N];
        }

        sushiSet=new HashMap<>();
        for(int i=0;i<K;i++){
            sushiSet.put(convey[i],sushiSet.getOrDefault(convey[i],0)+1);
        }
        if(!sushiSet.containsKey(C)){
            answer=Math.max(answer,sushiSet.size()+1);
        }
        else{
            answer=Math.max(answer,sushiSet.size());
        }

        for(int l=0,r=K;l<N-1;l++,r++){
            int tmp=sushiSet.get(convey[l]);
            if(tmp==1){
                sushiSet.remove(convey[l]);
            }
            else{
                sushiSet.put(convey[l],sushiSet.get(convey[l])-1);
            }
            sushiSet.put(convey[r],sushiSet.getOrDefault(convey[r],0)+1);

            if(!sushiSet.containsKey(C)){
                answer=Math.max(answer,sushiSet.size()+1);
            }
            else{
                answer=Math.max(answer,sushiSet.size());
            }
        }
        System.out.println(answer);



    }
    static class Item{
        int id;
        int cnt;

        Item(int id,int cnt){
            this.id=id;
            this.cnt=cnt;
        }
    }
}
