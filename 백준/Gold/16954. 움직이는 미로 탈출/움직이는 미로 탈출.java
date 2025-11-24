import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;
    static boolean[][][] visited;
    static int[] dr={-1,-1,-1,0,0,1,1,1,0};
    static int[] dc={-1,0,1,-1,1,-1,0,1,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        board=new char[8][8];
        visited=new boolean[9][8][8];
        for(int i=0;i<8;i++){
            String s=br.readLine();
            for(int j=0;j<8;j++){
                board[i][j]=s.charAt(j);
            }
        }
        ArrayDeque<Item> dq=new ArrayDeque<>();
        dq.add(new Item(0,7,0));
        int t=0;
//        downWall();

        while(!dq.isEmpty()){
            int L=dq.size();
//            System.out.println(dq);
            for(int i=0;i<L;i++){
                Item item=dq.poll();
                if(board[item.r][item.c]=='#') continue;
                if(item.time<8){
                    for(int d=0;d<9;d++){
                        int nextR=item.r+dr[d];
                        int nextC=item.c+dc[d];
                        if(nextR==0 && nextC ==7){
                            System.out.println(1);
                            return;
                        }
                        if(nextR>=0 && nextR<8 && nextC>=0 && nextC<8 && board[nextR][nextC]=='.' && !visited[item.time][nextR][nextC]){
//                            System.out.printf("nR: %d nC: %d value: %c\n",nextR,nextC,board[nextR][nextC]);
                            visited[item.time][nextR][nextC]=true;
                            dq.add(new Item(item.time+1,nextR,nextC));
                        }
                    }
                }
                else {
                    for(int d=0;d<8;d++){
                        int nextR=item.r+dr[d];
                        int nextC=item.c+dc[d];
                        if(nextR==0 && nextC ==7){
                            System.out.println(1);
                            return;
                        }
                        if(nextR>=0 && nextR<8 && nextC>=0 && nextC<8 && board[nextR][nextC]=='.' && !visited[8][nextR][nextC]){
                            visited[8][nextR][nextC]=true;
                            dq.add(new Item(item.time+1,nextR,nextC));
                        }
                    }
                }
            }
            if(t<8)
                downWall();
            t++;
        }
        System.out.println(0);
    }
    static void downWall(){
        for(int r=6;r>=0;r--){
            for(int c=0;c<8;c++){
                board[r+1][c]=board[r][c];
            }
        }
        for(int c=0;c<8;c++){
            board[0][c]='.';
        }
//        for(int r=0;r<8;r++){
//            System.out.println(Arrays.toString(board[r]));
//        }
    }
    static class Item{
        int time;
        int r;
        int c;
        Item(int time,int r,int c){
            this.r=r;
            this.c=c;
            this.time=time;
        }
        public String toString(){
            return time+" "+r+" "+c;
        }
    }
}