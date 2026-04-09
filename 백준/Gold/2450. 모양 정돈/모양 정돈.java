import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] seq;
    static int[] numCnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());

        seq=new int[N];
        numCnt=new int[4];

        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            seq[i]=Integer.parseInt(st.nextToken());
            numCnt[seq[i]]++;
        }

        System.out.println(getAnswer());
    }
    static int getAnswer(){
        int ret=Integer.MAX_VALUE;
        for(int i=1;i<=3;i++){
            for(int j=1;j<=3;j++){
                for(int k=1;k<=3;k++){
                    if(i==j || j==k || i==k) continue;
                    ret=Math.min(ret,getChangedCnt(i,j,k));
                }
            }
        }
        return ret;
    }

    static int getChangedCnt(int i,int j,int k){
        int[] newSeq = new int[N];
        int[][] diffMat=new int[4][4];
        int idx=0;
        int ret=0;
        for(int t=0;t<numCnt[i];t++){
            newSeq[idx++]=i;
        }
        for(int t=0;t<numCnt[j];t++){
            newSeq[idx++]=j;
        }
        for(int t=0;t<numCnt[k];t++){
            newSeq[idx++]=k;
        }
//        System.out.println(Arrays.toString(newSeq));
//        System.out.println(diff);
        for(int t=0;t<N;t++){
            if(seq[t]==newSeq[t]) continue;
            diffMat[seq[t]][newSeq[t]]++;
        }

//        for(int x=0;x<4;x++){
//            System.out.println(Arrays.toString(diffMat[x]));
//        }
        for(int x=1;x<=3;x++){
            for(int y=2;y<=3;y++){
                if(x==y) continue;
                int pos=Math.min(diffMat[x][y],diffMat[y][x]);
                diffMat[x][y]-=pos;
                diffMat[y][x]-=pos;
                ret+=pos;
            }
        }
        int rest=0;
        for(int x=1;x<=3;x++){
            for(int y=2;y<=3;y++){
                rest=Math.max(rest,diffMat[x][y]);
            }
        }
        ret+=rest*2;
//        System.out.println(ret);


        return ret;
    }

}