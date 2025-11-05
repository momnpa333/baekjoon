import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] dr={0,1,0,-1};
    static int[] dc={1,0,-1,0};
    static char[][] board;
    static boolean[][] visited;
    static boolean[][] isPossible;
    static Map<Character,Integer> KeyMap;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        KeyMap=new HashMap<>();
        KeyMap.put('R',0); KeyMap.put('D',1); KeyMap.put('L',2); KeyMap.put('U',3);

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        board=new char[N][M];
        visited=new boolean[N][M];
        isPossible=new boolean[N][M];


        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<M;j++){
                board[i][j]=s.charAt(j);
            }
//            System.out.println(Arrays.toString(board[i]));
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]){
                    dfs(i,j);
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(isPossible[i][j]){
                    ans++;
                }
            }
        }
        System.out.println(ans);

    }

    static boolean dfs(int r,int c){
        if(r>=N || r<0 || c>=M || c<0) return true;
        if(isPossible[r][c]) return true;
        if(visited[r][c] && !isPossible[r][c]) return false;

        visited[r][c]=true;
        int op=KeyMap.get(board[r][c]);

        isPossible[r][c]=dfs(r+dr[op],c+dc[op]);
        return isPossible[r][c];
    }

}
