import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class _1436 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        ArrayList<Integer> candiAry=new ArrayList<>();
        for (int i=1;i<10000001;i++){
            if(check(i)){
                candiAry.add(i);
            }
        }
        Collections.sort(candiAry);
        System.out.println(candiAry.toArray()[N-1]);
    }

    private static boolean check(int num){
        String numSt=Integer.toString(num);

        if(numSt.contains("666")){
            return true;
        }
        return false;
    }

}
