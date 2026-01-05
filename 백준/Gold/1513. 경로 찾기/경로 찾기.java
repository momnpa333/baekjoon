import java.io.*;
import java.util.*;

public class Main {
    static int N,M,C;
    static int[][] city;
    static int[] ans;
    static int[][][][] score;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());

        score=new int[C+2][C+1][N][M]; //피방 몇개/현재 지나쳐온 가장 큰 번호/r/c
        city=new int[N][M];
        ans=new int[C+1];

        for(int i=1;i<=C;i++){
            st=new StringTokenizer(br.readLine()," ");
            int r=Integer.parseInt(st.nextToken())-1;
            int c=Integer.parseInt(st.nextToken())-1;
            city[r][c]=i;
        }
        if(city[0][0]!=0){
            score[1][city[0][0]][0][0]=1;
        }
        else{
            score[0][0][0][0]=1;
        }
        for(int c=1;c<M;c++){
            for(int p=0;p<=C;p++){
                for(int v=0;v<=C;v++){
                    if(city[0][c]==0){
                        score[p][v][0][c]=(score[p][v][0][c]+score[p][v][0][c-1])%1000007;
                    }
                    else{
                        if(v<city[0][c]){
                            score[p+1][city[0][c]][0][c]=(score[p+1][city[0][c]][0][c]+score[p][v][0][c-1])%1000007;
                        }
                    }
                }
            }
        }
        for(int r=1;r<N;r++){
            for(int p=0;p<=C;p++){
                for(int v=0;v<=C;v++){
                    if(city[r][0]==0){
                        score[p][v][r][0]=(score[p][v][r][0]+score[p][v][r-1][0])%1000007;
                    }
                    else{
                        if(v<city[r][0]){
                            score[p+1][city[r][0]][r][0]=(score[p+1][city[r][0]][r][0]+score[p][v][r-1][0])%1000007;
                        }
                    }
                }
            }
        }

        for(int r=1;r<N;r++){
            for(int c=1;c<M;c++){
                for(int p=0;p<=C;p++){
                    for(int v=0;v<=C;v++){
                        if(city[r][c]==0){
                            score[p][v][r][c]=(score[p][v][r][c]+score[p][v][r-1][c])%1000007;
                            score[p][v][r][c]=(score[p][v][r][c]+score[p][v][r][c-1])%1000007;
                        }
                        else{
                            if(v<city[r][c]){
                                score[p+1][city[r][c]][r][c]=(score[p+1][city[r][c]][r][c]+score[p][v][r-1][c])%1000007;
                                score[p+1][city[r][c]][r][c]=(score[p+1][city[r][c]][r][c]+score[p][v][r][c-1])%1000007;
                            }
                        }
                    }
                }
            }
        }
//        for(int i=0;i<=C;i++){
//            for(int j=0;j<=C;j++){
//                for(int k=0;k<N;k++){
//                    System.out.println(Arrays.toString(score[i][j][k]));
//                }
//            }
//        }

        for(int i=0;i<=C;i++){
            for(int j=0;j<=C;j++){
                ans[i]=(ans[i]+score[i][j][N-1][M-1])%1000007;
            }
        }


        for(int i=0;i<=C;i++){
            bw.write(ans[i]+" ");
        }
        bw.flush();

    }
}