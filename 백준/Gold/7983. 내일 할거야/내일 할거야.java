import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Item[] tasks;
    static int start=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());

        tasks=new Item[N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            tasks[i]=new Item(s,e);
        }
        Arrays.sort(tasks);

        for(int i=0;i<N;i++){
            if(start>tasks[i].end){
                start=tasks[i].end-tasks[i].start+1;
            }
            else{
                start=tasks[i].end-tasks[i].start+1-(tasks[i].end-start+1);
            }
        }
        System.out.println(start-1);


    }
    static class Item implements Comparable<Item>{
        int start;
        int end;
        Item(int start,int end){
            this.start=start;
            this.end=end;
        }
        public int compareTo(Item o){
            return o.end-this.end;
        }
    }

}
