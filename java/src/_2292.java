import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2292 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1,6,12,18
        int N=Integer.parseInt(br.readLine());
        List<Integer> dist = new ArrayList<>();
        int cur=1; int cnt=1;
        dist.add(0);
        while(true){
            dist.add(cur);
            cur+=6*cnt;
            cnt+=1;

            if(cur>1000000000){
                dist.add(cur);
                break;
            }
        }

        for(int i=0;i<dist.size();i++){
            if(N<=dist.get(i)){
                System.out.println(i);
                return;
            }
        }


    }
}
