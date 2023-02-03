import java.util.*;

public class Student_order {
    public static void main(String[] args) {
        UF uf=new UF(9);
        Graph edge1= new Graph(0, 4,1,1);
        Graph edge2 = new Graph(1,8,2,2);
        Graph edge3 = new Graph(2, 7,3,3);
        Graph edge4 = new Graph(3, 9,4,4);
        Graph edge5 = new Graph(4, 10,5,5);
        Graph edge6 = new Graph(5, 2,6,6);
        Graph edge7 = new Graph(6, 1,7,7);
        Graph edge8 = new Graph(7, 7,8,8);
        Graph edge9 = new Graph(0, 8,7,9);
        Graph edge10 = new Graph(1, 1,7,10);
        Graph edge11 = new Graph(2, 2,8,11);
        Graph edge12 = new Graph(6, 4,8,12);
        Graph edge13 = new Graph(2, 4,5,13);
        Graph edge14 = new Graph(3, 14,5,14);
        List<Graph> edges=new ArrayList<Graph>(Arrays.asList(edge1,edge2,edge3,edge4,edge5,edge6,edge7,edge8,edge9,edge10,edge11,edge12,edge13,edge14));

        Collections.sort(edges, new Comparator<Graph>() {
            @Override
            public int compare(Graph o1, Graph o2) {
                if(null == o1.getWeight()) {
                    return -1;
                }
                if(null == o2.getWeight()) {
                    return 1;
                }
                return o1.getWeight().compareTo(o2.getWeight());

            }
        });
//        System.out.println(edges);
//        int[] id=new int[9];
//        for(int i=0;i<9;i++){
//            id[i]=-1;
//        }
        Kruskal(edges,uf);
    }
//    //获取节点a的根节点编号
//    public static int find_x_root(int[] id,int a){
//        int i,root,k;
//        root=a;
//        while((id[root]>0 || id[root]==0)  && (root>0 || root==0)){
//            root=id[root];
//        }
//        k=a;
//        while(k!=root){
//            i=id[k];
//            id[k]=root;
//            k=i;
//        }
//        return root;
//    }
    //判断顶点a和顶点b的根节点大小，根节点值越小，代表其对应树的节点越多，将节点少的树添加到节点多的树上
//    public static void union(int[] id,int a,int b){
//        int ida=find_x_root(id,a);  //得到顶点a的根节点
//        int idb=find_x_root(id,b);  //得到顶点b的根节点
//        int num=id[ida]+id[idb];
//        if(id[ida]<id[idb]){
//            id[idb]=ida;    //将顶点b作为顶点a根节点的直接子节点
//            id[ida]=num;    //更新根节点的id值
//        }else{
//            id[idb]=idb;
//            id[ida]=num;
//        }
//    }
    public static void Kruskal(List<Graph> edges,UF uf){
        int min_weight=0;
        //        for(Graph edge:edges){
        //            System.out.println(edge.toString());
        //        }
        for(int i=0;i<14;i++){

//            int ida=find_x_root(id,edges.get(i).getStart());
//            int idb=find_x_root(id,edges.get(i).getEnd());
//            if(ida!=idb){
//                System.out.println("选择边"+edges.get(i).getNum());
//                union(id,edges.get(i).getStart(),edges.get(i).getEnd());
//
//            }
            int ida= uf.find(edges.get(i).getStart());
            int idb= uf.find(edges.get(i).getEnd());
            if(ida!=idb){
                System.out.println("选择边"+edges.get(i).getNum());
                min_weight=min_weight+edges.get(i).getWeight();
                uf.union(edges.get(i).getStart(),edges.get(i).getEnd());
                if(uf.count()==1){
                    break;
                }
            }
        }
        System.out.println("最小生成树权重为"+min_weight);
    }


}
