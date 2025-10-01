class Solution {
    int[] dr={1,0,0,-1};
    int[] dc={0,-1,1,0};
    String[] op={"d","l","r","u"};
    boolean[][][] visited;
    int tr,tc;
    String answer="impossible";
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        visited=new boolean[k+1][n][m];
        tr=r-1; tc=c-1;
        visited[0][x-1][y-1]=true;
        dfs(0,x-1,y-1,n,m,"",k);
        return answer;
    }
    boolean dfs(int depth,int r,int c,int n,int m,String hist,int k){
        // System.out.println(hist);
        if(depth>=k && r==tr && c==tc){
            // System.out.println(hist);
            answer=hist;
            return true;
        }
        if(depth>=k){
            // System.out.println(hist);
            // System.out.printf("%d %d %d %d\n",r,c,tr,tc);
            return false;
        }
        for(int i=0;i<4;i++){
            int curR=r+dr[i];
            int curC=c+dc[i];
            if(curR>=0 && curR<n && curC>=0 && curC<m && !visited[depth+1][curR][curC]){
                visited[depth+1][curR][curC]=true;
                if(dfs(depth+1,curR,curC,n,m,hist+op[i],k)){
                    return true;
                }
            }
        }
        return false;
    }
}