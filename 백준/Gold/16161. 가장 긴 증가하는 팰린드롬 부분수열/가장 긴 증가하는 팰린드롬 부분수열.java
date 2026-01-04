import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] seq;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        seq=new int[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            seq[i]=Integer.parseInt(st.nextToken());
        }
        if (N == 1) {
            System.out.println(1);
            return;
        }

        for(int i=0;i<N-1;i++){
            ans=Math.max(solve(i),ans);
        }
        System.out.println(ans);
    }
    static int solve(int id){
        int ret=0;
        if(seq[id]!=seq[id+1]){
            int gap=1;
            int prev=seq[id];
            while(true){
                if(id-gap>=0 && id+gap<N && seq[id-gap]==seq[id+gap] && prev>seq[id-gap]){
                    prev=seq[id-gap];
                    gap++;
                }
                else break;
            }
            ret=(gap-1)*2+1;
        }
        else{
            int left=id;
            int right=id+1;
            int prev=seq[left];
            while(true){
                if(left-1>=0 && right+1<N && seq[left-1]==seq[right+1] && prev>seq[left-1]){
                    left--; right++;
                    prev=seq[left];
                }
                else break;
            }
            ret=right-left+1;
        }
//        System.out.println(ret);
        return ret;
    }
}