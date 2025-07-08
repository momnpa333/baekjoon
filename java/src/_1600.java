import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _1600 {
    static int K;
    static int W,H;
    static int[][] board;
    static boolean[][][] visited;
    static int[] dirR = {-1,1,0,0};
    static int[] dirC = {0,0,-1,1};
    static int[] dirRH = {-2,-1,1,2,2,1,-1,-2};
    static int[] dirCH = {1,2,2,1,-1,-2,-2,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine()," ");
        W=Integer.parseInt(st.nextToken()); H=Integer.parseInt(st.nextToken());
        board=new int[H][W];
        visited=new boolean[H][W][K+1];

        for(int i=0;i<H;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<W;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        ArrayDeque<int[]> dq=new ArrayDeque<>();
        dq.add(new int[]{0,0,0,0});
        visited[0][0][0]=true;
        int depth=0;
        while(!dq.isEmpty()){
            int L=dq.size();
            for(int i=0;i<L;i++){
                int[] item=dq.pollLast();
                if(item[0]==H-1 && item[1]==W-1){
                    System.out.println(depth);
                    return;
                }
                for(int k=0;k<4;k++){
                    int nr=item[0]+dirR[k], nc=item[1]+dirC[k];
                    if(0<=nr && nr<H && 0<=nc && nc<W && !visited[nr][nc][item[2]] && board[nr][nc]!=1){
                        visited[nr][nc][item[2]]=true;
                        dq.addFirst(new int[]{nr,nc,item[2]});
                    }
                }
                if (item[2] < K) {
                    for(int k=0;k<8;k++){
                        int nr=item[0]+dirRH[k], nc=item[1]+dirCH[k];
                        if(0<=nr && nr<H && 0<=nc && nc<W && !visited[nr][nc][item[2]+1] && board[nr][nc]!=1){
                            visited[nr][nc][item[2]+1]=true;
                            dq.addFirst(new int[]{nr,nc,item[2]+1});
                        }
                    }
                }
            }

            depth++;
        }

        System.out.printf("-1");

    }

}
