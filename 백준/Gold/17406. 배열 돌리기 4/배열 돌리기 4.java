import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K;
    static int[][] matrix;
    static Item[] items;
    static int answer=987654321;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        matrix=new int[N][M];
        items=new Item[K];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                matrix[i][j]=Integer.parseInt(st.nextToken());
            }
//            System.out.println(Arrays.toString(matrix[i]));
        }

        for(int i=0;i<K;i++){
            int r,c,s;
            st=new StringTokenizer(br.readLine()," ");
            r=Integer.parseInt(st.nextToken())-1;
            c=Integer.parseInt(st.nextToken())-1;
            s=Integer.parseInt(st.nextToken());

//            rotate(r,c,s,matrix);
//            print(matrix);
            items[i]=new Item(r,c,s);
        }
        permutation(0,new boolean[K],new int[K]);
        System.out.println(answer);
    }
    static void permutation(int index,boolean[] visited,int[] seq){
        if(index==K){
            answer=Math.min(answer,solve(seq));
        }
        for(int i=0;i<K;i++){
            if(!visited[i]){
                visited[i]=true;
                seq[index]=i;
                permutation(index+1,visited,seq);
                visited[i]=false;
            }
        }
    }
    static int solve(int[] seq){
        int[][] mat=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                mat[i][j]=matrix[i][j];
            }
        }

        for(int i=0;i<K;i++){
            rotate(items[seq[i]].r,items[seq[i]].c,items[seq[i]].s,mat);
//            print(mat);
        }
        return findAns(mat);
    }
    static int findAns(int[][] mat){
        int ret=987654321;
        for(int i=0;i<N;i++){
            int sum=0;
            for(int j=0;j<M;j++){
                sum+=mat[i][j];
            }
//            System.out.println(sum);
            ret=Math.min(ret,sum);
        }
        return ret;
    }
    static void print(int[][] matrix){
        for(int i=0;i<N;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    static void rotate(int r,int c,int s,int[][] matrix){
        for(int i=1;i<=s;i++){
            move(r,c,i,matrix);
        }
    }
    static void move(int r,int c,int s,int[][] matrix){
        //tmp
        //위
        int tmp2;
        int tmp1=matrix[r-s][c+s];
        for(int i=c+s;i>=c-s+1;i--){
//            System.out.println(i);
//            System.out.println(matrix[r-s][i]+" "+ matrix[r-s][i-1]);
            matrix[r-s][i]=matrix[r-s][i-1];
        }
        //오른쪽
        tmp2=matrix[r+s][c+s];
        for(int i=r+s;i>=r-s+2;i--){
            matrix[i][c+s]=matrix[i-1][c+s];
        }
        matrix[r-s+1][c+s]=tmp1;
        tmp1=tmp2;
        //아래
        tmp2=matrix[r+s][c-s];
        for(int i=c-s;i<=c+s-2;i++){
            matrix[r+s][i]=matrix[r+s][i+1];
        }
        matrix[r+s][c+s-1]=tmp1;
        tmp1=tmp2;
        //왼쪽
        for(int i=r-s;i<=r+s-1;i++){
            matrix[i][c-s]=matrix[i+1][c-s];
        }
        matrix[r+s-1][c-s]=tmp1;
        return;
    }
    static class Item{
        int r,c,s;
        Item(int r,int c,int s){
            this.r=r;
            this.c=c;
            this.s=s;
        }
    }
}