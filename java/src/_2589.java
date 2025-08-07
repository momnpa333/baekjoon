import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _2589 {
    static int N,M;
    static char[][] board;
    static boolean[][] visited;
    static int[] dr={0,1,0,-1};
    static int[] dc={1,0,-1,0};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        board=new char[N][M];
        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<M;j++){
                board[i][j]=s.charAt(j);
            }
//            System.out.println(Arrays.toString(board[i]));
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j]=='L'){
//                    System.out.printf("%d %d\n",i,j);
                    answer=Math.max(bfs(i,j),answer);
//                    System.out.println(answer);
                }
            }
        }
        System.out.println(answer);

    }
    static int bfs(int r,int c){
        ArrayDeque<int[]> dq=new ArrayDeque<>();
        dq.add(new int[]{r,c});
        visited=new boolean[N][M];
        visited[r][c]=true;
        int cnt=0;

        while(!dq.isEmpty()){
            int L=dq.size();
            for(int i=0;i<L;i++){
                int[] item=dq.poll();
                for(int j=0;j<4;j++){
                    int curR=item[0]+dr[j]; int curC=item[1]+dc[j];
                    if(curR>=0 && curR<N && curC>=0 && curC<M && !visited[curR][curC] && board[curR][curC]=='L'){
                        visited[curR][curC]=true;
                        dq.add(new int[]{curR,curC});
                    }
                }
            }
            cnt++;
        }
        return cnt-1;
    }

}
