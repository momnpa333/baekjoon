import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _13913 {
    static int N,K;
    static int[] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        visited=new int[100001];
        Arrays.fill(visited,Integer.MAX_VALUE);

        N=Integer.parseInt(st.nextToken()); K=Integer.parseInt(st.nextToken());
        ArrayDeque<int[]> dq=new ArrayDeque<>();

        visited[N]=N;
        if(N!=K)
            dq.add(new int[]{N,0});


        A:
        while(!dq.isEmpty()){
            int L=dq.size();
//            System.out.println(dq);
            for(int i=0;i<L;i++){
                int[] item=dq.pollLast();

                ArrayList<Integer> tmp=new ArrayList<>();
                tmp.add(item[0]+1); tmp.add(item[0]-1); tmp.add(item[0]*2);
                for(int pos:tmp){
                    if(pos==K){
                        visited[pos]=item[0];
                        cnt=item[1]+1;
                        break A;
                    }
                    if(pos>=0 && pos<=100000 && visited[pos]==Integer.MAX_VALUE){
                        visited[pos]=item[0];
                        dq.addFirst(new int[]{pos,item[1]+1});
                    }
                }

            }
        }
//        System.out.println(K);
//        System.out.println(Arrays.toString(visited));
        ArrayDeque<Integer> hist=new ArrayDeque<>();
        int cur=K;
        bw.write(cnt+"\n");
        while(true){
//            System.out.println(cur);
            hist.addFirst(cur);
            if(cur==N){
                break;
            }
            cur=visited[cur];
        }
        for(int i:hist){
            bw.write(i+" ");
        }

//        System.out.println("!!");
//        System.out.println(cnt);

        bw.flush();
    }
}
