import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String trans=transNum(n,k);
        String[] candi=trans.split("0");
        // System.out.println(Arrays.toString(candi));
        for(String s:candi){
            if(isPrime(s)) answer++;
        }
        return answer;
    }
    boolean isPrime(String n){
        if(n.equals("")) return false;
        
        long num=Long.parseLong(n);
        if(num==1) return false;
        
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0) return false;
        }
        return true;
        
    }
    String transNum(int n,int k){
        String ret="";
        while(n!=0){
            ret=n%k+ret;
            n/=k;
        }
        return ret;
    }
}