import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] buildings;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        buildings=new int[N];
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            buildings[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N;i++){
            int cnt=0;
            for(int j=0;j<N;j++){
                if(j<i){
                    if(isPossible(j,i)) {
                        cnt++;
                    }
                }
                if(i<j){
                    if(isPossible(i,j)) {
                        cnt++;
                    }
                }
            }
            answer=Math.max(answer,cnt);
        }
//        System.out.println(isPossible(0,1));
        System.out.println(answer);
    }

    static boolean isPossible(int start,int end){
        double a= (double) (buildings[end] - buildings[start]) /(end-start);
        double b= -1*a*start+buildings[start];
        for(int i=start+1;i<end;i++){
            if(start==end) continue;
            if(buildings[i]>=a*i+b){
//                System.out.printf("%d %d\n",start,end);
//                System.out.printf("%f %f\n",a,b);
//                System.out.printf("%d %f\n",buildings[i],a*i+b);
//                System.out.println(i);
                return false;
            }
        }
        return true;
    }


}
