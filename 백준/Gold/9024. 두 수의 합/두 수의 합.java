import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int T;
    static int N,K;
    static int[] nums;
    static Map<Integer,Integer> numDict;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T=Integer.parseInt(st.nextToken());

        while(T-->0){
            st=new StringTokenizer(br.readLine()," ");
            N=Integer.parseInt(st.nextToken()); K=Integer.parseInt(st.nextToken());
            nums=new int[N];
            numDict=new HashMap<>();
            st=new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++){
                nums[i]=Integer.parseInt(st.nextToken());
            }
            Arrays.sort(nums);
            int gap=findGap();
            makeNumDict(gap);
            if(gap==0){
                System.out.println(numDict.get(K));
            }
            else{
                System.out.println(numDict.getOrDefault(K-gap,0)+numDict.getOrDefault(K+gap,0));
            }
        }

    }
    static int findGap(){
        int left=0; int right=N-1;
        int ret=Integer.MAX_VALUE;
        while(left<right){
            ret=Math.min(ret,Math.abs(K-(nums[left]+nums[right])));
            if(nums[left]+nums[right]>K){
                right-=1;
            }
            else if(nums[left]+nums[right]<=K){
                left+=1;
            }
        }
        return ret;
    }
    static void makeNumDict(int gap){
//        System.out.println(gap);
        int left=0; int right=N-1;
        while(left<right){
            if(Math.abs(K-(nums[left]+nums[right]))==gap){
                numDict.put(nums[left]+nums[right],numDict.getOrDefault(nums[left]+nums[right],0)+1);
            }
            if(nums[left]+nums[right]>K){
                right-=1;
            }
            else if(nums[left]+nums[right]<=K){
                left+=1;
            }
        }
    }


}
