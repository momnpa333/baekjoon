import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Problem> pq=new PriorityQueue<>();
        PriorityQueue<Integer> bag=new PriorityQueue<>();

        N=Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            int d=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());

            pq.add(new Problem(d,v));
        }

        while (!pq.isEmpty()){
            Problem item=pq.poll();

            if(item.deadline>bag.size()){
                bag.add(item.value);
            }
            else{
                if(item.value>bag.peek()){
                    bag.poll();
                    bag.add(item.value);
                }
            }

        }
//        System.out.println(bag);
        while(!bag.isEmpty()){
            ans+=bag.poll();
        }
        System.out.println(ans);

    }
    static class Problem implements Comparable<Problem>{
        int deadline;
        int value;

        Problem(int deadline,int value){
            this.deadline=deadline;
            this.value=value;
        }
        public int compareTo(Problem o){
            if(this.deadline==o.deadline){
                return o.value-this.value;
            }
            return this.deadline-o.deadline;
        }
    }

}
