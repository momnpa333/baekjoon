import java.io.*;
import java.util.*;

public class Main {
    static int A,B;
    static int c,d;
    static Set<Long> visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        visited=new HashSet<>();

        A=Integer.parseInt(st.nextToken());
        B=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        d=Integer.parseInt(st.nextToken());

        System.out.println(solve());
    }

    static int solve(){
        ArrayDeque<Item> dq=new ArrayDeque<>();
        dq.add(new Item(0,0));
        visited.add(0L);
        int cnt=0;

        while(!dq.isEmpty()){
            int L=dq.size();
            for(int i=0;i<L;i++){
                Item item=dq.poll();
                if(item.curA==c && item.curB==d){
                    return cnt;
                }
                //물통 채우기
                if(!visited.contains(getCode(A,item.curB))){
                    dq.add(new Item(A,item.curB));
                    visited.add(getCode(A,item.curB));
                }
                if(!visited.contains(getCode(item.curA,B))){
                    dq.add(new Item(item.curA,B));
                    visited.add(getCode(item.curA,B));
                }
                //물통 비우기
                if(!visited.contains(getCode(0,item.curB))){
                    dq.add(new Item(0,item.curB));
                    visited.add(getCode(0,item.curB));
                }
                if(!visited.contains(getCode(item.curA,0))){
                    dq.add(new Item(item.curA,0));
                    visited.add(getCode(item.curA,0));
                }
                //물통 옮기기
                if(item.curA+item.curB<=B && !visited.contains(getCode(0, item.curB+item.curA))){
                    dq.add(new Item(0,item.curB+item.curA));
                    visited.add(getCode(0, item.curB+item.curA));
                }
                if(item.curA+item.curB>B && !visited.contains(getCode(item.curA+item.curB-B, B))){
                    dq.add(new Item(item.curA+item.curB-B, B));
                    visited.add(getCode(item.curA+item.curB-B, B));
                }
                if(item.curA+item.curB<=A && !visited.contains(getCode( item.curB+item.curA,0))){
                    dq.add(new Item(item.curB+item.curA,0));
                    visited.add(getCode(item.curB+item.curA,0));
                }
                if(item.curA+item.curB>A && !visited.contains(getCode(A,item.curA+item.curB-A))){
                    dq.add(new Item(A,item.curA+item.curB-A));
                    visited.add(getCode(A,item.curA+item.curB-A));
                }
            }
            cnt++;
        }
        return -1;
    }
    static Long getCode(int curA,int curB){
        return curA*100000L+curB;
    }
    static class Item{
        int curA,curB;
        Item(int a,int b){
            this.curA=a;
            this.curB=b;
        }
    }


}
