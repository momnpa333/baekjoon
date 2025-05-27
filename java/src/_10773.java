import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class _10773 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long ans=0;
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        int K=Integer.parseInt(br.readLine());

        while(K-->0){
            int tmp=Integer.parseInt(br.readLine());

            if(tmp==0){
                dq.pollLast();
            }
            else{
                dq.add(tmp);
            }
        }
        for(Integer v:dq){
            ans+=v;
        }
        System.out.println(ans);

    }
}
