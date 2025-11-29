import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K;
    static ArrayDeque<Item>[] dq;
    static PriorityQueue<Item> pq;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        dq=new ArrayDeque[M+1];
        pq=new PriorityQueue<>();
        for(int i=1;i<=M;i++){
            dq[i]=new ArrayDeque<>();
        }
        int id=0;
        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine()," ");
            int d=Integer.parseInt(st.nextToken());
            int h=Integer.parseInt(st.nextToken());
            int idx=i%M==0?M:i%M;
            dq[idx].add(new Item(idx,d,h,id++));
        }
        for(int i=1;i<=M;i++){
            if(!dq[i].isEmpty())
                pq.add(dq[i].peek());
        }
        int cnt=0;
        while(!pq.isEmpty()){
            Item item=pq.poll();
            if(item.id==K){
                System.out.println(cnt);
                return;
            }
            cnt++;
            dq[item.idx].poll();
            if(!dq[item.idx].isEmpty())
                pq.add(dq[item.idx].peek());
        }





    }
    static class Item implements Comparable<Item>{
        int idx,d,h,id;
        Item(int idx,int d,int h,int id){
            this.idx=idx;
            this.d=d;
            this.h=h;
            this.id=id;
        }
        public int compareTo(Item o){
            if(this.d!=o.d){
                return o.d-this.d;
            }
            if(this.h!=o.h){
                return o.h-this.h;
            }
            return this.idx-o.idx;
        }
        public String toString(){
            return d+" "+h;
        }
    }

}


