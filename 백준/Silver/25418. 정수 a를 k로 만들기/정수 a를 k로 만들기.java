import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int A,K;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        A=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        visited=new boolean[K];

        PriorityQueue<Integer[]> pq=new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.add(new Integer[]{0,A});
        visited[A]=true;

        while(!pq.isEmpty()){
            Integer[] item=pq.poll();
            int op1=item[1]+1;
            int op2=item[1]*2;
            if(op1==K || op2==K){
                System.out.println(item[0]+1);
                return;
            }
            if(op1<=K &&!visited[op1]){
                visited[op1]=true;
                pq.add(new Integer[]{item[0]+1,op1});
            }
            if(op2<=K && !visited[op2]){
                visited[op2]=true;
                pq.add(new Integer[]{item[0]+1,op2});
            }
        }
    }
}
