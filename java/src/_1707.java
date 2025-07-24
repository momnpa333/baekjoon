import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1707 {
    static int K;
    static int V,E;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        K=Integer.parseInt(st.nextToken());

        A:
        while(K-->0){
            st=new StringTokenizer(br.readLine()," ");
            V=Integer.parseInt(st.nextToken()); E=Integer.parseInt(st.nextToken());

            graph=new ArrayList[V+1];
            for(int i=0;i<=V;i++){
                graph[i]=new ArrayList<Integer>();
            }
            for(int i=0;i<E;i++){
                st=new StringTokenizer(br.readLine()," ");
                int v1,v2;
                v1=Integer.parseInt(st.nextToken());    v2=Integer.parseInt(st.nextToken());
                graph[v1].add(v2);  graph[v2].add(v1);
            }

            boolean[] check=new boolean[V+1];
            int[] color = new int[V+1];
            Arrays.fill(color,0);
            boolean isBi=true;

            for(int i=1;i<=V;i++){
                if(!check[i]){
                    isBi=bfs(check,color,i);
                    if(!isBi){
                        System.out.println("NO");
                        continue A;
                    }
                }
            }
            System.out.println("YES");

//            for(int i=0;i<=V;i++){
//                System.out.println(graph[i]);
//            }
        }
    }

    static boolean bfs(boolean[] check,int[] color,int s){
        ArrayDeque<Item> dq=new ArrayDeque<>();

        color[s]=1;
        Item first=new Item(s,1);
        dq.add(first);

        while(!dq.isEmpty()){
            int L=dq.size();
            for(int i=0;i<L;i++){
                Item item=dq.pollLast();
                check[item.v]=true;
                for(int child:graph[item.v]){
                    if(!check[child]){
                        if(color[child]==0){
                            Item tmp=new Item(child,item.color*-1);
                            color[child]=item.color*-1;
                            dq.add(tmp);
                        }
                        else if(color[child]==color[item.v]){
//                            System.out.printf("%d %d\n",child,item.v);
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    static class Item{
        int v;
        int color;
        Item(int v,int color){
            this.v=v;
            this.color=color;
        }
    }

}
