import java.io.*;
import java.util.*;

public class Main {
    static int N1,M1;
    static int N2,M2;
    static boolean[][] mat1;
    static boolean[][] mat2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        N1=Integer.parseInt(st.nextToken());
        M1=Integer.parseInt(st.nextToken());
        mat1=new boolean[N1][M1];

        for(int i=0;i<N1;i++){
            String s=br.readLine();
            for(int j=0;j<M1;j++){
                if(s.charAt(j)=='1'){
                    mat1[i][j]=true;
                }
                else {
                    mat1[i][j]=false;
                }
            }
//            System.out.println(Arrays.toString(mat1[i]));
        }

        st= new StringTokenizer(br.readLine(), " ");
        N2=Integer.parseInt(st.nextToken());
        M2=Integer.parseInt(st.nextToken());
        mat2=new boolean[N2][M2];

        for(int i=0;i<N2;i++) {
            String s = br.readLine();
            for (int j = 0; j < M2; j++) {
                if (s.charAt(j) == '1') {
                    mat2[i][j] = true;
                } else {
                    mat2[i][j] = false;
                }
            }
//            System.out.println(Arrays.toString(mat2[i]));
        }
        turnLeft(mat2);

        int ans=Integer.MAX_VALUE;

        for(int t=0;t<4;t++){
            mat1=turnLeft(mat1);
            for(int i=0;i<4;i++){
                mat2=turnLeft(mat2);
                for(int r=0;r<N1;r++){
                    for(int c=0;c<M1;c++){
                        ans=Math.min(ans, overLap(mat1,mat2,r,c));
                    }
                }
            }
        }
        System.out.println(ans);

    }
    static int overLap(boolean[][] matA, boolean[][] matB, int startR, int startC){
        int R=Math.max(matA.length, startR+matB.length);
        int C=Math.max(matA[0].length, startC+matB[0].length);
        boolean[][] newMat=new boolean[R][C];

        for(int i=0;i<matA.length;i++){
            for(int j=0;j<matA[0].length;j++){
                newMat[i][j]=matA[i][j];
            }
        }
        for(int i=0;i<matB.length;i++){
            for(int j=0;j<matB[0].length;j++){
                if(matB[i][j]){
                    if(newMat[startR+i][startC+j]){
                        return Integer.MAX_VALUE;
                    }
                    newMat[startR+i][startC+j]=true;
                }
            }
        }
        int minR=Integer.MAX_VALUE;
        int minC=Integer.MAX_VALUE;
        int maxR=Integer.MIN_VALUE;
        int maxC=Integer.MIN_VALUE;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(newMat[i][j]){
                    minR=Math.min(minR,i);
                    minC=Math.min(minC,j);
                    maxR=Math.max(maxR,i);
                    maxC=Math.max(maxC,j);
                }
            }
        }
        return (maxR-minR+1)*(maxC-minC+1);
    }
    static boolean[][] turnLeft(boolean[][] mat){
        int N=mat.length;
        int M=mat[0].length;
        boolean[][] newMat=new boolean[M][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                newMat[M-1-j][i]=mat[i][j];
            }
        }
        return newMat;
    }
}

