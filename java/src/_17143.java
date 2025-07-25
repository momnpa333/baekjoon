import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _17143 {
    static int R,C,M;
    static Shark[][] board;
    static Set<Shark> sharkList;
    static int answer;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sharkList=new HashSet<>();
        R=Integer.parseInt(st.nextToken()); C=Integer.parseInt(st.nextToken()); M=Integer.parseInt(st.nextToken());
        board=new Shark[R+1][C+1];

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine()," ");
            int r, c, s, d, z;
            r=Integer.parseInt(st.nextToken()); c=Integer.parseInt(st.nextToken()); s=Integer.parseInt(st.nextToken());
            d=Integer.parseInt(st.nextToken())-1; z=Integer.parseInt(st.nextToken());

            Shark item=new Shark(r,c,s,d,z);
            board[r][c]=item;
            sharkList.add(item);
        }
        int pos=0;
        while(true){
            pos++;
            if(pos==C+1){
                break;
            }
            for(int j=0;j<R+1;j++){
                if(board[j][pos]!=null){
                    answer+=board[j][pos].z;
                    sharkList.remove(board[j][pos]);
                    board[j][pos]=null;
                    break;
                }
            }
            move();
        }
        System.out.println(answer);
    }
    static void move(){
        HashSet<Shark> removeSet=new HashSet<>();
        for(int i=0;i<=R;i++){
            Arrays.fill(board[i],null);
        }
        for(Shark item:sharkList){
            item.move();
            if(board[item.r][item.c]!=null){
                if(board[item.r][item.c].z<item.z){
//                    sharkList.remove(board[item.r][item.c]);
                    removeSet.add(board[item.r][item.c]);
                    board[item.r][item.c]=item;
                }
                else{
                    removeSet.add(item);
                }
            }
            else {
                board[item.r][item.c] = item;
            }
        }
        for(Shark rmv:removeSet){
            sharkList.remove(rmv);
        }


    }

    static class Shark{
        int r;
        int c;
        int s;
        int d;
        int z;
        Shark(int r,int c,int s,int d,int z){
            this.r=r;
            this.c=c;
            this.s=s;
            this.d=d;
            this.z=z;
        }
        public void move(){
            int tmp=s;
            while(true){
                r+=s*dr[d];
                c+=s*dc[d];

                if(r>R || r<1) {
                    if(r>R) {
                        s=Math.abs(r-R);
                        r=R;
                    }
                    if(r<1) {
                        s=Math.abs(r-1);
                        r=1;
                    }
                    d=(d+1)%2;
                    continue;
                }
                if(c>C || c<1) {
                    if(c>C){
                        s=Math.abs(c-C);
                        c=C;
                    }
                    if(c<1) {
                        s=Math.abs(c-1);
                        c=1;
                    }
                    d=(d+1)%2+2;
                    continue;
                }
                break;
            }
            // 4,1인데 10으로 오른쪽 4,6이 한계
            // 4,0
            s=tmp;
        }
        public String toString(){
            return this.r+" "+this.c+" "+this.d;
        }
    }

}
