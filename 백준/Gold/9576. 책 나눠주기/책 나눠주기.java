import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int N,M;
    static PriorityQueue<Item> pq=new PriorityQueue<>();
    static boolean[] visited;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        T=Integer.parseInt(st.nextToken());

        while(T-->0){
            st=new StringTokenizer(br.readLine()," ");
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            ans=0;
            visited=new boolean[1001];
            pq=new PriorityQueue<>();

            for(int i=0;i<M;i++){
                st=new StringTokenizer(br.readLine()," ");
                int s=Integer.parseInt(st.nextToken());
                int e=Integer.parseInt(st.nextToken());
                pq.add(new Item(s,e));
            }
            while(!pq.isEmpty()){
                Item item=pq.poll();
//                System.out.println(item);
                for(int i=item.s;i<=item.e;i++){
                    if(!visited[i]){
                        visited[i]=true;
                        ans++;
                        break;
                    }
                }
            }
            System.out.println(ans);
        }
    }
    static class Item implements Comparable<Item>{
        int s,e;
        Item(int s,int e){
            this.s=s;
            this.e=e;
        }
        public int compareTo(Item o){
            if(this.e==o.e){
                return this.s-o.s;
            }
            return this.e-o.e;
        }
        public String toString(){
            return s+" "+e;
        }
    }
}


