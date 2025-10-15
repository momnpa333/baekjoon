import java.io.*;
import java.util.*;

public class Main {
    static int N,K;
//    static ArrayDeque<Integer> dq;
    static String ans="";
    static char[] stack;
    static int top;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
//        dq=new ArrayDeque<>();
        stack=new char[N];

        String num=br.readLine();
        for(int i=0;i<num.length();i++){
            char cur=num.charAt(i);
            while(top>0 && K>0){
                char item=stack[top-1];
                top--;
                if(item>=cur){
                    top++;
                    break;
                }
                else{
                    K--;
                }
            }
            stack[top++]=cur;
        }
//        System.out.println(Arrays.toString(stack));
//        System.out.println(top);
        for(int i=0;i<top-K;i++){
            bw.write(stack[i]);
        }
        bw.flush();

    }

}
