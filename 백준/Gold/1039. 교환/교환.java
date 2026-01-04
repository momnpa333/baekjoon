import java.io.*;
import java.util.*;

public class Main {
    static int N,K;
    static ArrayDeque<Integer>dq;
    static Set<Integer> visited;
    static int ans=-1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        dq=new ArrayDeque<>();
        int size=(int) Math.log10(N)+1;
        dq.add(N);
        visited=new HashSet<>();
        int cnt=0;
        while(!dq.isEmpty()){
            int L=dq.size();
//            System.out.println(dq);
            if(cnt==K){
                break;
            }
            visited=new HashSet<>();
            for(int i=0;i<L;i++){
                int item=dq.poll();
                for(int f=1;f<size;f++){
                    for(int s=f+1;s<=size;s++){
                        int next=changeNum(item,f,s);
                        if(next!=-1 && !visited.contains(next)){
                            visited.add(next);
                            dq.add(next);
                            if(cnt==K-1){
                                ans=Math.max(next,ans);
                            }
                        }
                    }
                }
            }
            cnt++;
        }
        System.out.println(ans);
    }
    static int changeNum(int num,int a,int b){
//        System.out.println(num+" "+a+" "+b);
        int l= (int) Math.log10(num);
        int aNum= (int) (num/Math.pow(10,l-a+1))%10;
        int bNum= (int) (num/Math.pow(10,l-b+1))%10;
//        System.out.println(l+" "+aNum+" "+bNum);

        int newNum= (int) (num-aNum*Math.pow(10,l-a+1)-bNum*Math.pow(10,l-b+1)+aNum*Math.pow(10,l-b+1)+bNum*Math.pow(10,l-a+1));
        if((int)(newNum/Math.pow(10,l))==0){
            return -1;
        }
        return newNum;
    }
}


