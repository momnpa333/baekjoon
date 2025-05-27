import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _15829 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        String st=br.readLine();

        long ans=0;
        int cur=0;

        for(char c:st.toCharArray()){
            ans+=((long) (c - 'a' + 1) *pow(cur++));
        }

        System.out.println(ans%1234567891);
    }
    private static long pow(int n){
        long ret=1;
        for(int i=0;i<n;i++){
            ret=(ret*31)%1234567891;
        }
        return ret%1234567891;
    }

}
