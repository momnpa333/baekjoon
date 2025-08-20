import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _6497 {
    static int N,M;
    static int[] parent;
    static Item[] items;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            st=new StringTokenizer(br.readLine()," ");
            M=Integer.parseInt(st.nextToken());
            N=Integer.parseInt(st.nextToken());
            if(M==0 && N==0){
                break;
            }
            items=new Item[N];
            parent=new int[M];
            int total=0;
            for(int i=0;i<M;i++){
                parent[i]=i;
            }
            for(int i=0;i<N;i++){
                st=new StringTokenizer(br.readLine()," ");
                items[i]=new Item(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
                total+=items[i].value;
            }
            Arrays.sort(items);
            for(int i=0;i<N;i++){
                if(findParent(items[i].e1)!=findParent(items[i].e2)){
                    union(items[i].e1,items[i].e2);
                    total-=items[i].value;
                }

            }
            System.out.println(total);
        }

    }
    static void union(int a,int b){
        int parentA=findParent(a);
        int parentB=findParent(b);

        if(parentA<parentB)
            parent[parentB]=parentA;
        else
            parent[parentA]=parentB;
    }
    static int findParent(int node){
        if(parent[node]!=node){
            return parent[node]=findParent(parent[node]);
        }
        return node;
    }

    static class Item implements Comparable<Item>{
        int e1;
        int e2;
        int value;

        Item(int e1,int e2,int value){
            this.e1=e1;
            this.e2=e2;
            this.value=value;
        }
        public int compareTo(Item o){
            return this.value-o.value;
        }
        public String toString(){
            return e1+" "+e2+" "+value;
        }
    }
}
