import java.util.*;
class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i=0;i<numbers.length;i++){
            if(isPossible(numbers[i],findSize(numbers[i]))){
                answer[i]=1;
            }
            else answer[i]=0;
        }
        return answer;
    }
    boolean isPossible(long num,int size){
        boolean[] isOne=new boolean[size];
        int idx=size-1;
        while(num>0){
            isOne[idx--]=num%2==1;
            num/=2;
        }
        // System.out.println(size);
        // System.out.println(Arrays.toString(isOne));
        
        return checkTree(size/2,true,isOne,(size/2+1)/2);
    }
    boolean checkTree(int idx,boolean parent,boolean[] state,int step){
        boolean cur = state[idx];
        if (!parent && cur) return false;
        if (step == 0) return true;

        int left = idx - step;
        int right = idx + step;

        if (!checkTree(left, cur, state, step / 2)) return false;
        if (!checkTree(right, cur, state, step / 2)) return false;
        return true;
    }
    int findSize(long num){
        int cnt=1;
        while(true){
            if((Math.pow(2,cnt)-1>=num)){
                break;
            }
            cnt++;
        }
        int idx=1;
        while(true){
            if((Math.pow(2,idx)-1>=cnt)){
                break;
            }
            idx++;
        }
        
        // System.out.println(Math.pow(2,idx)-1);
        return (int)Math.pow(2,idx)-1;
    }
}