import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static int N;
    static Map<String,Long> map = new TreeMap<>();
    static Set<String> notZero=new HashSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            String s=br.readLine();
            calc(s);
        }
        long sum=0;
        PriorityQueue<Long> pq=new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Long> findZero=new PriorityQueue<>();
//        System.out.println(notZero);
        for(String key: map.keySet()){
            if(notZero.contains(key)){
                pq.add(map.get(key));
            }
            else{
                findZero.add(map.get(key));
            }
        }
        if(map.size()==10){
            if(!findZero.isEmpty()){
//                System.out.println(findZero);
                findZero.poll();
            }
        }
        while(!findZero.isEmpty()){
            pq.add(findZero.poll());
        }

        long cur=9;
        while(!pq.isEmpty()){
//            System.out.println(pq);
            sum+=pq.poll()*cur;
            cur--;
        }
        System.out.println(sum);
    }
    static void calc(String s){
        int size=s.length();
        notZero.add(""+s.charAt(0));
        for(int i=0;i<size;i++){
            Long cnt=map.getOrDefault(""+s.charAt(i),0L);
            map.put(""+s.charAt(i),cnt+ (long) Math.pow(10,size-i-1));
        }
    }
}
