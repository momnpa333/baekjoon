import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            String s=br.readLine();
            if(s.equals("*")) break;
            if(isSurprise(s)){
                System.out.println(s+" is surprising.");
            }
            else{
                System.out.println(s+" is NOT surprising.");
            }
        }
    }
    static boolean isSurprise(String s){
        for(int i=0;i<=s.length()-2;i++){
            if(!isUnique(s,i)) return false;
        }
        return true;
    }
    static boolean isUnique(String s,int gap){
        Set<String> uniqueSet=new HashSet<>();
        for(int i=0;i<s.length();i++){
            String tmp="";
            tmp+=String.valueOf(s.charAt(i));
            if(i+gap+1>=s.length()) break;
            tmp+=String.valueOf(s.charAt(i+gap+1));
            if(uniqueSet.contains(tmp)) return false;
            uniqueSet.add(tmp);
        }
        return true;
    }
}


