import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int T;
    static String[] dp;
    static Map<Integer,Integer> needNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dp=new String[101];
        needNum=new HashMap<>();
        dp[2]="1"; dp[3]="7"; dp[4]="4"; dp[5]="2"; dp[6]="6"; dp[7]="8"; dp[8]="10";
        needNum.put(1,2); needNum.put(2,5); needNum.put(3,5); needNum.put(4,4); needNum.put(5,5);
        needNum.put(6,6);needNum.put(7,3);needNum.put(8,7);needNum.put(9,6);needNum.put(0,6);
        T=Integer.parseInt(st.nextToken());
        while(T-->0){
            st=new StringTokenizer(br.readLine()," ");
            int num=Integer.parseInt(st.nextToken());
            String min=getMin(num);
            String max=getMax(num);
            System.out.printf("%s %s\n",min,max);
//            System.out.println(Arrays.toString(dp));
        }
    }
    static String getMin(int num){
        if(dp[num]!=null){
            return dp[num];
        }
        String ret = null;
        for(int i=0;i<=9;i++){
            String cur=getMin(num-needNum.get(i))+i;
            if(ret==null){
                ret=cur;
            }
            else{
                ret=compare(ret,cur);
            }
        }
        dp[num]=ret;
        return dp[num];
    }
    static String compare(String st1,String st2){
        if(st1.length()<st2.length()){
            return st1;
        }
        else if(st2.length()<st1.length()){
            return st2;
        }
        else{
            for(int i=0;i<st1.length();i++){
                if(st1.charAt(i)<st2.charAt(i)){
                    return st1;
                }
                if(st2.charAt(i)<st1.charAt(i)){
                    return st2;
                }
            }
        }
        return st1;
    }
    static String getMax(int num){
        String ret="";
        while(true){
            if(num==3){
                ret=7+ret;
                break;
            }
            if(num==2){
                ret=1+ret;
                break;
            }
            num-=2;
            ret=1+ret;
        }
        return ret;
    }
}
