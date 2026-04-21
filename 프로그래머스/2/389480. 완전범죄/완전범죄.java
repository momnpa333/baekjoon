import java.util.*;
class Solution {
    int answer=Integer.MAX_VALUE;
    Set<String> memo;
    public int solution(int[][] info, int n, int m) {
        memo=new HashSet<String>();
        solve(info,0,0,0,0,n,m);
        solve(info,0,1,0,0,n,m);
        if(answer==Integer.MAX_VALUE){
            return -1;
        }
        return answer;
    }
    void solve(int[][] info,int idx,int op,int curA,int curB,int n,int m){
        // 모두 선택 완료
        if(idx>=info.length){
            answer=Math.min(answer,curA);
            return;
        }
        // A 선택
        if(op==0){
            curA+=info[idx][0];
        }
        // B 선택
        else{
            curB+=info[idx][1];
        }
        String s=curA+" "+curB+" "+idx;
        
        // 붙잡힐 때
        if(curA>=n || curB>=m) return;
        if(memo.contains(s)) return;
        else{
            memo.add(s);
        }
        // 현재 answer 이상일 때
        if(curA>=answer) return;
        
        solve(info,idx+1,0,curA,curB,n,m);
        solve(info,idx+1,1,curA,curB,n,m);
    }
}