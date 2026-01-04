import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static PriorityQueue<Integer> pq=new PriorityQueue<>();
//    static PriorityQueue<Integer> maxQ=new PriorityQueue<>(Comparator.reverseOrder());
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine()," ");

        for(int i=0;i<N;i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }
//        System.out.println(pq);
        for(int i=0;i<(N+1)/2;i++){
            int item=pq.poll();
//            System.out.println((int) (Math.log(item)/Math.log(2)));
            ans+= (int) (Math.log(item)/Math.log(2));
        }
//        while(true){
//            ans++;
//            int item = maxQ.poll();
//            item=item/2;
//            if(item==0) break;
//            maxQ.add(item);
//        }
        System.out.println(ans+1);
    }
}


