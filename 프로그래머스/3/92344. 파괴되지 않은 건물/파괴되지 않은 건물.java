import java.util.*;
class Solution {
    int[][] rangeSum;
    public int solution(int[][] board, int[][] skill) {
        rangeSum=new int[board.length+1][board[0].length+1];
        for(int[] ops:skill){
            int op;
            if(ops[0]==1) op=-1;
            else op=1;
            rangeSum[ops[1]][ops[2]]+=ops[5]*op;
            rangeSum[ops[1]][ops[4]+1]+=ops[5]*op*-1;
            rangeSum[ops[3]+1][ops[2]]+=ops[5]*op*-1;
            rangeSum[ops[3]+1][ops[4]+1]+=ops[5]*op;
        }
        for(int r=0;r<rangeSum.length-1;r++){
            for(int c=0;c<rangeSum[0].length-1;c++){
                rangeSum[r][c+1]+=rangeSum[r][c];
            }
        }
        // for(int i=0;i<rangeSum.length;i++){
        //     System.out.println(Arrays.toString(rangeSum[i]));
        // }
        for(int c=0;c<rangeSum[0].length-1;c++){
            for(int r=0;r<rangeSum.length-1;r++){
                rangeSum[r+1][c]+=rangeSum[r][c];
            }
        }
        for(int r=0;r<rangeSum.length-1;r++){
            for(int c=0;c<rangeSum[0].length-1;c++){
                board[r][c]+=rangeSum[r][c];
            }
        }
        // for(int i=0;i<rangeSum.length-1;i++){
        //     System.out.println(Arrays.toString(board[i]));
        // }
        int answer = 0;
        for(int r=0;r<rangeSum.length-1;r++){
            for(int c=0;c<rangeSum[0].length-1;c++){
                if(board[r][c]>0) answer++;
            }
        }
        return answer;
    }
}