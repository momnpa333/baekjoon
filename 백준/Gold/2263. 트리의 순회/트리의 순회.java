import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] inOrder;
    static int[] postOrder;
    static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        answer=new ArrayList<>();
        inOrder=new int[N];
        postOrder=new int[N];

        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            inOrder[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            postOrder[i]=Integer.parseInt(st.nextToken());
        }
        Node root=new Node(postOrder[N-1]);
        makeTree(root,0,N-1,0,N-1);

        preOrder(root);
        for(int n:answer){
            bw.write(n+" ");
        }
        bw.flush();

    }
    static void preOrder(Node node){
        answer.add(node.num);
        if(node.left!=null){
            preOrder(node.left);
        }
        if(node.right!=null){
            preOrder(node.right);
        }
    }
    static void makeTree(Node parent,int start,int end,int postStart,int rootIdx){
        if(start>=end){
            return;
        }
        for(int i=start;i<=end;i++){
            if(inOrder[i]==parent.num){
                if(i>start){
                    parent.left=new Node(postOrder[postStart+i-1-start]);
                    makeTree(parent.left,start,i-1,postStart,postStart+i-1-start);
                }
                if(i<end){
                    parent.right=new Node(postOrder[rootIdx-1]);
                    makeTree(parent.right,i+1,end,rootIdx-(end-i),rootIdx-1);
                }
            }
        }
    }

    static class Node{
        Node left;
        Node right;
        int num;
        Node(int num){
            this.num=num;
        }
    }


}
