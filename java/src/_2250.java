import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2250 {
    static int N;
    static Node[] nodes;
    static Node root;
    static int[][] length;
    static int answer;
    static int row;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        nodes=new Node[N+1];
        length=new int[N+1][2];
        check=new boolean[1+N];
        check[0]=true;

        for(int i=0;i<=N;i++){
            length[i][0]=12345678;
        }

        for(int i=0;i<N+1;i++){
            nodes[i]=new Node();
        }


        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            int n=Integer.parseInt(st.nextToken());
            int l=Integer.parseInt(st.nextToken());
            int r=Integer.parseInt(st.nextToken());
            if(l!=-1){
                nodes[n].leftChild=nodes[l];
                check[l]=true;
            }
            if(r!=-1){
                nodes[n].rightChild=nodes[r];
                check[r]=true;
            }
            if(n==1){
                root=nodes[n];
            }

        }
        for(int i=0;i<=N;i++){
            if(!check[i]){
                root=nodes[i];
            }
        }
//        System.out.println(makeChildNum(root));
        makeChildNum(root);
        makeIdx(root, root.leftCnt+1,0,1);

        for(int i=0;i<N+1;i++){

            if(length[i][1]-length[i][0]+1>answer){
                answer=length[i][1]-length[i][0]+1;
                row=i;
            }
        }

        System.out.printf("%d %d",row,answer);


    }
    static void makeIdx(Node current,int cur,int op,int depth){
        if(op==0){
            current.idx=cur;
        }
        if(op==-1){
            current.idx=cur-current.rightCnt;
        }
        if(op==1){
            current.idx=cur+current.leftCnt;
        }
        length[depth][0]=Math.min(length[depth][0],current.idx);
        length[depth][1]=Math.max(length[depth][1],current.idx);
        if(current.leftChild!=null){
            makeIdx(current.leftChild,current.idx-1,-1,depth+1);
        }
        if(current.rightChild!=null){
            makeIdx(current.rightChild,current.idx+1,1,depth+1);
        }

    }
    static int makeChildNum(Node parent){
        if(parent.leftChild!=null)
            parent.leftCnt=makeChildNum(parent.leftChild);
        if(parent.rightChild!=null)
            parent.rightCnt=makeChildNum(parent.rightChild);
        return parent.leftCnt+parent.rightCnt+1;
    }

    static class Node{
        int leftCnt;
        int rightCnt;
        int idx;
        Node leftChild;
        Node rightChild;

        Node(){
        }
        public String toString(){
            return idx+" "+leftCnt+" "+rightCnt;
        }
    }
}
