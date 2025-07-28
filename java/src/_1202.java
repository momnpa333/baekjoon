import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1202 {
    static int N,K;
    static PriorityQueue<Item> pq;
    static PriorityQueue<Integer> bags;
    static Item[] items;
    static long answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken()); K=Integer.parseInt(st.nextToken());

        pq=new PriorityQueue<>();
        bags=new PriorityQueue<>();
        items=new Item[N];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            int w=Integer.parseInt(st.nextToken()); int v=Integer.parseInt(st.nextToken());
            items[i]=new Item(w,v);
        }
        for(int i=0;i<K;i++){
            bags.add(Integer.parseInt(br.readLine()));
        }
        Arrays.sort(items, new Comparator<Item>() {

            @Override
            public int compare(Item o1, Item o2) {
                if(o1.w<o2.w){
                    return -1;
                }
                if (o1.w == o2.w) {
                    return o2.v - o1.v;
                }
                return 1;
            }

        });

        int idx=0;
        pq=new PriorityQueue<>();
//        System.out.println(Arrays.toString(items));
        while(!bags.isEmpty()){
            int bag=bags.poll();
            for(;idx<N;idx++){
//                System.out.println(items[idx]);
                if(items[idx].w>bag){
                    break;
                }
                pq.add(items[idx]);
            }
//            System.out.println(pq);
            if(!pq.isEmpty()){
                answer+=pq.poll().v;
            }
        }
        System.out.println(answer);


    }
    static class Item implements Comparable<Item>{
        int w;
        int v;
        Item(int w,int v){
            this.w=w;
            this.v=v;
        }

        public int compareTo(Item o){
            if(this.v>o.v){
                return -1;
            }
            if(this.v==o.v){
                return this.w-o.w;
            }
            return 1;
        }
        public String toString(){
            return w+" "+v;
        }
    }

}
