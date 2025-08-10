import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1507 {
    static int N;
    static int[][] graph;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        graph=new int[N][N];
        board=new int[N][N];

//        System.out.println(graph[0][0]);

//        N=Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
                board[i][j]=graph[i][j];
            }
        }
//        for(int i=0;i<N;i++){
//            Arrays.fill(board[i],Integer.MAX_VALUE);
//            board[i][i]=0;
//        }

        int answer=0;
        for(int via=0;via<N;via++){
            for(int s=0;s<N;s++){
                for(int e=0;e<N;e++){
                    if(via==s || via==e || s==e) continue;
                    if(graph[s][via]+graph[via][e]<graph[s][e]){
                        System.out.println(-1);
                        return;
                    }
                    if(graph[s][via]+graph[via][e]==graph[s][e]){
                        board[s][e]=Integer.MAX_VALUE;
                        board[e][s]=Integer.MAX_VALUE;
                    }
                }
            }
        }
//        for(int i=0;i<N;i++){
//            System.out.println(Arrays.toString(board[i]));
//        }

        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(board[i][j]!=Integer.MAX_VALUE)
                    answer+=board[i][j];
            }
        }
        System.out.println(answer);

    }

}
