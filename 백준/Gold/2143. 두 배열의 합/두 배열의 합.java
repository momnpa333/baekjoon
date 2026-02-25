import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int[] A;
    static int[] B;
    static int n;
    static long[] sumA;
    static long[] sumB;
    static Map<Long,Integer> candiMap=new HashMap<>();
    static long answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine()," ");
        A=new int[n]; sumA=new long[n+1];
        for(int i=0;i<n;i++){
            A[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        B=new int[n]; sumB=new long[n+1];
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++){
            B[i]=Integer.parseInt(st.nextToken());
        }
        sumA=makePrefix(A); sumB=makePrefix(B);
        for(int s=0;s<B.length;s++){
            for(int e=s;e<B.length;e++){
                long candi=getRangeSum(s,e,sumB);
                candiMap.put(candi,candiMap.getOrDefault(candi,0)+1);
            }
        }

        for(int s=0;s<A.length;s++){
            for(int e=s;e<A.length;e++){
                long target=T-getRangeSum(s,e,sumA);
                if(candiMap.getOrDefault(target,0)!=0){
                    answer+=candiMap.get(target);
                }
            }
        }
        System.out.println(answer);

    }
    static long[] makePrefix(int[] ary){
        long[] tmp=new long[ary.length+1];
        for(int i=0;i<ary.length;i++){
            tmp[i+1]=ary[i]+tmp[i];
        }
        return tmp;
    }
    static long getRangeSum(int start,int end,long[] ary){
        return ary[end+1]-ary[start];
    }
}
