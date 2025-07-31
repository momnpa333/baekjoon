import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _17829 {
    static int N;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        board=new int[N][N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }



        System.out.println(findValue(0,0,N));

    }
    static int findValue(int r,int c,int size){
//        System.out.println(size);
        int ret;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        if(size==2){
            for(int i=r;i<r+2;i++){
                for(int j=c;j<c+2;j++){
                    pq.add(board[i][j]);
                }
            }
//            System.out.println(pq);
            pq.poll();
            ret=pq.poll();
//            System.out.println(ret);
            return ret;
        }
        int midR=r+size/2;
        int midC=c+size/2;
        pq.add(findValue(r,c,size/2));
        pq.add(findValue(midR,c,size/2));
        pq.add(findValue(r,midC,size/2));
        pq.add(findValue(midR,midC,size/2));
        pq.poll();
        ret=pq.poll();
//        System.out.println(ret);
        return ret;
    }

}
