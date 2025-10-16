import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[] depth;
    static int[] seq;
    static ArrayDeque<Integer> dq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());

        tree=new ArrayList[N+1];
        visited=new boolean[N+1];
        depth=new int[N+1];
        seq=new int[N];
        for(int i=0;i<=N;i++){
            tree[i]=new ArrayList<>();
        }

        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(br.readLine()," ");
            int S=Integer.parseInt(st.nextToken());
            int E=Integer.parseInt(st.nextToken());
            tree[S].add(E);
            tree[E].add(S);
        }
        st=new StringTokenizer(br.readLine()," ");

        for(int i=0;i<N;i++){
            seq[i]=Integer.parseInt(st.nextToken());
        }

        dq=new ArrayDeque<>();
        dq.add(1);
        visited[1]=true;
        Set<Integer> childSet;
        int idx=1;

        while(!dq.isEmpty()){
            int item=dq.poll();
            childSet=new HashSet<>();
            for(int child:tree[item]){
                if(!visited[child]){
                    childSet.add(child);
                    visited[child]=true;
                }
            }
//            System.out.println(childSet);
            for(int i=0;i<childSet.size();i++){
//                System.out.printf("%d %d\n",idx,seq[idx]);
                if(!childSet.contains(seq[idx])){
                    System.out.println(0);
                    return;
                }
                dq.add(seq[idx++]);
            }
        }
        System.out.println(1);

    }
}