import java.util.ArrayList;
import java.util.List;

/**
 * <p>并查集的实现<p/>
 *
 * */
public class UnionFind<T> {
    private List<Node> forests;//所有节点
    public UnionFind(){
        forests=new ArrayList<Node>();
    }
    /**
     * 内部类，并查集的rooted node
     * */

    private class Node{
        Node parent;
        int rank;
        T t;
        private Node(T t){
            parent=this;
            rank=0;
            this.t=t;
        }
    }
    //初始化列表和初始化每个节点
    public void init(T t){
        Node node=new Node(t);
        forests.add(node);
    }
    //将包含x和包含y的两个集合进行合并
    public void union(T x,T y){
        Node xNode=isContain(x);
        Node yNode=isContain(y);
        if (xNode!=null&&yNode!=null) {
            link(find(xNode), find(yNode));
        }
    }
    //查找到节点node的根节点
    public Node find(Node node){
        if (node!=node.parent) {
            //路径压缩
            node.parent=find(node.parent);
        }
        return node.parent;
    }
    //查找到节点node的根节点
    public Node find(T t){
        Node node=isContain(t);
        if (node==null) {
            throw new IllegalArgumentException("不含该节点！");
        }else {
            return find(node);
        }

    }
    //将两个根节点代表的集合进行连接
    private void link(Node xNode,Node yNode){
        if (xNode.rank>yNode.rank) {
            yNode.parent=xNode;
        }else {
            xNode.parent=yNode;
            if (xNode.rank==yNode.rank) {
                yNode.rank+=1;
            }
        }
    }

    //判断两个节点是否属于同一范围
    public boolean isConnected(T x, T y){
        return find(x) == find(y);
    }

    //森林是否包含这个节点
    private Node isContain(T t){
        for (Node node : forests) {
            if (node.t.equals(t)) {
                return node;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        if (forests.size()==0) {
            return "并查集为空！";
        }
        StringBuilder builder=new StringBuilder();
        for (Node node : forests) {
            Node root=find(node);
            builder.append(node.t).append("->").append(root.t);
            builder.append("\n");
        }

        return builder.toString();
    }
}

