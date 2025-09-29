import java.util.*;
class Solution {
    ArrayList<Integer>[] graph;
    int answer;
    int L;
    public int solution(int[] info, int[][] edges) {
        L=info.length;
        graph=new ArrayList[info.length];
        for(int i=0;i<info.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        bfs(info);
        return answer;
    }
    
    void bfs(int[] info){
        int[][] visited=new int[L][L+1];
        PriorityQueue<Item> pq=new PriorityQueue<>();
        visited[0][1]=1;
        Item tmp1=new Item(1,0,0,new HashSet<>());
        tmp1.via.add(0);
        pq.add(tmp1);
        while(!pq.isEmpty()){
            Item item=pq.poll();
            answer=Math.max(answer,item.sheep);
            if(item.gap<visited[item.node][item.sheep])
                continue;
            for(int node:graph[item.node]){
                if(info[node]==0){
                    if(!item.via.contains(node)){
                        Item tmp=new Item(item.sheep+1,item.wolf,node,item.via);
                        tmp.via.add(node);
                        pq.add(tmp);
                        visited[node][item.sheep+1]=Math.max(visited[node][item.sheep+1],item.gap+1);
                    }
                    else{
                        if(item.gap>visited[node][item.sheep]){      
                            pq.add(new Item(item.sheep,item.wolf,node,item.via));
                            visited[item.node][item.sheep]=item.gap;
                        }
                    }
                }
                else{
                    if(item.gap>1){
                        if(!item.via.contains(node)){
                            Item tmp=new Item(item.sheep,item.wolf+1,node,item.via);
                            tmp.via.add(node);
                            pq.add(tmp);
                            visited[node][item.sheep]=item.gap-1;
                        }
                        else{
                            if(item.gap>visited[node][item.sheep]){                        
                                pq.add(new Item(item.sheep,item.wolf,node,item.via));
                                visited[item.node][item.sheep]=item.gap;
                            }
                        }
                    }
                }
            }
        }
    }
    class Item implements Comparable<Item>{
        int sheep;
        int wolf;
        int node;
        int gap;
        HashSet<Integer> via=new HashSet<>();
        Item(int s,int w,int n,HashSet<Integer> v){
            sheep=s;
            wolf=w;
            node=n;
            gap=s-w;
            for(int i:v){
                via.add(i);
            }
        }
        public int compareTo(Item o){
            if(this.gap>o.gap){
                return -1;
            }
            if(this.gap==o.gap){
                return o.sheep-this.sheep;
            }
            return 1;
        }
        public String toString(){
            return this.node+" "+this.sheep+" "+this.wolf;
        }
    }
    
}