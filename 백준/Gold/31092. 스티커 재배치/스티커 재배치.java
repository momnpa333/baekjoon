import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K;
    static Sticker[] stickers;
    static Sticker[] arys;
    static String origin="";
    static String part;
    static int answer=Integer.MAX_VALUE;
    static int[] buyCosts;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        stickers=new Sticker[M+1];
        arys=new Sticker[N+1];
        buyCosts=new int[26];
        Arrays.fill(buyCosts,Integer.MAX_VALUE);
        for(int i=1;i<=M;i++){
            st=new StringTokenizer(br.readLine()," ");
            String s=st.nextToken();
            int d=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            stickers[i]=new Sticker(s,d,b);
            buyCosts[s.charAt(0)-'a']= Math.min(buyCosts[s.charAt(0)-'a'],b);
        }
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            int j=Integer.parseInt(st.nextToken());
            origin+=stickers[j].v;
            arys[i+1]=stickers[j];
        }
        part=br.readLine();
//        System.out.println(origin);
        solve();
        if(answer==Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(answer);
        }
    }
    static void solve(){
        for(int i=0;i<N-K+1;i++){
            int c=findCost(origin.substring(i,i+K),i);
            if(c!=-1){
                answer=Math.min(c,answer);
            }
        }
    }
    static int findCost(String s,int id){
//        System.out.println(id);
        int ret=0;
        PriorityQueue<Integer>[] tmp=new PriorityQueue[26];
        int[] remainStickers=new int[26];
        for(int i=0;i<26;i++){
            tmp[i]=new PriorityQueue<Integer>();
        }
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<N;i++){
            if(i>=id && i<=id+K-1) continue;
            tmp[origin.charAt(i)-'a'].add(arys[i+1].delete);
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=part.charAt(i)){
                remainStickers[s.charAt(i)-'a']++;
                dq.add(i);
                ret+=arys[i+id+1].delete;
//                System.out.println("안맞는 글자 떼기");
//                System.out.println(arys[i+id+1].delete);
            }
        }
//        System.out.println(Arrays.toString(tmp));
        while(!dq.isEmpty()){
            int idx=dq.poll();
            char target=part.charAt(idx);
            if(remainStickers[target-'a']>0){
                remainStickers[target-'a']--;
            }
            else{
                if(!tmp[target-'a'].isEmpty()){
//                    System.out.println("다른곳에서 떼서 가져오기");
                    if(tmp[target-'a'].peek()<buyCosts[target-'a'])
                        ret+=tmp[target-'a'].poll();
                    else ret+=buyCosts[target-'a'];
                    continue;
                }
                if(buyCosts[target-'a']==Integer.MAX_VALUE) return -1;
//                System.out.println("사기");
//                System.out.println(buyCosts[target-'a']);
                ret+=buyCosts[target-'a'];
            }
        }
        return ret;
    }


    static class Sticker{
        String v;
        int delete;
        int buy;
        Sticker(String v,int delete,int buy){
            this.v=v;
            this.delete=delete;
            this.buy=buy;
        }
    }
}