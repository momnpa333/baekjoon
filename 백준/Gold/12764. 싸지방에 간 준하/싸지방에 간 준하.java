import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static PriorityQueue<Item> pq;
    static PriorityQueue<Integer> posPC;
    static int[] usePC;
    static int[] rentPC;
    static int maxPC=1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());

        pq=new PriorityQueue<>((o1, o2) -> o1.time-o2.time);
        posPC=new PriorityQueue<>();
        usePC=new int[N+1];
        rentPC=new int[N+1];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            pq.add(new Item(s,0,i+1));
            pq.add(new Item(e,1,i+1));
        }

        while (!pq.isEmpty()){
            Item item=pq.poll();
//            System.out.println(item.rentId);
            //컴퓨터 빌리기
            if(item.op==0){
                //사용할 수 있는 컴이 없을 때
                if(posPC.isEmpty()){
                    rentPC[item.rentId]=maxPC;
                    usePC[maxPC++]++;
                }
                //있을 때
                else{
                    int pcId=posPC.poll();
                    rentPC[item.rentId]=pcId;
                    usePC[pcId]++;
                }
            }
            //컴퓨터 반납
            if(item.op==1){
                posPC.add(rentPC[item.rentId]);
            }
//            System.out.println(Arrays.toString(rentPC));
//            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        }
        System.out.println(maxPC-1);
        for(int i=1;i<=N;i++){
            if(usePC[i]!=0){
                bw.write(usePC[i]+" ");
            }
        }
        bw.flush();


    }
    static class Item{
        int rentId;
        int time;
        int op;
        Item(int time,int op,int rentId){
            this.time=time;
            this.op=op;
            this.rentId=rentId;
        }

    }

}


