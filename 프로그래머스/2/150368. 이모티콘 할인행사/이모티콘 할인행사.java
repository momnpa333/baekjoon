import java.util.*;
class Solution {
    List<int[]>disCountSet;
    int[] result={0,0};
    public int[] solution(int[][] users, int[] emoticons) {
        disCountSet=new ArrayList<>();
        makeSet(0,new int[emoticons.length],emoticons);
        calc(users,emoticons);
        return result;
    }
    void calc(int[][] users,int[] emoticons){
        for(int[] dis:disCountSet){
            int totalBuyCnt=0;
            int totalFee=0;
            for(int[] user:users){
                int buyDis=user[0];
                int v=user[1];
                int curFee=0;
                for(int i=0;i<dis.length;i++){
                    if(dis[i]>=buyDis){
                        curFee+=emoticons[i]*(100-dis[i])/100;
                    }
                }
                // System.out.printf("%d %d\n",v,curFee);
                if(curFee>=v){
                    totalBuyCnt+=1;
                }
                else{
                    totalFee+=curFee;
                }
            }
            // System.out.printf("%d %d\n",totalBuyCnt,totalFee);
            if(totalBuyCnt>result[0]){
                result[0]=totalBuyCnt;
                result[1]=totalFee;
            }
            else if(totalBuyCnt==result[0]){
                result[1]=Math.max(result[1],totalFee);
            }
        }
    }
    void makeSet(int depth,int[] rate,int[] emoticons){
        if(depth==rate.length){
            int[] ret=new int[rate.length];
            // System.out.println(Arrays.toString(rate));
            for(int i=0;i<rate.length;i++){
                ret[i]=rate[i];
            }
            disCountSet.add(ret);
            return;
        }
        for(int i=10;i<=40;i+=10){
            rate[depth]=i;
            makeSet(depth+1,rate,emoticons);
        }
    }
    
}