import java.io.*;
import java.util.*;

public class Main {
    static int S;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        S=Integer.parseInt(st.nextToken());
        ArrayDeque<Item> dq=new ArrayDeque<>();
        dq.add(new Item(1,0,0));
        visited=new boolean[1001][1001];

        while(!dq.isEmpty()){
            int L=dq.size();
//            System.out.println(dq);
            for(int i=0;i<L;i++){
                Item item=dq.poll();
                //1.클립보드 저장
                if(!visited[item.cur][item.cur]){
                    visited[item.cur][item.cur]=true;
                    dq.add(new Item(item.cur,item.cur,item.time+1));
                }
                //2.화면에 저장
                if((item.cur + item.clip)<=1000 && !visited[item.cur][item.clip+item.cur] && item.clip>0){
                    visited[item.cur][item.clip+item.cur]=true;
                    dq.add(new Item(item.cur+item.clip,item.clip,item.time+1));
                    if(item.cur+item.clip==S){
                        System.out.println(item.time+1);
                        return;
                    }
                }
                //3.이모티콘 삭제
                if(!visited[item.cur-1][item.clip] && item.cur-1>0){
                    visited[item.cur-1][item.clip]=true;
                    dq.add(new Item(item.cur-1,item.clip,item.time+1));
                    if(item.cur-1==S){
                        System.out.println(item.time+1);
                        return;
                    }
                }

            }
        }


    }
    static class Item{
        int cur;
        int clip;
        int time;
        Item(int cur,int clip,int time){
            this.cur=cur;
            this.clip=clip;
            this.time=time;
        }
        public String toString(){
            return cur+" "+clip+" "+time;
        }
    }
}
