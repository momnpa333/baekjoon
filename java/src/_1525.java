import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _1525 {
    static int[][] board;
    static int[] dr={1,0,-1,0};
    static int[] dc={0,1,0,-1};
    static Set<Integer> check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        board=new int[3][3]; check=new HashSet<>();

        for(int i=0;i<3;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<3;j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
//        System.out.println("!");
        ArrayDeque<Cube> dq=new ArrayDeque<>();
        Cube f=new Cube(board);
        if(f.isAnswer()){
            System.out.print("0");
            return;
        }
        dq.add(f);
        check.add(f.getHash());
        int cnt=1;
        while(!dq.isEmpty()){
            int L=dq.size();
            for(int i=0;i<L;i++){
                Cube item=dq.pollLast();

                for(int j=0;j<4;j++){
                    Cube next=item.move(j);
                    if(next==null){
                        continue;
                    }
                    if(next.isAnswer()){
                        System.out.println(cnt);
                        return;
                    }
                    int hs=next.getHash();
                    if(!check.contains(hs)){
                        dq.addFirst(next);
                        check.add(hs);
                    }
                }
            }
            cnt++;
        }
        System.out.println(-1);


    }
    static class Cube{
        int[][] board=new int[3][3];
        int zeroR;
        int zeroC;
        Cube(int[][] first){
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++)
                {
                    if(first[i][j]==0){
                        zeroR=i;
                        zeroC=j;
                    }
                    board[i][j]=first[i][j];
                }
            }
        }
        public Cube move(int dir){
            int curR=dr[dir]+zeroR; int curC=dc[dir]+zeroC;
            int[][] origin=new int[3][3];
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    origin[i][j]=board[i][j];
                }
            }
            if(curR>=0 && curR<3 && curC>=0 && curC<3){
                int tmp=origin[curR][curC];
                origin[curR][curC]=0;
                origin[zeroR][zeroC]=tmp;
                return new Cube(origin);
            }
            else{
                return null;
            }
        }
        public boolean isAnswer(){
            int ans=1;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++)
                {
                    if(board[i][j]!=(ans%9)){
                        return false;
                    }
                    ans++;
                }
            }
            return true;
        }

        public int getHash(){
            int ret=0;
            int cnt=1;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++)
                {
                    ret+=board[i][j]*cnt;
                    cnt*=10;
                }
            }
            return ret;
        }

    }

}
