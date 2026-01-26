import java.io.*;
import java.util.*;

public class Main {
    static int[][][] possibles;
    static int[][] board;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; //= new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        board=new int[6][6];
        makePossibles();

        for(int t=0;t<3;t++){
            for(int r=0;r<6;r++){
                st=new StringTokenizer(br.readLine()," ");
                for(int c=0;c<6;c++){
                    board[r][c]=Integer.parseInt(st.nextToken());
                }
//                System.out.println(Arrays.toString(board[r]));
            }
            if (check()) {
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
        }

    }
    static boolean check(){
        for(int r=0;r<6;r++){
            for(int c=0;c<6;c++){
                for(int k=0;k<22;k++){
                    int[][] possible=possibles[k];
                    for(int d=0;d<4;d++){
                        if(isCorrect(possible,r,c)){
//                            System.out.println(k);
                            return true;
                        }
                        possible=rotate(possible);
                    }
                }
            }
        }
        return false;
    }
    static int[][] rotate(int[][] possible){
        int[][] ret=new int[possible[0].length][possible.length];
        for(int i=0;i<possible.length;i++){
            for(int j=0;j<possible[i].length;j++){
                ret[j][possible.length-i-1]=possible[i][j];
            }
        }
        return ret;
    }
    static boolean isCorrect(int[][] possible,int r,int c){
        int cnt=0;
//        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//        for(int i=0;i<5;i++){
//            System.out.println(Arrays.toString(possible[i]));
//        }
        for(int i=0;i<possible.length;i++){
            for(int j=0;j<possible[i].length;j++){
                if(r+i>=6||r+i<0||c+j>=6||c+j<0) continue;
                if(board[r+i][c+j]!=possible[i][j]){
                    return false;
                }
                if(board[r+i][c+j]==possible[i][j]&&board[r+i][c+j]==1){
                    cnt++;
                }
            }
        }
//        System.out.println(r+" "+c+" "+cnt);
        if(cnt==6) return true;
        return false;
    }

    static void makePossibles() {
        possibles = new int[22][3][5];

        possibles[0]  = new int[][]{
            {1,0,0,0},
            {1,1,1,1},
            {1,0,0,0}};
        possibles[1]  = new int[][]{
            {0,0,0,1},
            {1,1,1,1},
            {0,0,0,1}};
        possibles[2]  = new int[][]{
            {0,1,0,0},
            {1,1,1,1},
            {1,0,0,0}};
        possibles[3]  = new int[][]{
            {0,0,1,0},
            {1,1,1,1},
            {0,0,0,1}};
        possibles[4]  = new int[][]{
            {0,0,1,0},
            {1,1,1,1},
            {1,0,0,0}};
        possibles[5]  = new int[][]{
            {0,1,0,0},
            {1,1,1,1},
            {0,0,0,1}};
        possibles[6]  = new int[][]{
            {0,0,0,1},
            {1,1,1,1},
            {1,0,0,0}};
        possibles[7]  = new int[][]{
            {1,0,0,0},
            {1,1,1,1},
            {0,0,0,1}};
        possibles[8]  = new int[][]{
            {0,1,0,0},
            {1,1,1,1},
            {0,1,0,0}};
        possibles[9]  = new int[][]{
            {0,0,1,0},
            {1,1,1,1},
            {0,0,1,0}};
        possibles[10] = new int[][]{
            {0,0,1,0},
            {1,1,1,1},
            {0,1,0,0}};
        possibles[11] = new int[][]{
            {0,1,0,0},
            {1,1,1,1},
            {0,0,1,0}};
        possibles[12] = new int[][]{
            {0,0,1,1,1},
            {1,1,1,0,0}};
        possibles[13] = new int[][]{
            {1,1,1,0,0},
            {0,0,1,1,1}};
        possibles[14] = new int[][]{
            {0,0,1,1},
            {0,1,1,0},
            {1,1,0,0}};
        possibles[15] = new int[][]{
            {1,1,0,0},
            {0,1,1,0},
            {0,0,1,1}};
        possibles[16] = new int[][]{
            {0,0,1,1},
            {1,1,1,0},
            {1,0,0,0}};
        possibles[17] = new int[][]{
            {1,1,0,0},
            {0,1,1,1},
            {0,0,0,1}};
        possibles[18] = new int[][]{
            {0,1,0,0},
            {1,1,1,0},
            {0,0,1,1}};
        possibles[19] = new int[][]{
            {0,0,1,0},
            {0,1,1,1},
            {1,1,0,0}};
        possibles[20] = new int[][]{
            {0,0,1,1},
            {1,1,1,0},
            {0,0,1,0}};
        possibles[21] = new int[][]{
            {1,1,0,0},
            {0,1,1,1},
            {0,1,0,0}};
    }
}

