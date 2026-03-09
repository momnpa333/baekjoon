import java.io.*;
import java.util.*;

public class Main {
    static int N,M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T=Integer.parseInt(st.nextToken());
        while(T-->0){
            st=new StringTokenizer(br.readLine());
            long price=Long.parseLong(st.nextToken());
            System.out.println(getDepth(price));
        }
    }
    static long getDepth(long price){
        PriorityQueue<Item> pq=new PriorityQueue<>();
        pq.add(new Item(0L,price));
        long ret=987654321543210L;
        while(!pq.isEmpty()){
//            System.out.println(pq);
            Item item=pq.poll();
            if(item.v==0){
                if(item.depth<ret){
                    ret=item.depth;
                }
                continue;
            }
            if(item.depth>ret){
                continue;
            }
            long base=(long) Math.pow(10,(int)(Math.log10(item.v))+1);
            int base2=(int)(Math.log10(item.v));
//            System.out.println(item.v+" "+base+" "+base2);

            long op1=base/4;
            long op2=base/10;
//            System.out.println(op1);
//            System.out.println(op2);
//            System.out.println(item.v>=op1);
//            System.out.println(item.v>=op2);
            if(item.v<10){
                pq.add(new Item(item.depth+item.v,0L));
                continue;
            }
            if (base2 % 2 == 1) {
                long maxK = item.v / op1; 
                for (long k = 0; k <= maxK; k++) {
                    long remaining = item.v - k * op1;
                    long nd = item.depth + k + remaining / op2;
                    long nv = remaining % op2;
                    pq.add(new Item(nd, nv));
                }
            } else {
                pq.add(new Item(item.depth + item.v / op2, item.v % op2));
            }
        }
        return ret;
    }
    static class Item implements Comparable<Item>{
        long depth;
        long v;
        Item(long depth,long v){
            this.depth=depth;
            this.v=v;
        }
        public int compareTo(Item o){
            if(this.depth<o.depth){
                return -1;
            }
            return 1;
        }
        public String toString(){
            return depth+" "+v;
        }
    }
}
