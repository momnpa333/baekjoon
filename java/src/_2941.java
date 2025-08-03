import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _2941 {
    static String s;
    static ArrayList<String> alphaSet;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        alphaSet=new ArrayList<>();
        alphaSet.add("c=");
        alphaSet.add("c-");
        alphaSet.add("dz=");
        alphaSet.add("d-");
        alphaSet.add("lj");
        alphaSet.add("nj");
        alphaSet.add("s=");
        alphaSet.add("z=");

        s=st.nextToken();
        String change="!";
//        System.out.println(s);
        for(String token:alphaSet){
            s=s.replace(token,change);
//            System.out.println(s);
        }

        System.out.println(s.length());

    }

}
