import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _30459 {
    static int N,M,R;
    static int[] low;
    static int[] h;
    static double answer=-1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken()); M=Integer.parseInt(st.nextToken()); R=Integer.parseInt(st.nextToken());
        low=new int[N];
        h=new int[M];

        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            low[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++){
            h[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(h);
        solve();
        if(answer==-1){
            System.out.println(-1);
            return;
        }
        System.out.printf("%.1f",answer);

    }
    static void solve(){
        HashSet<Integer> lenSet=new HashSet<>();
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                int length=Math.abs(low[i]-low[j]);
                lenSet.add(length);
            }
        }
        for(int len:lenSet){
            biSearch(len,0,M-1,1);
        }
    }
    static void biSearch(int length,int l,int r,int cnt){
//        System.out.printf("%d %d %d %d\n",length,l,r,cnt);
        if(l>r){
            return;
        }
        int mid=(r+l)/2;
        double s=(double) length*h[mid]/2;
        if(s>R){
            biSearch(length,l,mid-1,cnt+1);
        }
        else{
            answer=Math.max(answer,s);
            biSearch(length,mid+1,r,cnt+1);
        }
    }
}
