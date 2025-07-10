import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _17825 {
    static int[] dices;
    static int N=10;
    static int[] board;
    static int[] pos;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st=new StringTokenizer(br.readLine()," ");
        dices=new int[N];

        for(int i=0;i<N;i++){
            dices[i]=Integer.parseInt(st.nextToken());
        }

        board=new int[34];
        pos=new int[4];

        for(int i=0;i<=20;i++){
            board[i]=i*2;
        }
        board[21]=13; board[22]=16; board[23]=19;
        board[24]=22; board[25]=24;
        board[26]=28; board[27]=27; board[28]=26;
        board[29]=25; board[30]=30; board[31]=35;

        dfs(0,0);
        System.out.println(answer);

    }
    static void dfs(int depth,int score){
        answer=Math.max(answer,score);
        if(depth==10){
            return;
        }

        A:
        for(int i=0;i<4;i++){
            if(pos[i]==32){
                continue;
            }
            int prev=pos[i];
            pos[i]=move(prev,dices[depth]);
            for(int j=0;j<4;j++){
                if(i!=j && pos[i]==pos[j] && pos[i]!=32){
                    pos[i]=prev;
                    continue A;
                }
            }
            dfs(depth+1,score+board[pos[i]]);
            pos[i]=prev;
        }

    }

    static int move(int cur,int add){
        if(cur%5==0 || cur>20){
            for(int i=0;i<add;i++){
                if(cur==5){
                    cur=21;
                    continue;
                }
                if(cur==10){
                    cur=24;
                    continue;
                }
                if(cur==15){
                    cur=26;
                    continue;
                }
                if(cur==23 || cur==25 || cur==28){
                    cur=29;
                    continue;
                }
                if(cur==31){
                    cur=20;
                    continue;
                }
                if(cur==20){
                    cur=32;
                    break;
                }
                cur+=1;
            }
        }
        else{
            for(int i=0;i<add;i++){
                if(cur==20){
                    cur=32;
                    break;
                }
                cur+=1;
            }
        }

        return cur;
    }

}
