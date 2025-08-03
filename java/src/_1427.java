import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1427 {
    static String s;
    static ArrayList<String> alphaSet;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        s=st.nextToken();
        char[] ch=s.toCharArray();
        Arrays.sort(ch);
        String answer="";
        for(int i=ch.length-1;i>=0;i--){
            answer+=ch[i];
        }
        System.out.println(answer);
    }

}
