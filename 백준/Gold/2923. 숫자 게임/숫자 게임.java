import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] cntA;
    static int[] cntB;
    static final int INF=987654321;
    static int answer=INF;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(st.nextToken());
        cntA = new int[102];
        cntB = new int[101];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cntA[a]++;
            cntB[b]++;
            answer=getAnswer();
            System.out.println(answer);
        }
    }
    static int getAnswer(){
        int curA=1; int curB=100;
        int ret=0;
        int remainA=cntA[curA]; int remainB=cntB[curB];
        while(true){
//            System.out.println(curA+" "+curB);
//            System.out.println(remainA+" "+remainB);
            if(remainA==0){
                while(curA<=100){
                    curA++;
                    if(cntA[curA]!=0) break;
                }
                remainA=cntA[curA];
            }
            if(remainB==0){
                while(curB>=1){
                    curB--;
                    if(cntB[curB]!=0) break;
                }
                remainB=cntB[curB];
            }
            if(curA>100 || curB<1) break;
//            System.out.println(curA+" "+curB);
            ret=Math.max(curA+curB,ret);
            int used=Math.min(remainA,remainB);
            remainA-=used;
            remainB-=used;
        }
        return ret;
    }
}

