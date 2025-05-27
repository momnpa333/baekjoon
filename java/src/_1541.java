import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class _1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] st=br.readLine().split("[-]");
        List<Integer> numAry=new ArrayList<>();

        for(String s1:st){
            int tmp=0;
            for(String s2:s1.split("[+]")){
                tmp+=Integer.parseInt(s2);
            }
            numAry.add(tmp);
        }
        int ans=numAry.get(0);

        for(int i=1;i<numAry.size();i++){
            ans-= numAry.get(i);
        }
        System.out.println(ans);
    }

}
