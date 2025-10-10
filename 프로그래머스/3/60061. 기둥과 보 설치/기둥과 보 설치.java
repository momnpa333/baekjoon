import java.util.*;
class Solution {
    ArrayList<Integer>[][] board;
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        board=new ArrayList[n+2][n+2];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                board[i][j]=new ArrayList<Integer>();
            }
        }
        for(int[] build:build_frame){
            if(build[2]==0 && build[3]==0){//기둥 삭제
                removeTop(build[0],build[1]);
            }
            if(build[2]==0 && build[3]==1){ //기둥 설치
                makeTop(build[0],build[1]);
            }
            if(build[2]==1 && build[3]==0){ //보 삭제
                removeFloor(build[0],build[1]);
            }
            if(build[2]==1 && build[3]==1){ //보 설치
                makeFloor(build[0],build[1]);
            }
        }
        // for(int i=0;i<=n;i++){
        //     for(int j=0;j<=n;j++){
        //         System.out.printf("%d %d\n",i,j);
        //         System.out.println(board[i][j]);
        //     }
        // }
        ArrayList<Item> ans=new ArrayList<>();
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(board[i][j].size()>0){
                    for(int op:board[i][j]){   
                       ans.add(new Item(i,j,op));
                    }
                }
            }
        }
        Collections.sort(ans);
        answer=new int[ans.size()][3];
        for (int k = 0; k < ans.size(); k++) {
            Item it = ans.get(k);
            answer[k][0] = it.x;
            answer[k][1] = it.y;
            answer[k][2] = it.op;
        }
        return answer;
    }
    void makeTop(int x,int y){
        if(y==0){
            board[x][y].add(0);
            return;
        }
        if((x-1>=0 && board[x-1][y].contains(1)) || board[x][y].contains(1) || board[x][y-1].contains(0)){
            board[x][y].add(0);
            return;
        }
    }
    void makeFloor(int x,int y){
        if(board[x][y-1].contains(0) || board[x+1][y-1].contains(0)){
            board[x][y].add(1);
            return;
        }
        if((x-1>=0 && board[x-1][y].contains(1)) && board[x+1][y].contains(1)){
            board[x][y].add(1);
            return;
        }
    }
    boolean isPossibleTop(int x,int y){
        if(y==0){
            return true;
        }
        if((x-1>=0 && board[x-1][y].contains(1)) || board[x][y].contains(1) || board[x][y-1].contains(0)){
            return true;
        }
        return false;
    }
    boolean isPossibleFloor(int x,int y){
        if(board[x][y-1].contains(0) || board[x+1][y-1].contains(0)){
            return true;
        }
        if((x-1>=0 && board[x-1][y].contains(1)) && board[x+1][y].contains(1)){
            return true;
        }
        return false;
    }
    void removeTop(int x,int y){
        board[x][y].remove(new Integer(0));
        if(board[x][y+1].contains(0) && !isPossibleTop(x,y+1)){
            board[x][y].add(0);
            return;
        }
        if(board[x][y+1].contains(1) && !isPossibleFloor(x,y+1)){
            board[x][y].add(0);
            return;
        }
        if((x-1>=0 && board[x-1][y+1].contains(1)) && (x-1>=0 && !isPossibleFloor(x-1,y+1))){
            board[x][y].add(0);
            return;
        }
    }
    
    void removeFloor(int x,int y){
        board[x][y].remove(new Integer(1));
        if(board[x+1][y].contains(1) && !isPossibleFloor(x+1,y)){
            board[x][y].add(1);
            return;
        }
        if(x-1>=0 && board[x-1][y].contains(1) && !isPossibleFloor(x-1,y)){
            board[x][y].add(1);
            return;
        }
        if(board[x][y].contains(0) && !isPossibleTop(x,y)){
            board[x][y].add(1);
            return;
        }
        if(board[x+1][y].contains(0) && !isPossibleTop(x+1,y)){
            board[x][y].add(1);
            return;
        }
    }
    class Item implements Comparable<Item> {
        int x;
        int y;
        int op;

        Item(int x, int y, int op) {
            this.x = x;
            this.y = y;
            this.op = op;
        }

        public int compareTo(Item o) {
            if (this.x != o.x) return this.x - o.x;
            if (this.y != o.y) return this.y - o.y;
            return this.op - o.op; // 0(기둥), 1(보)
        }
    }
    
}