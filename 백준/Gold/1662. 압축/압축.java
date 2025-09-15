import java.io.*;
import java.util.*;

public class Main {
    static String S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        S=st.nextToken();

        System.out.println(decode(S));
    }
    static int decode(String s){
        int ret=0;
        int openCnt=0;
        int idx=0;
        int start=0;
        int end;
//        System.out.println("!"+s);

        while(true){
            if(idx>=s.length()){
                break;
            }
            if(s.charAt(idx)=='('){
                if(openCnt==0){
                    start=idx;
                }
                openCnt++;
            }
            else if(s.charAt(idx)==')'){
                if(openCnt==1){
                    end=idx;
                    int result=decode(s.substring(start+1,end));
                    ret-=1;
                    ret+=(s.charAt(start-1)-'0')*result;
                }
                openCnt--;
            }
            else{
                if(openCnt==0)
                    ret+=1;
            }
            idx++;
        }
//        System.out.println(ret);
        return ret;
    }
}
