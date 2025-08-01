import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1068 {
    static int N;
    static ArrayList<Integer>[] tree;
    static int root;
    static int remove;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        tree=new ArrayList[N];
        for(int i=0;i<N;i++){
            tree[i]=new ArrayList<>();
        }
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            int parent=Integer.parseInt(st.nextToken());
            if(parent==-1){
                root=i;
                continue;
            }
            tree[parent].add(i);
        }
        remove=Integer.parseInt(br.readLine());
        if(remove==root){
            System.out.println(0);
            return;
        }

        ArrayDeque<Integer> dq=new ArrayDeque<>();
        dq.add(root);
        while(!dq.isEmpty()){
            int cur=dq.poll();
            int cnt=0;
            for(int child:tree[cur]){
                if(child==remove){
                    continue;
                }
                dq.add(child);
                cnt++;
            }
            if(cnt==0){
                answer++;
            }
        }
        System.out.println(answer);
    }

}
