import java.util.ArrayList;
import java.util.List;

public class test_for_unionfind {
    public static <T> void main(String[] args) {
        List<String> list = new ArrayList<>();
        UnionFind<String> unionFind = new UnionFind<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        for (String s : list){
            unionFind.init(s);
        }
        unionFind.union("a","b");
        unionFind.union("e","d");
        unionFind.union("a","d");
        unionFind.union("b","d");
        unionFind.union("e","c");
        System.out.println(unionFind.toString());
    }
}
