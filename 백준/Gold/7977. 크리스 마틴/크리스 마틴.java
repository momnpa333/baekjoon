import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] cnt;
    static String num;
    static int n=Integer.MAX_VALUE;
    static int tar;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());

        cnt=new int[4];
        num=br.readLine();

        for(int i=0;i<num.length();i++){
            if(num.charAt(i)=='A') cnt[0]++;
            if(num.charAt(i)=='G') cnt[1]++;
            if(num.charAt(i)=='C') cnt[2]++;
            if(num.charAt(i)=='T') cnt[3]++;
        }

        for(int i=0;i<4;i++){
            if(cnt[i]<n){
                tar=i;
                n=cnt[i];
            }
        }
        String ans="";
        if(tar==0) ans="A";
        if(tar==1) ans="G";
        if(tar==2) ans="C";
        if(tar==3) ans="T";

        String answer="";
        for(int i=0;i<N;i++){
            answer+=ans;
        }
        System.out.println(n);
        System.out.println(answer);


    }
}