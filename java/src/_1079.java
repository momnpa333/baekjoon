import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1079 {
    static int N;
    static int[] guilty;
    static int[][] R;
    static int number;
    static boolean[] isDead;
    static int liveNum;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine()," ");

        guilty=new int[N]; liveNum=N;
        R=new int[N][N]; isDead=new boolean[N];

        for(int i=0;i<N;i++){
            guilty[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                R[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        number=Integer.parseInt(br.readLine());
        dfs(0,0);

        System.out.println(answer);

    }
    static void dfs(int depth,int nightNum){
        if(liveNum%2==0){
            nightNum+=1;
            answer=Math.max(answer,nightNum);
        }
        if(liveNum==1){
            return;
        }
        if(liveNum%2==1){
            int tmp=eve();
            if(tmp==number){
                isDead[tmp]=false;
                liveNum++;
                return;
            }
            dfs(depth+1,nightNum);
            isDead[tmp]=false;
            liveNum++;
        }
        else{
            for(int i=0;i<N;i++){
                if(i!=number && !isDead[i]){
                    night(i);
                    dfs(depth+1,nightNum);
                    nightBack(i);
                }
            }
        }
    }

    static void night(int killNum){
        isDead[killNum]=true;

        for(int i=0;i<N;i++){
            guilty[i]+=R[killNum][i];
        }
        liveNum--;
    }
    static void nightBack(int killNum){
        isDead[killNum]=false;

        for(int i=0;i<N;i++){
            guilty[i]-=R[killNum][i];
        }
        liveNum++;
    }

    static int eve(){
        int tar=-1;
        int score=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            if(!isDead[i] && score<guilty[i]){
                tar=i;
                score=guilty[i];
            }
        }
        isDead[tar]=true;
        liveNum--;
        return tar;
    }

}
