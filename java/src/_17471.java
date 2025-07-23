import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _17471 {
    static int N;
    static ArrayList<Integer>[] graph;
    static int[] value;
    static int answer=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N=Integer.parseInt(st.nextToken());

        value=new int[N+1];
        graph=new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            graph[i]=new ArrayList<>();
        }
        st=new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++){
            value[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<N+1;i++){
            st=new StringTokenizer(br.readLine()," ");
            int n=Integer.parseInt(st.nextToken());
            while(n-->0){
                graph[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        dfs(0,new boolean[N+1]);
        if(answer==Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(answer);
        }

    }
    static void dfs(int idx,boolean[] team){
        if(idx==N+1){
            answer=Math.min(answer,getScore(team));
            return;
        }

        dfs(idx+1,team.clone());
        team[idx]=true;
        dfs(idx+1,team.clone());



    }
    static int getScore(boolean[] team){
        ArrayList<Integer> team1=new ArrayList<>();
        ArrayList<Integer> team2=new ArrayList<>();
        for(int i=1;i<N+1;i++){
            if(!team[i]){
                team1.add(i);
            }
            else{
                team2.add(i);
            }
        }
        if(team1.isEmpty() || team2.isEmpty()){
            return Integer.MAX_VALUE;
        }
        if(isConnected(team1) && isConnected(team2)){
            return Math.abs(calc(team1)-calc(team2));
        }
        return Integer.MAX_VALUE;
    }
    static int calc(ArrayList<Integer> team){
        int ret=0;
        for(int t:team){
            ret+=value[t];
        }
        return ret;
    }

    static boolean isConnected(ArrayList<Integer> team){
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        HashSet<Integer> check=new HashSet<>(team);
        boolean[] visited=new boolean[N+1];
        visited[team.get(0)]=true;
        check.remove(team.get(0));
        dq.addFirst(team.get(0));

        while(!dq.isEmpty()){
            int L=dq.size();
            for(int i=0;i<L;i++){
                int item=dq.pollLast();
                for(int j:graph[item]){
                    if(check.contains(j) && !visited[j]){
                        visited[j]=true;
                        dq.add(j);
                        check.remove(j);
                    }
                }
            }
        }
        return check.isEmpty();

    }
}
