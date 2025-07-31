import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1774 {

    static int N, M;
    static int[][] dots;
    static int[] parent;
    static double answer;
    static PriorityQueue<Item> pq=new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dots = new int[N+1][2];
        parent = new int[N+1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            st = new StringTokenizer(br.readLine(), " ");
            dots[i][0] = Integer.parseInt(st.nextToken());
            dots[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(findParent(a),findParent(b));
        }
        for(int i=1;i<N;i++){
            for(int j=i+1;j<=N;j++){
                double len=getLength(i,j);
                pq.add(new Item(i,j,len));
            }
        }
        while (!pq.isEmpty()){
            Item item=pq.poll();
            if(findParent(item.v1)==findParent(item.v2)){
                continue;
            }
            union(item.v1, item.v2);
            answer+=item.l;
        }

        System.out.printf("%.2f",answer);


    }

    static void union(int a, int b) {
        int parentA = findParent(a);
        int parentB = findParent(b);

        if (parentA < parentB) {
            parent[parentB] = parentA;
        } else {
            parent[parentA] = parentB;
        }
    }

    static int findParent(int child) {
        if (parent[child] != child) {
            return parent[child] = findParent(parent[child]);
        }
        return child;
    }

    static double getLength(int a, int b) {
        return Math.sqrt(
            Math.pow(dots[a][0] - dots[b][0], 2) + Math.pow(dots[a][1] - dots[b][1], 2));
    }
    static class Item implements Comparable<Item>{
        int v1;
        int v2;
        double l;
        Item(int v1,int v2,double l){
            this.v1=v1;
            this.v2=v2;
            this.l=l;
        }
        public int compareTo(Item o){
            if(this.l<o.l){
                return -1;
            }
            return 1;
        }
    }
}
