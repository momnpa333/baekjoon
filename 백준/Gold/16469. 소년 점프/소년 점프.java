import java.io.*;
import java.util.*;

public class Main {
    static int R,C;
    static int[][] board;
    static int[][][] enemy;
    static int[] dr = {0,1,0,-1};
    static int[] dc={1,0,-1,0};
    static int ans=Integer.MAX_VALUE;
    static int cnt=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());

        board=new int[R][C];
        enemy=new int[3][R][C];

        for(int i=0;i<R;i++){
            String s=br.readLine();
            for(int j=0;j<C;j++){
                board[i][j]=s.charAt(j)-'0';
            }
//            System.out.println(Arrays.toString(board[i]));
        }

        for(int i=0;i<3;i++){
            for(int r=0;r<R;r++){
                for(int c=0;c<C;c++){
                    enemy[i][r][c]=-1;
                }
            }
        }

        for (int i=0;i<3;i++){
//            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
            st=new StringTokenizer(br.readLine()," ");
            int r=Integer.parseInt(st.nextToken())-1;
            int c=Integer.parseInt(st.nextToken())-1;
            makeEnemy(i,r,c);
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(enemy[0][i][j]==-1 || enemy[1][i][j]==-1||enemy[2][i][j]==-1) continue;
                int num=Math.max(enemy[0][i][j],enemy[1][i][j]);
                num=Math.max(num,enemy[2][i][j]);
                if(num<ans){
                    ans=num;
                    cnt=1;
                    continue;
                }
                if(num==ans){
                    cnt++;
                }
            }
        }
        if(ans==Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(ans);
        System.out.println(cnt);
    }

    static void makeEnemy(int op,int r,int c){
        ArrayDeque<Item> dq=new ArrayDeque<>();
        dq.add(new Item(r,c));
        enemy[op][r][c]=0;
        int cnt=0;
        while(!dq.isEmpty()){
            int L=dq.size();
//            System.out.println(dq);
            for(int i=0;i<L;i++){
                Item item=dq.poll();
                for(int k=0;k<4;k++){
                    int nextR=item.r+dr[k];
                    int nextC=item.c+dc[k];
                    if(nextR>=0 && nextR<R && nextC>=0 && nextC<C && enemy[op][nextR][nextC]==-1 && board[nextR][nextC]==0){
                        enemy[op][nextR][nextC]=cnt+1;
                        dq.add(new Item(nextR,nextC));
                    }
                }
            }
            cnt++;
        }
//        for(int i=0;i<R;i++){
//            System.out.println(Arrays.toString(enemy[op][i]));
//        }
    }
    static class Item{
        int r,c;
        Item(int r,int c){
            this.r=r;
            this.c=c;
        }
        public String toString(){
            return r+" "+c;
        }
    }
}