import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16434 {
    static int N;
    static int attack;
    static int[][] dungeon;
    static long curHP;
    static long maxHP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); attack=Integer.parseInt(st.nextToken());

        dungeon=new int[N][3];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine()," ");
            dungeon[i][0]=Integer.parseInt(st.nextToken());
            dungeon[i][1]=Integer.parseInt(st.nextToken());
            dungeon[i][2]=Integer.parseInt(st.nextToken());
        }

//        gameStart(10);
        System.out.println(biSearch(0,Long.MAX_VALUE));

    }
    static long biSearch(long left, long right){
//        System.out.printf("%d %d\n",left,right);
        if(left>=right){
            return left;
        }
        long mid=(left+right)/2;

        if(!gameStart(mid)){
            return biSearch(mid+1,right);
        }
        else{
            return biSearch(left,mid);
        }
    }
    static boolean gameStart(long choiceHp){
        maxHP=choiceHp;
        curHP=maxHP;
        int gameAtk=attack;
        for(int i=0;i<N;i++){
            if(dungeon[i][0]==1 && !goDungeon(i,gameAtk)){
//                System.out.printf("fail");
                return false;
            }
            if(dungeon[i][0]==2){
                gameAtk=healing(i,gameAtk);
            }
        }
        return true;
    }

    static boolean goDungeon(int index,int gameAtk){
//        System.out.printf("atk:%d\n",gameAtk);
        int monsterHp=dungeon[index][2];
        while(true){
//            System.out.printf("idx:%d curHp:%d monsterHp:%d \n",index,curHP,monsterHp);
            monsterHp-=gameAtk;
            if(monsterHp<=0){
                return true;
            }
            curHP-=dungeon[index][1];
            if(curHP<=0){
                return false;
            }
        }
    }
    static int healing(int index,int gameAtk){
        gameAtk+=dungeon[index][1];
        curHP=Math.min(maxHP,curHP+dungeon[index][2]);
        return gameAtk;
    }

}
