import java.util.*;
//1:10
class Solution {
    public String solution(String p) {
        String answer = "";
        return two(p);
        // return answer;
    }

    String two(String s){
        int op1=0;
        int op2=0;
        int idx=0;
        
        if(s.equals("")){
            return "";
        }
        
        while(true){
            if(s.charAt(idx)=='('){
                op1++;
            }
            if(s.charAt(idx)==')'){
                op2++;
            }
            if(op1==op2) break;
            idx++;
        }
        String u=s.substring(0,idx+1);
        String v=s.substring(idx+1,s.length());
        
        if(isGood(u)){
            return u+two(v);
        }
        else{
            String tmp1="("+two(v)+")";
            String u2=u.substring(1,u.length()-1);
            String tmp2="";
            for(int i=0;i<u2.length();i++){
                if(u2.charAt(i)=='('){
                    tmp2+=")";
                }
                else{
                    tmp2+="(";
                }
            }
            String ret=tmp1+tmp2;
            return ret;
        }
        // return "";
    }
    boolean isGood(String s){
        ArrayDeque<Character> dq=new ArrayDeque<>();
        // System.out.println(s);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(dq.size()>0 && dq.peek()=='('){
                    dq.poll();
                }
                else{
                    dq.add(s.charAt(i));
                }
            }
            else{
                dq.add(s.charAt(i));
            }
            // System.out.println(dq);
        }
        // System.out.println(dq);
        if(dq.size()==0) return true;
        else return false;
    }
}