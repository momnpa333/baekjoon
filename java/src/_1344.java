import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1344 {
    static int P1,P2;
    static int[] prime={2,3,5,7,11,13,17};
    static double canP1, canP2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        P1=Integer.parseInt(st.nextToken());
        P2=Integer.parseInt(br.readLine());

        for(int num:prime){
            canP1+=calc(num,P1);
            canP2+=calc(num,P2);
        }

        System.out.println(1-(1-canP1)*(1-canP2));

    }
    static double calc(int num,int P){
        int t=Math.min(num,18-num);
        long up=1; long down=1;

        for(int i=0;i<t;i++){
            up*=(18-i);
            down*=(i+1);
        }
        long combi=up/down;

        double tmp= (double) P /100;

        double p1=Math.pow(tmp,num);
        double p2=Math.pow(1-tmp,18-num);

        return (double)combi*p1*p2;
    }

}
