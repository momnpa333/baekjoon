import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class _1941 {
    static char[][] board;
    static int[] dirr={0,1,0,-1};
    static int[] dirc={1,0,-1,0};
    static int answer;
    static List<int[]> group = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        board=new char[5][5];

        for(int i=0;i<5;i++){
            char[] row=br.readLine().toCharArray();
            for(int j=0;j<5;j++){
                board[i][j]=row[j];
            }
        }

//        for(char[]v:board){
//            System.out.println(Arrays.toString(v));
//        }

        dfs(0,0);

        System.out.println(answer);
    }

    static void dfs(int depth,int start){
        if (depth == 7) {
            if (solve()) {
                answer++;
            }
            return;
        }

        for (int i=start;i<25;i++) {
            int r=i/5;
            int c=i%5;
            group.add(new int[]{r, c});
            dfs(depth + 1, i + 1);
            group.remove(group.size()-1);
        }

    }
    static boolean solve(){
        int SCnt=0;
        int score=0;
        boolean[][] selected = new boolean[5][5];
        boolean[][] visited = new boolean[5][5];

        for(int[] pos:group){
            selected[pos[0]][pos[1]] = true;
            if(board[pos[0]][pos[1]]=='S'){
                SCnt++;
            }
        }
        if(SCnt<4){
            return false;
        }

        ArrayDeque<int[]> dq=new ArrayDeque<>();

        dq.add(group.get(0));
        visited[group.get(0)[0]][group.get(0)[1]]=true;
        score++;

        while(!dq.isEmpty()){
            int L=dq.size();
            for(int i=0;i<L;i++){
                int[] item=dq.pollLast();
                for(int j=0;j<4;j++){
                    int dr=item[0]+dirr[j]; int dc=item[1]+dirc[j];
                    if(0<=dr && dr<5 && 0<=dc && dc<5 && selected[dr][dc] && !visited[dr][dc]){
                        score++;
                        dq.add(new int[]{dr,dc});
                        visited[dr][dc]=true;
                    }
                }
            }

        }
        return score==7;


    }


}
