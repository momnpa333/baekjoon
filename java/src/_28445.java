import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class _28445 {
    static String[] colors;
    static PriorityQueue<Bird> pq;
    static Set<String> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        colors=new String[4];
        pq=new PriorityQueue<>();
        answer=new TreeSet<>();

        colors[0]=st.nextToken();
        colors[1]=st.nextToken();
        st=new StringTokenizer(br.readLine()," ");
        colors[2]=st.nextToken();
        colors[3]=st.nextToken();

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                answer.add(colors[i]+" "+colors[j]);
            }
        }

        for(String s:answer){
            System.out.println(s);
        }

    }
    static class Bird implements Comparable<Bird>{
        String body;
        String tail;
        Bird(String body,String tail){
            this.body=body;
            this.tail=tail;
        }
        public int compareTo(Bird o){
            if(body.compareTo(o.body)==0){
                return tail.compareTo(o.tail);
            }
            return body.compareTo(o.body);
        }
        public String toString(){
            return body+" "+tail;
        }
    }
}
