import java.util.*;
//3:48
class Solution {
    ArrayList<ArrayList<Integer>> permList=new ArrayList<>();
    public int solution(int n, int[] weak, int[] dist) {
        int m=weak.length;
        int[] w=new int[m * 2];
        for (int i=0;i<m;i++) {
            w[i]=weak[i];
            w[i+m]=weak[i]+n;
        }
        Arrays.sort(dist);
        reverse(dist);
        // System.out.println(Arrays.toString(w));
        int answer = Integer.MAX_VALUE;
        // System.out.println(Arrays.toString(Arrays.copyOfRange(dist,0,2)));
        return solve(w,dist,m);
        
        // isPossible(w.subList(0,4),permLis);
        // return answer;
    }
    int solve(int[] w,int[] dist,int m){
        for(int i=1;i<=dist.length;i++){
            permList=new ArrayList<>();
            makePerm(Arrays.copyOfRange(dist,0,i),new ArrayList<Integer>(),new boolean[i],0);
            for(ArrayList<Integer> perm:permList){
                for(int j=0;j<m;j++)
                if(isPossible(Arrays.copyOfRange(w,j,j+m),perm)){
                    return i;
                }
            }
        }
        return -1;
    }
    
    boolean isPossible(int[] w, ArrayList<Integer> perm) {
        int m = w.length;
        int idx = 0;

        for (int d : perm) {
            int cover = w[idx] + d;        
            while (idx < m && w[idx] <= cover) {
                idx++;                   
                if (idx >= m) return true;      
            }
        }
        return idx >= m;        
    }
    
    void reverse(int[] a) {
        for (int l = 0, r = a.length - 1; l < r; l++, r--) {
            int t = a[l]; a[l] = a[r]; a[r] = t;
        }
    }
    
    void makePerm(int[] candi,ArrayList<Integer> perm,boolean[] visited,int depth){
        if(depth>=candi.length){
            ArrayList<Integer> tmp=new ArrayList<Integer>();
            tmp.addAll(perm);
            permList.add(tmp);
            return;
        }
        for(int i=0;i<candi.length;i++){
            if(!visited[i]){
                visited[i]=true;
                perm.add(candi[i]);
                makePerm(candi,perm,visited,depth+1);
                visited[i]=false;
                perm.remove(new Integer(candi[i]));
            }
        }
    }
    
}