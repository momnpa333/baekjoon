import java.util.*;
class Solution {
    Map<String,Integer> termDict;
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> ans=new ArrayList<>();
        int[] answer = {};
        termDict=new HashMap<String,Integer>();
        for(String term:terms){
            String tmp[]=term.split(" ");
            termDict.put(tmp[0],Integer.parseInt(tmp[1]));
            // System.out.println(termDict.get(tmp[0]));
        }
        for(int i=0;i<privacies.length;i++){
            if(!isPass(today,privacies[i])) ans.add(i+1);
        }
        answer=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i]=ans.get(i);
        }
        return answer;
    }
    boolean isPass(String today,String privacy){
        String[] tmp=privacy.split(" ");
        String startDate=tmp[0];
        String op=tmp[1];
        tmp=today.split("\\.");
        int todayY=Integer.parseInt(tmp[0]);
        int todayM=Integer.parseInt(tmp[1]);
        int todayD=Integer.parseInt(tmp[2]);
        tmp=startDate.split("\\.");
        int startY=Integer.parseInt(tmp[0]);
        int startM=Integer.parseInt(tmp[1]);
        int startD=Integer.parseInt(tmp[2]);
        // return false;
        return compare(todayY,todayM,todayD,startY,startM,startD,op);
    }
    boolean compare(int y1,int m1,int d1,int y2,int m2,int d2,String op){
        m2+=termDict.get(op);
        while(m2>12){
            m2-=12;
            y2+=1;
        }
        // System.out.printf("%d %d %d\n",y1,m1,d1);
        // System.out.printf("%d %d %d\n",y2,m2,d2);
        if(y1>y2) return false;
        if(y1<y2) return true;
        if(m1>m2) return false;
        if(m1<m2) return true;
        if(d1>=d2) return false;
        return true;
    }
    
}