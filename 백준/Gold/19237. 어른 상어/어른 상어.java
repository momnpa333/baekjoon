import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int K;
    static Smell[][] board;
    static Shark[] sharks;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};
    static int T;
    static Map<Integer,Integer> inputDic;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        board=new Smell[N][N];
        sharks=new Shark[M+1];
        for(int i=0;i<=M;i++){
            sharks[i]=new Shark();
        }
        inputDic=new HashMap<>();
        inputDic.put(1,0);
        inputDic.put(2,2);
        inputDic.put(3,1);
        inputDic.put(4,3);

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                int id=Integer.parseInt(st.nextToken());
                if(id!=0){
                    board[i][j]=new Smell(id,K);
                    sharks[id].r=i;
                    sharks[id].c=j;
                }
                else{
                    board[i][j]=new Smell(id,0);
                }
            }
        }

        st=new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=M;i++){
            sharks[i].curDir= inputDic.get(Integer.parseInt(st.nextToken()));
        }

        for(int i=1;i<=M;i++){
            for(int j=1;j<=4;j++){
                st=new StringTokenizer(br.readLine()," ");
                for(int t=0;t<4;t++){
                    sharks[i].dirs[inputDic.get(j)][t]= inputDic.get(Integer.parseInt(st.nextToken()));
                }
            }
        }
//        for(int i=0;i<N;i++){
//            System.out.println(Arrays.toString(board[i]));
//        }
        while (true){
            move();
            T+=1;
            removeTime();
            makeSmell();
            if(isDone()){
                break;
            }
            if(T>=1000){
                System.out.println(-1);
                return;
            }

//            System.out.println(T);
//            for(int i=0;i<N;i++){
//                System.out.println(Arrays.toString(board[i]));
//            }
//            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        }
        System.out.println(T);



    }
    static void removeTime(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                board[i][j].restTime-=1;
            }
        }
    }
    static void move(){
        A:
        for(int i=1;i<=M;i++){
            if(!sharks[i].isDead){
                for(int j=0;j<4;j++){
                    int d=sharks[i].dirs[sharks[i].curDir][j];
                    int curR=dr[d]+sharks[i].r;
                    int curC=dc[d]+sharks[i].c;
                    if(curR>=0 && curR<N && curC>=0 && curC<N && board[curR][curC].restTime<=0){
                        sharks[i].r=curR;
                        sharks[i].c=curC;
                        sharks[i].curDir=d;
                        continue A;
                    }
                }
                //4방향 다 냄새가 있을 때
                for(int j=0;j<4;j++){
                    int d=sharks[i].dirs[sharks[i].curDir][j];
                    int curR=dr[d]+sharks[i].r;
                    int curC=dc[d]+sharks[i].c;
                    if(curR>=0 && curR<N && curC>=0 && curC<N && board[curR][curC].id==i){
                        sharks[i].r=curR;
                        sharks[i].c=curC;
                        sharks[i].curDir=d;
                        continue A;
                    }
                }
            }
        }
    }
    static void makeSmell(){
        for(int i=1;i<=M;i++){
            if(!sharks[i].isDead){
                if(board[sharks[i].r][sharks[i].c].restTime>0 && board[sharks[i].r][sharks[i].c].id!=i){
                    sharks[i].isDead=true;
                }
                else{
                    board[sharks[i].r][sharks[i].c].restTime=K;
                    board[sharks[i].r][sharks[i].c].id=i;
                }
            }
        }
    }
    static boolean isDone(){
        for(int i=2;i<=M;i++){
            if(!sharks[i].isDead) return false;
        }
        return true;
    }

    static class Shark{
        int[][] dirs=new int[4][4];
        int curDir;
        int r;
        int c;
        boolean isDead=false;
        Shark(){
        }
    }

    static class Smell{
        int id;
        int restTime;
        Smell(int id,int restTime){
            this.id=id;
            this.restTime=restTime;
        }
        public String toString(){
            return id+" "+restTime+" "+sharks[id].curDir;
        }
    }

}
