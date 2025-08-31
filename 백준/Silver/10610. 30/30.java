import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static String num;
    static Character[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        num=br.readLine();
        nums=new Character[num.length()];
        boolean isHaveTen=false;


        int sum=0;
        for(int i=0;i<num.length();i++){
            sum+=num.charAt(i)-'0';
            if(num.charAt(i)=='0'){
                isHaveTen=true;
            }
            nums[i]=num.charAt(i);
        }
//        System.out.println(sum);
        if(sum%3==0 && isHaveTen){
            Arrays.sort(nums,Collections.reverseOrder());
            String ans="";
            for(int i=0;i<nums.length;i++){
                ans+=nums[i];
            }
            System.out.println(ans);
            return;
        }
        System.out.println(-1);


    }


}
