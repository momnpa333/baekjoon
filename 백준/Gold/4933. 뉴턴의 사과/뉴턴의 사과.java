import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int idx;
    static Set<String> set1;
    static Set<String> set2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T=Integer.parseInt(st.nextToken());

        while(T-->0){
            st=new StringTokenizer(br.readLine()," ");
            ArrayList<String> info1= new ArrayList<>();
            while(true){
                String v=st.nextToken();
                if(v.equals("end")) break;
                info1.add(v);
            }
            idx=1;
            set1=new TreeSet<>();
            Node root1=makeNode(info1,set1);
//            System.out.println(set1);

            st=new StringTokenizer(br.readLine()," ");
            ArrayList<String> info2= new ArrayList<>();
            while(true){
                String v=st.nextToken();
                if(v.equals("end")) break;
                info2.add(v);
            }
            idx=1;
            set2=new TreeSet<>();
            Node root2=makeNode(info2,set2);
//            System.out.println(set2);
            if (isCorrect()) {
                System.out.println("true");
            }
            else{
                System.out.println("false");
            }
        }
    }
    static boolean isCorrect(){
        for(String s:set1){
            if(!set2.contains(s)){
                return false;
            }
        }
        for(String s:set2){
            if(!set1.contains(s)){
                return false;
            }
        }
        return true;
    }
    static Node makeNode(ArrayList<String> info,Set<String> set){
        if(info.size()-idx<0) return null;
        String v=info.get(info.size()-idx);
//        System.out.println(v+" "+idx);
        if(v.equals("nil")) {
            return null;
        }
        Node node=new Node(v);
        idx++;
        node.right=makeNode(info,set);
        idx++;
        node.left=makeNode(info,set);
//        System.out.println(v+" "+node.right+" "+node.left);
        set.add(v+" "+node.right+" "+node.left);
        set.add(v+" "+node.left+" "+node.right);
        return node;
    }



    static class Node{
        Node left;
        Node right;
        String value;
        Node(String v){
            this.value=v;
        }
        public String toString(){
            return value;
        }

    }
}

