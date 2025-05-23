import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]); int M=Integer.parseInt(s[1]);

        int[] numAry = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int answer=0;
        for(int i=0;i<numAry.length;i++) {
            for (int j = i + 1; j < numAry.length; j++){
                if(numAry[i] + numAry[j]>M){
                    break;
                }
                for (int k = j + 1; k < numAry.length; k++) {
                    int candi=numAry[i] + numAry[j] + numAry[k];
                    if (candi == M) {
                        bw.write(Integer.toString(candi));
                        bw.flush();
                        bw.close();
                        return;
                    }
                    if (candi < M && candi>answer){
                        answer = candi;
                    }
                    if (candi>M){
                        break;
                    }
                }
            }
        }
//        System.out.println(answer);
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();

    }
}
