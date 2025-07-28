import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _12871 {
    static String S;
    static String F;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        S=br.readLine();
        F=br.readLine();
        S=remake(S);
        F=remake(F);
//        System.out.println(S);
//        System.out.println(F);
//        System.out.println(S.length());
//        System.out.println(F.length());
        if(S.equals(F)){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
    static String remake(String st){
        while(st.length()<100){
            st+=st;
        }
        return st.substring(0,100);
    }
}
