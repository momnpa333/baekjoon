import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int cur=0;
        int prv=0;
        
        for(int i=0;i<dartResult.length();i++){
            // System.out.println(dartResult.charAt(i));
            char op=dartResult.charAt(i);
            if(Character.isDigit(op)){
                if(i<dartResult.length()-1 && op=='1'&& dartResult.charAt(i+1)=='0'){
                    answer+=prv;
                    prv=cur;
                    cur=10;
                    i++;
                }
                else{
                    answer+=prv;
                    prv=cur;
                    cur=dartResult.charAt(i)-'0';
                }
                
            }
            if(Character.isAlphabetic(op)){
                if(op=='S'){
                    cur*=1;
                }
                if(op=='D'){
                    cur*=cur;
                }
                if(op=='T'){
                    cur=cur*cur*cur;
                }
            }
            else{
                if(op=='*'){
                    cur*=2;
                    prv*=2;
                }
                if(op=='#'){
                    cur*=-1;
                }
            }
        }
        answer+=prv;
        answer+=cur;
        return answer;
    }
}