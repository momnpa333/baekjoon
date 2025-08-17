import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _10800 {
    static int N;
    static Ball[] balls;
    static Ball[] sortedTotal;
    static ArrayList<Ball>[] weightBall;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        balls=new Ball[N];
        sortedTotal=new Ball[N];
        weightBall=new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            weightBall[i]=new ArrayList<>();
        }

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            int color=Integer.parseInt(st.nextToken());
            int weight=Integer.parseInt(st.nextToken());
            balls[i]=new Ball(i,color,weight);
            sortedTotal[i]=balls[i];
            weightBall[color].add(balls[i]);
        }
        for(int i=0;i<=N;i++){
            Collections.sort(weightBall[i]);
            for(int j=weightBall[i].size()-2;j>=0;j--){
                if(weightBall[i].get(j).weight>weightBall[i].get(j+1).weight){
                    weightBall[i].get(j).sameEat=weightBall[i].get(j+1).weight+weightBall[i].get(j+1).sameAddEat+weightBall[i].get(j+1).sameEat;
                }
                else{
                    weightBall[i].get(j).sameAddEat=weightBall[i].get(j+1).weight+weightBall[i].get(j+1).sameAddEat;
                    weightBall[i].get(j).sameEat=weightBall[i].get(j+1).sameEat;
                }
            }
        }
        Arrays.sort(sortedTotal);

        for(int i=N-2;i>=0;i--){
            if(sortedTotal[i].weight>sortedTotal[i+1].weight){
                sortedTotal[i].eat=sortedTotal[i+1].weight+sortedTotal[i+1].addEat+sortedTotal[i+1].eat;
            }
            else{
                sortedTotal[i].addEat=sortedTotal[i+1].weight+sortedTotal[i+1].addEat;
                sortedTotal[i].eat=sortedTotal[i+1].eat;
            }
        }
        for(int i=0;i<N;i++){
            System.out.println(balls[i].eat-balls[i].sameEat);
        }

    }
    static class Ball implements Comparable<Ball>{
        int idx;
        int color;
        int weight;
        int eat=0;
        int addEat=0;
        int sameEat=0;
        int sameAddEat=0;
        Ball(int idx,int color,int weight){
            this.idx=idx;
            this.color=color;
            this.weight=weight;
        }
        public int compareTo(Ball o){
            if(this.weight>o.weight){
                return -1;
            }
            return 1;
        }
        public String toString(){
            return color+" "+weight+" "+eat+" "+addEat+" "+sameEat+" "+sameAddEat;
        }
    }

}
