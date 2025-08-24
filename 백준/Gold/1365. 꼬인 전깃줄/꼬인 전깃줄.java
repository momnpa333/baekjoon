import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] ropes;
    static int[] lis;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        ropes=new int[N];
        lis=new int[N];
        Arrays.fill(lis,Integer.MAX_VALUE);
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            ropes[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N;i++){
            putLis(ropes[i]);
        }
        for(int i=0;i<N;i++){
            if(lis[i]!=Integer.MAX_VALUE){
                answer++;
            }
        }
        System.out.println(N-answer);
    }
    static void putLis(int num){
        int idx=binarySearch(0,N-1,num);
//        System.out.println(idx);
        lis[idx]=num;
//        System.out.println(Arrays.toString(lis));
    }
    static int binarySearch(int left,int right,int tar){
//        System.out.printf("%d %d\n",left,right);
        if(left>=right){
            return left;
        }
        int mid=(left+right)/2;
        if(tar<=lis[mid]){
            return binarySearch(left,mid,tar);
        }
        if(tar>lis[mid]){
            return binarySearch(mid+1,right,tar);
        }
        return -1;
    }
}
