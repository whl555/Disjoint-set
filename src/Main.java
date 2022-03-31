import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    //���͸��б�
    private int[] fa;

    public Main(int n) {
        fa = new int[n+1];
        for (int i = 1; i <= n; ++i) {
            //������
            fa[i] = i;
        }
    }

    //��ѯһ���ڵ�ڵ�x�����Ƚڵ�
    public int find(int x)
    {
        //����ڵ�x�������ӵģ�Ҳ���Ǹ��ڵ㣬Ҳ�������Ƚڵ�
        if(fa[x] == x)
            return x;
        else{
            //����ڵ㲻�����Ƚڵ㣬Ҳ����˵���������ߣ����»��и��ڵ㣬�����ߵ����ڵ�Ϊֹ�����ǲ�ѯx�ĸ��׽ڵ�����Ƚڵ�
            return fa[x]=find(fa[x]);
        }

    }

    //�ϲ�
    public void union(int p, int q) {
        fa[find(p)] = find(q);
    }

    //�ж��Ƿ���һ������
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    public static void main(String[] args) {
//        //
//        Timer timer = new Timer("��ʱ��");
//        //
//        TimerTask task = new TimerTask(){
//
//            @Override
//            public void run() {
//
//            }
//        };
        //
        long startTime = System.currentTimeMillis(); //��ȡ��ʼʱ��
        //
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        int n = Integer.parseInt(line1.split(" ")[0]);
        int m = Integer.parseInt(line1.split(" ")[1]);
        //
        String[] stringList = new String[m+1];
        //����m������
        for(int i = 1; i <= m; i++){
            stringList[i] =  scanner.nextLine();
        }
        //
        Main unionFind = new Main(n);
        //
        while(m > 0){
            String[] strings = stringList[8-m].split(" ");
            if (strings[0].equals("1")){
                //��1,������Ԫ�غϲ������ǹ�ͬӵ��һ�����ڵ�
                unionFind.union(Integer.parseInt(strings[1]), Integer.parseInt(strings[2]));
            } else{
                //��2
                if (unionFind.isConnected(Integer.parseInt(strings[1]), Integer.parseInt(strings[2]))){
                    //�Ƿ�������һ��
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
