import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class _1655 {
    static int N;
    static PriorityQueue<Integer> maxHeap;
    static PriorityQueue<Integer> minHeap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        minHeap=new PriorityQueue<>();
        N=Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            if(i%2==0){
                maxHeap.add(Integer.parseInt(br.readLine()));
            }
            else{
                minHeap.add(Integer.parseInt(br.readLine()));
            }
            if(!minHeap.isEmpty() && maxHeap.peek()>minHeap.peek()){
                int tmp=minHeap.poll(); int tmp1=maxHeap.poll();
                minHeap.add(tmp1); maxHeap.add(tmp);
            }
            System.out.println(maxHeap.peek());
        }

    }

}
