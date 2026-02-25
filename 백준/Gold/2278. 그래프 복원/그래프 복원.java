import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] mat;
    static int[][] minMat;
    static int INF=987654321;
    static int[][] hist;
    static boolean[][] need;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        mat=new int[N][N];
        minMat=new int[N][N];
        hist=new int[N][N];
        need=new boolean[N][N];
        for(int i=0;i<N;i++){
            Arrays.fill(minMat[i],INF);
            Arrays.fill(hist[i],INF);
        }
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=i+1;j<N;j++){
                int v=Integer.parseInt(st.nextToken());
                if(i==j) minMat[i][j]=0;
                if(i==j) mat[i][j]=0;
                mat[i][j]=v;
                mat[j][i]=v;
                minMat[i][j]=v;
                minMat[j][i]=v;
            }
        }

        floyd();

//        for(int i=0;i<N;i++){
//            System.out.println(Arrays.toString(hist[i]));
//        }

        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(mat[i][j]!=minMat[i][j]){
                    System.out.println(0);
                    return;
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                markPath(i,j);
            }
        }
//        for(int i=0;i<N;i++){
//            System.out.println(Arrays.toString(need[i]));
//        }
        int needNum=0;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(need[i][j]) needNum++;
            }
        }
        if(M<needNum){
            System.out.println(0);
            return;
        }
        System.out.println(1);

        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if (need[i][j]) {
                    System.out.println((i+1)+" "+(j+1)+" "+minMat[i][j]);
                    M--;
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if (need[i][j]) {
                    while(M>0){
                        System.out.println((i+1)+" "+(j+1)+" "+500);
                        M--;
                    }
                }
            }
        }

    }
    static void floyd(){
        for(int via=0;via<N;via++){
            for(int s=0;s<N;s++){
                for(int e=0;e<N;e++){
                    if(via==s || via==e || s==e) continue;
                    if(mat[s][via]+mat[via][e]<=minMat[s][e]){
                        minMat[s][e]=mat[s][via]+mat[via][e];
                        hist[s][e]=via;
                    }
                }
            }
        }
    }
    static void markPath(int s, int e) {
        int via = hist[s][e];
        if (via == INF) {
            need[s][e] = true;
            return;
        }
        markPath(s, via);
        markPath(via, e);
    }
}
