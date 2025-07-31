import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _9205 {

    static int T;
    static int N;
    static Shop[] shops;
    static boolean[] visited;
    static int endR,endC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T=Integer.parseInt(st.nextToken());
        A:
        while(T-->0){
            st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            shops=new Shop[N+1];
            visited=new boolean[N+1];
            for(int i=0;i<=N;i++){
                st=new StringTokenizer(br.readLine()," ");
                shops[i]=new Shop(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }
            st=new StringTokenizer(br.readLine()," ");
            endR=Integer.parseInt(st.nextToken());    endC=Integer.parseInt(st.nextToken());
            visited[0]=true;
            ArrayDeque<Shop> dq=new ArrayDeque<>();
            dq.add(shops[0]);
            while(!dq.isEmpty()){
                int L=dq.size();
                for(int i=0;i<L;i++){
                    Shop s=dq.poll();
                    if(canGo(s.r,s.c,endR,endC)){
                        System.out.println("happy");
                        continue A;
                    }
                    for(int j=0;j<=N;j++){
                        if(!visited[j] && canGo(s.r,s.c,shops[j].r,shops[j].c)){
                            visited[j]=true;
                            dq.add(shops[j]);
                        }
                    }
                }
            }
            System.out.println("sad");
        }

    }
    static boolean canGo(int r1,int c1,int r2,int c2){
        if(Math.abs(r1-r2)+Math.abs(c1-c2)<=1000){
            return true;
        }
        return false;
    }
    static boolean dfs(Shop s){
        if(canGo(s.r,s.c,endR,endC)){
            return true;
        }
        for(int i=0;i<=N;i++){
            if(!visited[i] && canGo(s.r,s.c,shops[i].r,shops[i].c)){
                visited[i]=true;
                if(dfs(shops[i])){
                    return true;
                }
                visited[i]=false;
            }
        }
        return false;
    }

    static class Shop{
        int r;
        int c;
        Shop(int r,int c){
            this.r=r;
            this.c=c;
        }

        public String toString() {
            return r+" "+c;
        }
    }

}
