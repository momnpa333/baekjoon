import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2468 {

    static int N,answer;
    static int[][] board;
    static int[] addR={0,1,0,-1};
    static int[] addC={1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        board=new int[N][N];

        for(int r=0;r<N;r++){
            st=new StringTokenizer(br.readLine()," ");
            for(int c=0;c<N;c++){
                board[r][c]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<=100;i++){
            answer=Math.max(answer,flood(i));
        }

        System.out.println(answer);
    }

    static int flood(int h){
        boolean[][] visited=new boolean[N][N];
        int ret=0;
        for(int i=0;i<N;i++){
            Arrays.fill(visited[i],false);
        }

        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                if(board[r][c]>h && !visited[r][c]){
                    visited[r][c]=true;
//                    System.out.printf("%d %d\n",r,c);
                    bfs(r,c,h,visited);
                    ret+=1;
                }
            }
        }

        return ret;
    }

    static void bfs(int r,int c,int h,boolean[][] visited){
        ArrayDeque<int[]> dq=new ArrayDeque<>();

        dq.add(new int[]{r,c});

        while(!dq.isEmpty()){
            int L=dq.size();
            for(int i=0;i<L;i++){
                int[] item=dq.pollFirst();
                for(int j=0;j<4;j++){
                    int curR=item[0]+addR[j]; int curC=item[1]+addC[j];
                    if(0<=curR && curR<N && 0<=curC && curC<N && !visited[curR][curC] && board[curR][curC]>h){
                        visited[curR][curC]=true;
                        dq.add(new int[]{curR,curC});
                    }
                }
            }
        }
    }



}
