import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static long N;
    static PriorityQueue<Long> positiveQ;
    static PriorityQueue<Long> negativeQ;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        positiveQ=new PriorityQueue<>(Comparator.reverseOrder());
        negativeQ=new PriorityQueue<>();
        N=Long.parseLong(st.nextToken());
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            long item=Long.parseLong(st.nextToken());
            if(item>0){
                positiveQ.add(item);
            }
            else{
                negativeQ.add(item);
            }
        }
        long positiveSum=0;
        while(!positiveQ.isEmpty()){
//            System.out.println(positiveQ);
            if(positiveQ.peek()==1){
                positiveSum+=positiveQ.poll();
                continue;
            }
            if(positiveQ.size()>1){
                long item1=positiveQ.poll();
                long item2=positiveQ.poll();
                if(item2==1){
                    positiveSum+=item1+item2;
                }
                else{
                    positiveSum+=item1*item2;
                }
            }
            else{
                positiveSum+=positiveQ.poll();
            }
        }
        long negativeSum=0;
        while(!negativeQ.isEmpty()){
//            System.out.println(negativeQ);
            if(negativeQ.size()>1){
                long item1=negativeQ.poll();
                long item2=negativeQ.poll();
                negativeSum+=item1*item2;
            }
            else{
                negativeSum+=negativeQ.poll();
            }
        }
        System.out.println(positiveSum+negativeSum);
    }
}
