import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class _4811 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            int n=Integer.parseInt(br.readLine());
            if(n==0){
                break;
            }
            System.out.println(solve(n));
        }

    }
    static BigInteger solve(int n){
        BigInteger up= BigInteger.valueOf(1);
        BigInteger down = BigInteger.valueOf(1);

        for(int i=2*n;i>n+1;i--){
            up= up.multiply(BigInteger.valueOf(i));
        }
        for(int i=1;i<=n;i++){
            down= down.multiply(BigInteger.valueOf(i));
        }
        return up.divide(down);
    }

}
