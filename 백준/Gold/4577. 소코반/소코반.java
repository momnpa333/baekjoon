import java.io.*;
import java.util.*;

public class Main {
    static int R,C;
    static int[][] matrix;
    static final int PLAYERCODE = 2;
    static final int BOXCODE = 4;
    static final int WALLCODE = 8;
    static final int EMPTYCODE =0;
    static final int TARGETCODE=1;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    static int cnt=1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; //= new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            st=new StringTokenizer(br.readLine()," ");
            R=Integer.parseInt(st.nextToken());
            C=Integer.parseInt(st.nextToken());
            String command;
            matrix=new int[R][C];

            if(R==0 && C==0 )break;
            int startR=-1; int startC=-1;
            for(int i=0;i<R;i++){
                String s=br.readLine();
                for(int j=0;j<C;j++){
                    if(s.charAt(j)=='.'){
                        matrix[i][j]=EMPTYCODE;
                    }
                    if(s.charAt(j)=='#'){
                        matrix[i][j]=WALLCODE;
                    }
                    if(s.charAt(j)=='+'){
                        matrix[i][j]=TARGETCODE;
                    }
                    if(s.charAt(j)=='w'){
                        matrix[i][j]=PLAYERCODE;
                        startR=i; startC=j;
                    }
                    if(s.charAt(j)=='W'){
                        matrix[i][j]=PLAYERCODE+TARGETCODE;
                        startR=i; startC=j;
                    }
                    if(s.charAt(j)=='b'){
                        matrix[i][j]=BOXCODE;
                    }
                    if(s.charAt(j)=='B'){
                        matrix[i][j]=BOXCODE+TARGETCODE;
                    }
                }
            }
            command=br.readLine();
            if(playGame(bw,command,startR,startC)){
                System.out.println("Game "+cnt+": complete");
            }
            else {
                System.out.println("Game "+cnt+": incomplete");
            }
            print(bw);
            cnt++;
        }
    }
    static void print(BufferedWriter bw) throws Exception {
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                if(matrix[r][c]==WALLCODE){
                    bw.write("#");
                }
                if(matrix[r][c]==EMPTYCODE){
                    bw.write(".");
                }
                if(matrix[r][c]==PLAYERCODE){
                    bw.write("w");
                }
                if(matrix[r][c]==PLAYERCODE+TARGETCODE){
                    bw.write("W");
                }
                if(matrix[r][c]==BOXCODE){
                    bw.write("b");
                }
                if(matrix[r][c]==BOXCODE+TARGETCODE){
                    bw.write("B");
                }
                if(matrix[r][c]==TARGETCODE){
                    bw.write("+");
                }
            }
            bw.write("\n");
        }
        bw.flush();
    }

    static boolean playGame(BufferedWriter bw,String command,int r,int c)  throws Exception{
        int[] pos= new int[]{r,c};
        for(int i=0;i<command.length();i++){
            int op=-1;
            if(command.charAt(i)=='U'){
                op=0;
            }
            else if(command.charAt(i)=='D'){
                op=1;
            }
            else if(command.charAt(i)=='L'){
                op=2;
            }
            else if(command.charAt(i)=='R'){
                op=3;
            }
            pos=move(op,pos[0],pos[1]);
            if(isDone()){
                return true;
            }
        }
        return false;
    }
    static int[] move(int op,int r,int c){
//        System.out.println(op+" "+r+" "+c);
        int nextR=r+dr[op];
        int nextC=c+dc[op];
        //캐릭터에게 지시한 방향이 빈 칸(박스나 벽이 아닌 곳)인 경우에는 그 칸으로 이동한다.
        if(isEmpty(nextR,nextC)){
            matrix[r][c]-=PLAYERCODE;
            matrix[nextR][nextC]+=PLAYERCODE;
            return new int[] {nextR,nextC};
        }
        //지시한 방향에 박스가 있는 경우에는, 박스를 민다. 이 경우에는 박스가 이동할 칸도 비어있어야 한다.
        else if((matrix[nextR][nextC]&BOXCODE)==4 && isEmpty(nextR+dr[op],nextC+dc[op])){
            matrix[r][c]-=PLAYERCODE;
            matrix[nextR][nextC]+=PLAYERCODE;
            matrix[nextR][nextC]-=BOXCODE;
            matrix[nextR+dr[op]][nextC+dc[op]]+=BOXCODE;
            return new int[] {nextR,nextC};
        }
        //지시한 방향이 벽인 경우, 또는 박스가 있는데, 박스가 이동할 칸에 다른 박스나 벽이 있는 경우에는 키를 눌러도 캐릭터는 이동하지 않는다.
        return new int[]{r,c};
    }
    static boolean isEmpty(int r,int c){
        return !(((matrix[r][c]&BOXCODE)==4) || matrix[r][c]==WALLCODE);
    }
    static boolean isDone(){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                boolean isTarget = (matrix[i][j] & TARGETCODE) != 0;
                boolean hasBox = (matrix[i][j] & BOXCODE) != 0;
                if(isTarget && !hasBox) return false;
            }
        }
        return true;
    }
}

