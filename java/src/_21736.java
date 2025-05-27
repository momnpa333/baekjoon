import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _21736 {
    static int[] addr={0,1,0,-1};
    static int[] addc={1,0,-1,0};
    static int N;
    static int M;
    static boolean [][] check;
    static char [][] board;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N=Integer.parseInt(st.nextToken()); M=Integer.parseInt(st.nextToken());
        int startR=0; int startC=0;

        board=new char[N][M]; check=new boolean[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            char[] row=st.nextToken().toCharArray();
            for(int j=0;j<M;j++){
                board[i][j]=row[j];
                if(row[j]=='I') {
                    startR=i;
                    startC=j;
                }
            }
        }

        ArrayDeque<int[]> dq=new ArrayDeque<>();
        dq.add(new int[]{startR,startC});
        check[startR][startC]=true;

        while(!dq.isEmpty()){

            int L=dq.size();
            for(int i=0;i<L;i++){
                int[] item =dq.pollFirst();
                int r=item[0]; int c=item[1];

                for(int j=0;j<4;j++){
                    int curr=r+addr[j]; int curc=c+addc[j];
                    if(0<=curr && curr<N && 0<=curc && curc<M && board[curr][curc]!='X' && !check[curr][curc]){
                        check[curr][curc]=true;
                        if(board[curr][curc]=='P'){
                            answer+=1;
                        }
                        dq.add(new int[]{curr,curc});
                    }
                }

            }
        }

        if (answer > 0)
            System.out.println(answer);
        else {
            System.out.println("TT");
        }

    }

}
