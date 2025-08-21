import java.io.*;
import java.util.*;

public class Main {
    static int N,M,L,K;
    static int[][] stars;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        stars=new int[K][2];

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine(), " ");
            stars[i][0]=Integer.parseInt(st.nextToken());
            stars[i][1]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<K;i++){
            for(int j=0;j<K;j++){
                answer=Math.max(countingStar(stars[i][0],stars[j][1]),answer);
                answer=Math.max(countingStar(stars[j][0],stars[i][1]),answer);
            }
        }
        System.out.println(K-answer);

    }

    static int countingStar(int x,int y){
        int ret=0;
        int cnt=0;
        for(int i=0;i<K;i++){
            if(stars[i][0]>=x && stars[i][0]<=x+L && stars[i][1]>=y && stars[i][1]<=y+L){
                cnt++;
            }
        }
        ret=Math.max(ret,cnt);
        return ret;
    }
}
