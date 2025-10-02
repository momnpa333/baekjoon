import java.util.*;
class Solution {
    String[][] board=new String[51][51];
    Node[][] parents=new Node[51][51];
    ArrayList<String> ans=new ArrayList<>();
    public String[] solution(String[] commands) {
        for(int r=1;r<=50;r++){
            for(int c=1;c<=50;c++){
                parents[r][c]=new Node(r,c);
            }
        }
        for(int i=0;i<commands.length;i++){
            String[] tmp=commands[i].split(" ");
            String op=tmp[0];
            if(op.equals("UPDATE")){
                // System.out.println(Arrays.toString(tmp));
                if(tmp.length==4){
                    int r=Integer.parseInt(tmp[1]);
                    int c=Integer.parseInt(tmp[2]);
                    String v=tmp[3];
                    update(r,c,v);
                }
                else{
                    update(tmp[1],tmp[2]);
                }
            }
            if(op.equals("MERGE")){
                // System.out.println(Arrays.toString(tmp));
                int r1=Integer.parseInt(tmp[1]);
                int c1=Integer.parseInt(tmp[2]);
                int r2=Integer.parseInt(tmp[3]);
                int c2=Integer.parseInt(tmp[4]);
                merge(r1,c1,r2,c2);
            }
            if(op.equals("UNMERGE")){
                // System.out.println(Arrays.toString(tmp));
                int r1=Integer.parseInt(tmp[1]);
                int c1=Integer.parseInt(tmp[2]);
                unmerge(r1,c1);
            }
            if(op.equals("PRINT")){
                // System.out.println(Arrays.toString(tmp));
                int r1=Integer.parseInt(tmp[1]);
                int c1=Integer.parseInt(tmp[2]);
                ans.add(print(r1,c1));
            }
            // for(int n=1;n<=50;n++){
            //     System.out.println(Arrays.toString(parents[n]));
            // }
        }
        String[] answer = new String[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i]=ans.get(i);
        }
        return answer;
    }
    Node findParent(int r,int c) {
        if(parents[r][c]!=parents[r][c].parent){
            return parents[r][c].parent=findParent(parents[r][c].parent.r,parents[r][c].parent.c);
        }
        return parents[r][c];
    }
    void update(int r,int c,String value){
        Node parent=findParent(r,c);
        parent.value=value;
    }
    void update(String value1,String value2){
        for(int i=1;i<=50;i++){
            for(int j=1;j<=50;j++){
                if(findParent(i,j).value!=null && findParent(i,j).value.equals(value1)){
                    findParent(i,j).value=value2;
                }
            }
        }
    }
    
    void merge(int r1,int c1,int r2,int c2){
        Node parent1=findParent(r1,c1);
        Node parent2=findParent(r2,c2);
        
        if(parent1.value!=null && parent2.value!=null){
            parent2.parent=parent1;
            return;
        }
        if(parent1.value!=null){
            parent2.parent=parent1;
            return;
        }
        if(parent2.value!=null){
            parent1.parent=parent2;
            return;
        }
        if(parent1.value==null && parent2.value==null){
            parent2.parent=parent1;
            return;
        }
    }
    String print(int r,int c){
        Node parent=findParent(r,c);
        // System.out.println(parent.value);
        if(parent.value!=null) return parent.value;
        return "EMPTY";
    }
    void unmerge(int r,int c){
        Node parent=findParent(r,c);
        
        String tmp=parent.value;
        for(int i=1;i<=50;i++){
            for(int j=1;j<=50;j++){
                findParent(i,j);
            }
        }
        for(int i=1;i<=50;i++){
            for(int j=1;j<=50;j++){
                // System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
                // System.out.printf("%d %d\n",i,j);
                // System.out.println(findParent(i,j));
                // System.out.println(parents[i][j].parent);
                if(findParent(i,j)==parent){
                    // System.out.printf("%d %d\n",parents[i][j].r,parents[i][j].c);
                    parents[i][j].parent=parents[i][j];
                    parents[i][j].value=null;
                    // System.out.println(findParent(i,j));
                }
                
            }
        }
        parents[r][c].value=tmp;
        
    }
    class Node{
        int r;
        int c;
        String value;
        Node parent;
        Node(int r,int c){
            this.r=r;
            this.c=c;
            parent=this;
        }
        public String toString(){
            return this.r+" "+this.c;
        }
    }
}