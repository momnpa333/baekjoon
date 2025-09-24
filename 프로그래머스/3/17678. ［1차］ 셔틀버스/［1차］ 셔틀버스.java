import java.util.*;
class Solution {
    static int answerT;
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        findLastHuman(n,t,m,timetable);
        // System.out.println(answerT);
        int answerH=answerT/60;
        int answerM=answerT%60;
        
        if(answerH<10){
            answer+="0";
        }
        answer+=answerH;
        answer+=":";
        if(answerM<10){
            answer+="0";
        }
        answer+=answerM;
        return answer;
    }
    
    static void findLastHuman(int n, int t, int m,String[] timetable){
        Arrays.sort(timetable);
        // System.out.println(Arrays.toString(timetable));
        // ArrayDeque<Integer> dq=new ArrayDeque<>();
        
        
        int busT=9*60;
        int finalT;
        int idx=0;
        for(int i=0;i<n;i++){
            int j=0;
            for(;j<m;j++){
                if(idx>=timetable.length){
                    answerT=busT;
                    return;
                }
                if(isPossible(timetable[idx],busT)){
                    idx++;
                }
                else{
                    break;
                }
            }
            if(i==n-1){
                if(j<m){
                    answerT=busT;
                    return;
                }
                else{
                    answerT=trans(timetable[idx-1])-1;
                    return;
                }
            }
            busT+=t;
        }
        return;
    }
    static int trans(String T){
        int ret=0;
        ret+=Integer.parseInt(T.split(":")[0])*60;
        ret+=Integer.parseInt(T.split(":")[1]);
        return ret;
    }
    static boolean isPossible(String humanT,int bT){
        int hT=0;
        // int bT=0;
        hT+=Integer.parseInt(humanT.split(":")[0])*60;
        hT+=Integer.parseInt(humanT.split(":")[1]);
        // bT+=Integer.parseInt(busT.split(":")[0])*60;
        // bT+=Integer.parseInt(busT.split(":")[1]);
        
        // System.out.printf("%d %d\n",hT,bT);
        if(hT<=bT) return true;
        return false;
        
    }
}