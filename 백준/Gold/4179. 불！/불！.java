import java.io.*;
import java.util.*;

public class Main {
    static int R,C;
    static char[][] maze;
    static ArrayDeque <Item> dq=new ArrayDeque<>();
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());

        maze=new char[R][C];
        visited=new boolean[R][C];

        for(int i=0;i<R;i++){
            String s=br.readLine();
            for(int j=0;j<C;j++) {
                maze[i][j] = s.charAt(j);
                if (maze[i][j] == 'J') {
                    dq.add(new Item(i, j,'J'));
                }
            }
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++) {
                if (maze[i][j] == 'F') {
                    dq.add(new Item(i, j,'F'));
                }
            }
        }

        int ans=0;
        while(!dq.isEmpty()){
            int L=dq.size();
//            System.out.println(dq);
            for(int l=0;l<L;l++){
                Item cur=dq.poll();
//                System.out.println(cur.op);
//                System.out.println(cur.op=='J');
                if(cur.op=='J')
                {
                    if((cur.r==0 || cur.c==0 || cur.r==R-1 || cur.c==C-1) && maze[cur.r][cur.c]!='F'){
                        System.out.println(ans+1);
                        return;
                    }
                    for(int d=0;d<4;d++){
                        int nr=cur.r+dr[d];
                        int nc=cur.c+dc[d];
                        if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
                        if(maze[nr][nc]!='.' || visited[nr][nc]) continue;
                        dq.add(new Item(nr,nc,cur.op));
                        visited[nr][nc]=true;
                    }

                }
                else if(cur.op=='F'){
                    for(int d=0;d<4;d++){
                        int nr=cur.r+dr[d];
                        int nc=cur.c+dc[d];
                        if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
                        if(maze[nr][nc]=='#' || maze[nr][nc]=='F') continue;
                        maze[nr][nc]='F';
                        dq.add(new Item(nr,nc,cur.op));
                    }
                }
            }
            ans++;
        }
        System.out.println("IMPOSSIBLE");
    }

    static class Item{
        int r;
        int c;
        char op;
        public Item(int r,int c,char op){
            this.r=r;
            this.c=c;
            this.op=op;
        }
        public String toString(){
            return "r:"+r+" c:"+c+" op:"+op;
        }
    }


}

