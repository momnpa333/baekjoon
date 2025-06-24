import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class _9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String st=br.readLine();
        String bomb= br.readLine();

        ArrayDeque<Character> dq=new ArrayDeque<>();

        A:
        for(int i=0;i<st.length();i++){
            dq.add(st.charAt(i));
            if(dq.size()>=bomb.length()){
                char[] tmp=new char[bomb.length()];
                for(int j=bomb.length()-1;j>-1;j--){
                    tmp[j]=dq.pollLast();
                }
                for(int k=0;k<bomb.length();k++){
                    if(tmp[k]!=bomb.charAt(k)) {
                        for (int p = 0; p < bomb.length(); p++) {
                            dq.add(tmp[p]);
                        }
                        continue A;
                    }
                }
            }
        }
        if(dq.isEmpty()){
            bw.append("FRULA");
        }
        else{
            for(Character ch:dq){
                bw.append(ch);
            }
        }
        bw.flush();
    }
}
