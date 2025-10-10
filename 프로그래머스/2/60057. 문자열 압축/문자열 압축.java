import java.util.*;
//1:38
class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int i=1;i<=s.length()/2;i++){
            answer=Math.min(trans(s,i),answer);
        }
        // trans(s,2);
        return answer;
    }
    int trans(String s,int size){
        String prev="";
        String ret="";
        int idx=0;
        int cnt=1;
        
        while(true){
            if(idx+size>s.length()){
                if(cnt==1){
                    ret+=prev;
                    ret+=s.substring(idx,s.length());
                }
                else{
                    ret+=cnt+"";
                    ret+=prev;
                    ret+=s.substring(idx,s.length());
                }
                break;
            }
            if(idx+size==s.length()){
                if(s.substring(idx,idx+size).equals(prev)){
                    cnt++;  
                    ret+=cnt+"";
                    ret+=prev;
                }
                else{
                    if(cnt==1){
                        ret+=prev;
                        ret+=s.substring(idx,idx+size);
                    }
                    else{
                        ret+=cnt+"";
                        ret+=prev;
                        ret+=s.substring(idx,idx+size);
                    }
                }
                // ret+=s.substring(idx,s.length());
                break;
            }
            // System.out.println(s.substring(idx,idx+size));
            if(s.substring(idx,idx+size).equals(prev)){
                cnt++;   
            }
            else{
                if(cnt==1){
                    ret+=prev;
                    prev=s.substring(idx,idx+size);
                }
                else{
                    ret+=cnt+"";
                    ret+=prev;
                    prev=s.substring(idx,idx+size);
                    cnt=1;
                }
            }
            idx+=size;        
            // System.out.println(ret);
        }
        // System.out.println(ret);
        return ret.length();
    }
}