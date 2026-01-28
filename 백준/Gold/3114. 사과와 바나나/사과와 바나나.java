import java.io.*;
import java.util.*;

public class Main {
    static int R,C;
    static int[][] apple;
    static int[][] appleSum;
    static int[][] banana;
    static int[][] bananaSum;
    static int[] dr={1,1,0};
    static int[] dc={0,1,1};
    static int total;
    static int[][] fruit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        apple=new int[R+1][C+1];
        appleSum=new int[R+2][C+1];
        banana=new int[R+1][C+1];
        bananaSum=new int[R+3][C+1];
        fruit =new int[R+1][C+1];

        for(int i=1;i<=R;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=C;j++){
                String s=st.nextToken();
                if(s.charAt(0)=='A'){
                    apple[i][j]=Integer.parseInt(s.substring(1));
                    total+=apple[i][j];
                }
                if(s.charAt(0)=='B'){
                    banana[i][j]=Integer.parseInt(s.substring(1));
                    total+=banana[i][j];
                }
            }
        }

        for(int c=1;c<=C;c++){
            for(int r=1;r<=R;r++){
                appleSum[r][c]=appleSum[r-1][c]+apple[r][c];
            }
        }

        for(int c=1;c<=C;c++){
            for(int r=R;r>=1;r--){
                bananaSum[r][c]=bananaSum[r+1][c]+banana[r][c];
            }
        }

        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                if (r == 1 && c == 1) {
                    fruit[r][c] = findFruit(1,1);
                    continue;
                }
                int best = -1;
                if (r - 1 >= 1) {
                    best = Math.max(best, fruit[r-1][c] - apple[r][c]);
                }
                if (c - 1 >= 1) {
                    best = Math.max(best, fruit[r][c-1] + findFruit(r, c));
                }
                if (r - 1 >= 1 && c - 1 >= 1) {
                    best = Math.max(best, fruit[r-1][c-1] + findFruit(r, c));
                }
                fruit[r][c] = best;
            }
        }
        System.out.println(fruit[R][C]);


    }
    static int findFruit(int r,int c){
        int ret=0;
        ret+=appleSum[R][c]-appleSum[r][c];
        ret+=bananaSum[1][c]-bananaSum[r][c];
        return ret;
    }
}

