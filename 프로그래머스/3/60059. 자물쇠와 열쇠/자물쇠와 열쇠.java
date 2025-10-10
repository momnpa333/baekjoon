import java.util.*;
class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        
        // System.out.println(isPossible(turn(key),lock,3,3));
        return makeCase(key,lock);
        // return false;
    }
    boolean makeCase(int[][] key,int[][] lock){
        int[][] turnedLock=lock;
        int[][] turnedKey=key;
        for(int j=0;j<4;j++){
            turnedLock=turn(turnedLock);
            for(int i=0;i<4;i++){
                turnedKey=turn(turnedKey);
                for(int r=0;r<=lock.length;r++){
                    for(int c=0;c<=lock.length;c++){            
                        if(isPossible(turnedKey,turnedLock,r,c)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    int[][] turn(int[][] board){
        int[][] ret=new int[board.length][board.length];
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board.length;c++){
                ret[c][(board.length-1)-r]=board[r][c];
            }
        }
        // for(int r=0;r<ret.length;r++){
        //     System.out.println(Arrays.toString(ret[r]));
        // }
        return ret;
    }
    boolean isPossible(int[][] key,int[][] lock,int moveR,int moveC){
        for(int r=0;r<lock.length;r++){
            for(int c=0;c<lock[0].length;c++){
                if(r<moveR || c<moveC){
                    // System.out.printf("%d %d %d\n",r,c,lock[r][c]);
                    if(lock[r][c]!=1) return false;
                }
                else{
                    if(r-moveR<key.length && c-moveC<key.length){  
                        // System.out.printf("%d %d %d %d\n",r,c,lock[r][c],key[r-moveR][c-moveC]);
                        if(key[r-moveR][c-moveC]+lock[r][c]!=1) return false;
                    }
                    else{
                        // System.out.printf("%d %d %d\n",r,c,lock[r][c]);
                        if(lock[r][c]!=1) return false;
                    }
                }
            }
        }
        return true;
    }
}