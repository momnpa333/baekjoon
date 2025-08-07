import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _2655 {
    static int N;
    static Item[] items;
    static Note[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(st.nextToken());

        items=new Item[N+1];
        PriorityQueue<Item> pq=new PriorityQueue<>();
        dp=new Note[N+1];

        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine()," ");
            pq.add(new Item(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),i));
        }
        for(int i=1;i<=N;i++){
            items[i]=pq.poll();
        }
        items[0]=new Item(10000,10000,10000,0);

        dfs(0,0);

        System.out.println(dp[0].hist.size()-1);
        for(int i=dp[0].hist.size()-1;i>0;i--){
            System.out.println(dp[0].hist.get(i));
        }

    }
    static Note dfs(int start,int curH){
        Note ret=new Note(items[start].h);
        ret.hist.add(items[start].idx);
        Note cmp=new Note(0);

        if(dp[start]!=null){
            return dp[start];
        }
        for(int i=start+1;i<=N;i++){
            Note tmp;
            if(items[i].s<=items[start].s && items[i].w<=items[start].w){
                tmp=dfs(i,curH+items[i].h);
                if(tmp.h>cmp.h){
                    cmp=tmp;
                }
            }
        }

        ret.h+=cmp.h;
        ret.hist.addAll(cmp.hist);
        dp[start]=ret;
        return ret;
    }

    static class Item implements Comparable<Item>{
        int s;
        int h;
        int w;
        int idx;
        Item(int s,int h,int w,int idx){
            this.s=s;
            this.h=h;
            this.w=w;
            this.idx=idx;
        }
        public String toString(){
            return s+" "+h+" "+w;
        }
        public int compareTo(Item o){
            if(this.s>o.s){
                return -1;
            }
            if(this.s==o.s){
                if(this.w>o.w){
                    return -1;
                }
                if(this.w==o.w){
                    return o.h-this.h;
                }
            }
            return 1;
        }
    }
    static class Note{
        int h;
        ArrayList<Integer> hist=new ArrayList<>();
        Note(int h){
            this.h=h;
        }
    }

}
