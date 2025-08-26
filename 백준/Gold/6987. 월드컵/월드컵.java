import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static Result[] results;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s="";

        A:
        for(int j=0;j<4;j++){
            st = new StringTokenizer(br.readLine(), " ");
            results=new Result[6];
            for(int i=0;i<6;i++){
                results[i]=new Result(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
                if(results[i].win+results[i].draw+results[i].lose!=5){
                    s+="0 ";
                    continue A;
                }
            }
            if(dfs(0)){
                s+="1 ";
            }
            else{
                s+="0 ";
            }
        }
        System.out.println(s);

    }
    static boolean dfs(int start){
        if(start==5){
            return true;
        }
//        System.out.println(start);
//        System.out.println(results[start]);
        //3승 1무 1패
        ArrayList<int[]> combi=new ArrayList<>();
        makeCombi(combi,start,start,start,new int[6]);
        for(int[] c:combi){
//            System.out.println(Arrays.toString(c));
            for(int i=start+1;i<6;i++){
                if(c[i]==1){
                    results[i].lose-=1;
                }
                if(c[i]==2){
                    results[i].draw-=1;
                }
                if(c[i]==3){
                    results[i].win-=1;
                }
            }
            boolean flag=true;
            for(int i=start+1;i<6;i++){
                if(!(results[i].win>-1 && results[i].draw>-1 && results[i].lose>-1)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                if(dfs(start+1)){
                    return true;
                }
            }
            for(int i=start+1;i<6;i++){
                if(c[i]==1){
                    results[i].lose+=1;
                }
                if(c[i]==2){
                    results[i].draw+=1;
                }
                if(c[i]==3){
                    results[i].win+=1;
                }
            }
        }
        return false;
    }
    static void makeCombi(ArrayList<int[]> ret,int depth,int start,int idx,int[] candi){
        //승:1 무:2 패:3
        if(depth==5){
            ret.add(candi);
        }
        for(int i=idx+1;i<6;i++){
            if(results[start].win>0){
                results[start].win-=1;
                int[] tmp=Arrays.copyOf(candi,candi.length);
                tmp[i]=1;
                makeCombi(ret,depth+1,start,i,tmp);
                results[start].win+=1;
            }
            if(results[start].draw>0){
                results[start].draw-=1;
                int[] tmp=Arrays.copyOf(candi,candi.length);
                tmp[i]=2;
                makeCombi(ret,depth+1,start,i,tmp);
                results[start].draw+=1;
            }
            if(results[start].lose>0){
                results[start].lose-=1;
                int[] tmp=Arrays.copyOf(candi,candi.length);
                tmp[i]=3;
                makeCombi(ret,depth+1,start,i,tmp);
                results[start].lose+=1;
            }
        }

    }

    static class Result{
        int win;
        int draw;
        int lose;
        Result(int win,int draw,int lose){
            this.win=win;
            this.draw=draw;
            this.lose=lose;
        }
        public String toString(){
            return win+" "+draw+" "+lose;
        }
    }
}
