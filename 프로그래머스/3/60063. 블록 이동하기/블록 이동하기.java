import java.util.*;
class Solution {
    int[] dr={0,1,0,-1};
    int[] dc={1,0,-1,0};
    ArrayDeque<Item> dq;
    HashSet<Integer> visited=new HashSet<>();
    public int solution(int[][] board) {
        int answer = 0;
        int N=board.length;
        dq=new ArrayDeque<Item>();
        Item start=new Item(0,0,0,1);
        visited.add(start.getKey());
        dq.add(start);
        
        while(!dq.isEmpty()){
            int L=dq.size();
            answer+=1;
            for(int i=0;i<L;i++){
                Item item=dq.poll();
                for(int j=0;j<4;j++){
                    int curR1=dr[j]+item.r1;
                    int curC1=dc[j]+item.c1;
                    int curR2=dr[j]+item.r2;
                    int curC2=dc[j]+item.c2;
                    if(isPossible(curR1,curC1,curR2,curC2,N) && board[curR1][curC1]==0 && board[curR2][curC2]==0){
                        Item cur=new Item(curR1,curC1,curR2,curC2);
                        if(visited.contains(cur.getKey())) continue;
                        if((curR1==N-1 && curC1==N-1) ||(curR2==N-1 && curC2==N-1)){
                            return answer;
                        }
                        visited.add(cur.getKey());
                        dq.add(cur);
                    }
                }
                // 2) 회전(반시계)
                for (Item nxt : turnL(item, board)) {
                    int key = nxt.getKey();
                    if (!visited.contains(key)) {
                        if ((nxt.r1==N-1 && nxt.c1==N-1) || (nxt.r2==N-1 && nxt.c2==N-1)) {
                            return answer;
                        }
                        visited.add(key);
                        dq.add(nxt);
                    }
                }

                // 3) 회전(시계)
                for (Item nxt : turnR(item, board)) {
                    int key = nxt.getKey();
                    if (!visited.contains(key)) {
                        if ((nxt.r1==N-1 && nxt.c1==N-1) || (nxt.r2==N-1 && nxt.c2==N-1)) {
                            return answer;
                        }
                        visited.add(key);
                        dq.add(nxt);
                    }
                }
                
            }
            
            
        }
        return answer;
    }
    List<Item> turnL(Item prev, int[][] board) {
        int N = board.length;
        List<Item> res = new ArrayList<>();
        int r1 = prev.r1, c1 = prev.c1, r2 = prev.r2, c2 = prev.c2;

        if (r1 == r2) {
            int r = r1;
            if (isFree(r - 1, c1, board) && isFree(r - 1, c2, board)) {
                res.add(makeItemNormalized(r - 1, c1, r, c1));
                res.add(makeItemNormalized(r - 1, c2, r, c2));
            }
        }
        else if (c1 == c2) {
            int c = c1;
            if (isFree(r1, c - 1, board) && isFree(r2, c - 1, board)) {
                res.add(makeItemNormalized(r1, c - 1, r1, c));
                res.add(makeItemNormalized(r2, c - 1, r2, c));
            }
        }
        return res;
    }

    List<Item> turnR(Item prev, int[][] board) {
        int N = board.length;
        List<Item> res = new ArrayList<>();
        int r1 = prev.r1, c1 = prev.c1, r2 = prev.r2, c2 = prev.c2;

        if (r1 == r2) {
            int r = r1;
            if (isFree(r + 1, c1, board) && isFree(r + 1, c2, board)) {
                res.add(makeItemNormalized(r, c1, r + 1, c1));
                res.add(makeItemNormalized(r, c2, r + 1, c2));
            }
        }
        else if (c1 == c2) {
            int c = c1;
            if (isFree(r1, c + 1, board) && isFree(r2, c + 1, board)) {
                res.add(makeItemNormalized(r1, c, r1, c + 1));
                res.add(makeItemNormalized(r2, c, r2, c + 1));
            }
        }
        return res;
    }

    boolean isFree(int r, int c, int[][] board) {
        int N = board.length;
        if (r < 0 || c < 0 || r >= N || c >= N) return false;
        return board[r][c] == 0;
    }

    Item makeItemNormalized(int r1, int c1, int r2, int c2) {
        if (r1 == r2) { // 가로
            if (c1 <= c2) return new Item(r1, c1, r2, c2);
            else          return new Item(r2, c2, r1, c1);
        } else {        // 세로
            if (r1 <= r2) return new Item(r1, c1, r2, c2);
            else          return new Item(r2, c2, r1, c1);
        }
    }
    boolean isPossible(int r1,int c1,int r2,int c2,int N){
        if(r1>=0 && r1<N && c1>=0 && c1<N && r2>=0 && r2<N && c2>=0 && c2<N){
            return true;
        }
        return false;
    }
    class Item{
        int r1,c1;
        int r2,c2;
        Item(int r1,int c1,int r2,int c2){
            this.r1=r1;
            this.c1=c1;
            this.r2=r2;
            this.c2=c2;
        }
        int getKey(){
            return r1*1000000+c1*10000+r2*100+c2;
        }
    }
}