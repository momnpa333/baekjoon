import java.util.*;

class Solution {
    Map<Integer,Integer> hist;
    Map<Integer,Integer> ans;
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        hist=new HashMap<>();
        ans=new TreeMap<>();
        // System.out.println(Math.ceil((double)0);
        for(String record:records){
            String[] tmp=record.split(" ");
            int time=transTime(tmp[0]);
            int num=Integer.parseInt(tmp[1]);
            if(hist.containsKey(num)){
                ans.put(num,ans.getOrDefault(num,0)+time-hist.get(num));
                hist.remove(num);
            }
            else{
                hist.put(num,time);
            }
        }
        for(int k:hist.keySet()){
            ans.put(k,ans.getOrDefault(k,0)+transTime("23:59")-hist.get(k));
        }
        answer=new int[ans.size()];
        int cnt=0;
        for(int v:ans.values()){
            answer[cnt++]=calc(v,fees);
        }
        
        return answer;
    }
    int calc(int time,int[] fees){
        int ret=fees[1];
        if(time<=fees[0]) return ret;
        ret+=Math.ceil((double)(time-fees[0])/fees[2])*fees[3];
        return ret;
    }
    int transTime(String time){
        int ret=0;
        ret+=Integer.parseInt(time.split(":")[0])*60;
        ret+=Integer.parseInt(time.split(":")[1]);
        return ret;
    }
}