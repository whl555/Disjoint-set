import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    //泛型父列表
    private int[] fa;

    public Main(int n) {
        fa = new int[n+1];
        for (int i = 1; i <= n; ++i) {
            //自连接
            fa[i] = i;
        }
    }

    //查询一个节点节点x的祖先节点
    public int find(int x)
    {
        //这个节点x是自连接的，也就是根节点，也就是祖先节点
        if(fa[x] == x)
            return x;
        else{
            //这个节点不是祖先节点，也就是说还能往下走，往下还有父节点，还能走到根节点为止，我们查询x的父亲节点的祖先节点
            return fa[x]=find(fa[x]);
        }

    }

    //合并
    public void union(int p, int q) {
        fa[find(p)] = find(q);
    }

    //判断是否在一个集合
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    public static void main(String[] args) {
//        //
//        Timer timer = new Timer("计时器");
//        //
//        TimerTask task = new TimerTask(){
//
//            @Override
//            public void run() {
//
//            }
//        };
        //
        long startTime = System.currentTimeMillis(); //获取开始时间
        //
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        int n = Integer.parseInt(line1.split(" ")[0]);
        int m = Integer.parseInt(line1.split(" ")[1]);
        //
        String[] stringList = new String[m+1];
        //处理m行输入
        for(int i = 1; i <= m; i++){
            stringList[i] =  scanner.nextLine();
        }
        //
        Main unionFind = new Main(n);
        //
        while(m > 0){
            String[] strings = stringList[8-m].split(" ");
            if (strings[0].equals("1")){
                //是1,把两个元素合并，他们共同拥有一个根节点
                unionFind.union(Integer.parseInt(strings[1]), Integer.parseInt(strings[2]));
            } else{
                //是2
                if (unionFind.isConnected(Integer.parseInt(strings[1]), Integer.parseInt(strings[2]))){
                    //是否连接在一起
                    System.out.println("Y");
                } else{
                    System.out.println("N");
                }
            }
            m--;
        }
        //
        long endTime = System.currentTimeMillis();
        long Time = endTime - startTime;
        System.out.println(Time);
    }

}
