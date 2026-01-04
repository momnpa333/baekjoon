import java.io.*;
import java.util.*;

public class Main {
    static int N,Q;
    static int[] places;
    static int cur;
    static int[] prefix;
    static TreeSet<Integer> set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        set=new TreeSet<>();

        N=Integer.parseInt(st.nextToken());
        Q=Integer.parseInt(st.nextToken());
        places=new int[N];
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            places[i]=Integer.parseInt(st.nextToken());
            if(places[i]==1){
                set.add(i);
            }
        }
        prefix=new int[N*2];
        for(int i=1;i<N*2;i++){
            if(i<N)
                prefix[i]=prefix[i-1]+places[i];
            else{
                prefix[i]=prefix[i-1]+places[i%N];
            }
        }
//        System.out.println(Arrays.toString(prefix));


        for(int i=0;i<Q;i++){
            st=new StringTokenizer(br.readLine()," ");
            int op1=Integer.parseInt(st.nextToken());
            int op2=-1;
            if(op1!=3){
                op2=Integer.parseInt(st.nextToken());
            }
            if(op1==1){
                op2-=1;
                pickPlace(op2);
                if(set.contains(op2)){
                    set.remove(op2);
                }
                else{
                    set.add(op2);
                }
            }
            if(op1==2){
                move(op2);
            }
            if(op1==3){
                int ans=set.ceiling(cur)!=null?set.ceiling(cur):-1;
//                System.out.println("!!!");
//                System.out.println(cur);
//                System.out.println(set);
//                System.out.println(ans+" "+cur);
                if(ans==-1){
                    ans=set.ceiling(0)!=null?set.ceiling(0):-1;
                    if(ans==-1){
                        System.out.println(ans);
                    }
                    else{
                        System.out.println(ans+N-cur);
                    }
                }
                else{
                    System.out.println(ans-cur);
                }
            }
//            System.out.println(Arrays.toString(places));
        }
//        System.out.println(findMove(0,N));
    }
    static void pickPlace(int place){
        places[place]=places[place]==1?0:1;
    }
    static void move(int amount){
        cur=(cur+amount)%N;
    }
    static int findMove(int left,int right){
        System.out.println(left+" "+right);
        if(left>right){
            return -1;
        }
        int mid=(left+right)/2;
        if(isPossible(mid)) {
            if(mid==left){
                return left;
            }
            return findMove(left,mid);
        }
        else{
            return findMove(mid+1,right);
        }
    }
    static boolean isPossible(int pos){
        if(pos==0){
            return places[cur]==1;
        }
        if(prefix[cur+pos]-prefix[cur]>0) return true;
        return false;
    }
}

