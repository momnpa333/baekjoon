import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int N;
    static int[] cost;
    static PriorityQueue<Item> pq=new PriorityQueue<>();
//    static PriorityQueue<Item> choice;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        cost=new int[10001];
        PriorityQueue<Item> choice=new PriorityQueue<>(Comparator.comparingInt(i -> i.v));

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            int v=Integer.parseInt(st.nextToken());
            int date=Integer.parseInt(st.nextToken());
            pq.add(new Item(date,v));
        }
        int curDate=0;
        while(true){
            if(curDate>10000) break;
            curDate++;
            while(!pq.isEmpty()){
//                System.out.println(pq);
                if(pq.peek().date<=curDate){
                    Item item=pq.poll();
                    if(choice.size()<curDate){
                        choice.add(item);
                    }
                    else{
                        if(choice.peek().v<item.v){
                            choice.poll();
                            choice.add(item);
                        }
                    }
                }
                else{
                    break;
                }
            }
        }
        int sum=0;
        for(Item item:choice){
            sum+=item.v;
        }
        System.out.println(sum);

    }
    static class Item implements Comparable<Item>{
        int date;
        int v;
        Item(int date,int v){
            this.date=date;
            this.v=v;
        }
        public int compareTo(Item o){
            if(this.date==o.date){
                return o.v-this.v;
            }
            return this.date-o.date;
        }
        public String toString(){
            return "date: "+date+" v: "+v;
        }
    }
}
