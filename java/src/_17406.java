import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17406 {
    static int N;
    static int M;
    static int K;
    static int[][] A;
    static int[][] op;
    static int answer=Integer.MAX_VALUE;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        A=new int[N][M];
        op=new int[K][3];
        visited=new boolean[K];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                A[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<K;i++){
            st=new StringTokenizer(br.readLine()," ");

            op[i][0]=Integer.parseInt(st.nextToken())-1;
            op[i][1]=Integer.parseInt(st.nextToken())-1;
            op[i][2]=Integer.parseInt(st.nextToken());
        }
        dfs(0);

        System.out.println(answer);


    }
    static void dfs(int depth){
        if(depth==K){
            answer=Math.min(answer,getMin());
            return;
        }

        int[][] tmp=new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                tmp[i][j]=A[i][j];
            }
        }
        for(int i=0;i<K;i++){
            if(!visited[i]){
                visited[i]=true;
                calc(op[i][0],op[i][1],op[i][2]);
                dfs(depth+1);
                for(int j=0;j<N;j++){
                    for(int k=0;k<M;k++){
                        A[j][k]=tmp[j][k];
                    }
                }
                visited[i]=false;
            }
        }
    }

    static void calc(int r,int c,int s){
        for(int i=1;i<=s;i++){
            move(r-i,c-i,r+i,c+i);
        }
    }
    static void move(int r1,int c1,int r2,int c2){
        int tmp=A[r1][c2];
        for(int c=c2;c>c1;c--){
            A[r1][c]=A[r1][c-1];
        }
        int tmp2=A[r2][c2];
        for(int r=r2;r>r1;r--){
            A[r][c2]=A[r-1][c2];
        }
        A[r1+1][c2]=tmp;
        int tmp3=A[r2][c1];
        for(int c=c1;c<c2;c++){
            A[r2][c]=A[r2][c+1];
        }
        A[r2][c2-1]=tmp2;
        for(int r=r1;r<r2;r++){
            A[r][c1]=A[r+1][c1];
        }
        A[r2-1][c1]=tmp3;

    }

    static int getMin(){
        int ret=Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            int sum=0;
            for(int j=0;j<M;j++){
                sum+=A[i][j];
            }
            ret=Math.min(ret,sum);
        }
        return ret;
    }

}
