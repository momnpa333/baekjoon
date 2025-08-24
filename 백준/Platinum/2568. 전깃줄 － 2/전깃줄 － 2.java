import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Rope[] ropes;
    static int[] lis;
    static int[] ropeIdx;
    static boolean[] used;
    static int answer;
    static ArrayDeque<Integer>dq=new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        ropes=new Rope[N];
        lis=new int[N];
        used=new boolean[N];
        Arrays.fill(lis,Integer.MAX_VALUE);
        ropeIdx=new int[N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            ropes[i]=new Rope(A,B);
        }
        Arrays.sort(ropes);

        for(int i=0;i<N;i++){
            putLis(i,ropes[i].B);
        }
        for(int i=0;i<N;i++){
            if(lis[i]!=Integer.MAX_VALUE){
                answer++;
            }
            else{
                break;
            }
        }
        int checked=answer-1;
        for(int i=N-1;i>=0;i--){
            if(!used[ropeIdx[i]] && ropeIdx[i]==checked){
                used[ropeIdx[i]]=true;
                checked--;
            }
            else{
                dq.add(ropes[i].A);
            }
        }
//        System.out.println(Arrays.toString(ropes));
//        System.out.println(Arrays.toString(ropeIdx));
        System.out.println(N-answer);
        while(!dq.isEmpty()){
            System.out.println(dq.pollLast());
        }
    }
    static void putLis(int A,int num){
        int idx=binarySearch(0,N-1,num);
        lis[idx]=num;
        ropeIdx[A]=idx;
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
    static class Rope implements Comparable<Rope>{
        int A;
        int B;
        Rope(int A,int B){
            this.A=A;
            this.B=B;
        }
        public int compareTo(Rope o){
            return this.A-o.A;
        }
        public String toString(){
            return A+" "+B;
        }
    }
}
