import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _17140 {
    static int R;
    static int C;
    static int K;
    static int[][] A;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        A=new int[3][3];

        for(int i=0;i<3;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<3;j++){
                A[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            if(R-1<A.length && C-1< A[0].length && A[R-1][C-1]==K){
                System.out.println(answer);
                return;
            }
            if(A.length>=A[0].length){
                R();
            }
            else{
                C();
            }
            answer++;
            if(answer>100){
                System.out.println(-1);
                return;
            }
        }

    }
    static void R(){
        int colSize=-1;
        PriorityQueue<Item> pq=new PriorityQueue<>();
        for(int i=0;i<A.length;i++){
            Map<Integer,Integer> candi=new HashMap<>();
            for(int j=0;j<A[i].length;j++){
                if(A[i][j]==0){
                    continue;
                }
                candi.put(A[i][j],candi.getOrDefault(A[i][j],0)+1);
            }
            for(int key: candi.keySet()){
                Item item=new Item(key,candi.get(key));
                pq.add(item);
            }
            colSize=Math.max(colSize,pq.size());
            int[] tmp=new int[colSize*2]; int idx=0;
            Arrays.fill(tmp,0);

            while(!pq.isEmpty()){
                Item item=pq.poll();
                tmp[idx]=item.v; tmp[idx+1]= item.cnt;
                idx+=2;
            }
            A[i]=tmp;
        }

        for(int i=0;i<A.length;i++){
            if(A[i].length<colSize*2){
                A[i]=Arrays.copyOf(A[i],colSize*2);
            }
        }


    }
    static void C(){
        int[][] newAry=new int[101][101];
        int rowSize=-1;
        PriorityQueue<Item> pq=new PriorityQueue<>();
        for(int i=0;i<A[0].length;i++){
            Map<Integer,Integer> candi=new HashMap<>();
            for(int j=0;j<A.length;j++){
                if(A[j][i]==0){
                    continue;
                }
                candi.put(A[j][i],candi.getOrDefault(A[j][i],0)+1);
            }
            for(int key: candi.keySet()){
                Item item=new Item(key,candi.get(key));
                pq.add(item);
            }
            rowSize=Math.max(rowSize,pq.size());
            int[] tmp=new int[rowSize*2]; int idx=0;
            Arrays.fill(tmp,0);

            int cnt=0;
            while(!pq.isEmpty()){
                Item item=pq.poll();
                newAry[cnt][i]=item.v; newAry[cnt+1][i]=item.cnt;
                cnt+=2;
            }
        }

        A=new int[rowSize*2][A[0].length];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[i].length;j++){
                A[i][j]=newAry[i][j];
            }
        }


    }

    static class Item implements Comparable<Item>{
        int v;
        int cnt;
        Item(int v,int cnt){
            this.v=v;
            this.cnt=cnt;
        }

        @Override
        public int compareTo(Item o) {
            if(this.cnt>o.cnt){
                return 1;
            }
            if(this.cnt==o.cnt){
                if(this.v>o.v){
                    return 1;
                }
            }
            return -1;
        }
    }

}
