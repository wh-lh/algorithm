public class UF {
    //记录节点元素和该元素所在分组的标识
    private int[] eleAndGroup;
    //记录并查集中数据的分组个数
    private int count;
    //初始化并查集
    public UF(int N){
        //初始化分组的数量，默认情况下有n个分组
        this.count=N;
        //初始化eleAndGroup数组
        this.eleAndGroup=new int[N];
        //初始化eleAndGroup中的元素及其所在的组的标识符
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i]=i;
        }

    }
    //获取当前并查集中的数据有多少个分组
    public int count(){
        return count;
    }
    //元素p所在分组的标识符
    public int find(int p){
        return eleAndGroup[p];
    }
    //判断并查集中元素p和元素q是否在同一分组中
    public boolean connected(int p,int q){
        return find(p)==find(q);
    }
    //把p元素所在分组和q元素所在分组合并
    public void union(int p,int q){
        //判断元素q和p是否已经在同一分组中
        if(connected(p,q)){
            return;
        }
        //找到p分组的标识符
        int pgroup=find(p);
        //找到q分组的标识符
        int qgroup=find(q);
        //合并组：
        for (int i = 0; i < eleAndGroup.length; i++) {
            if (eleAndGroup[i] == pgroup) {
                eleAndGroup[i] = qgroup;
            }
        }
        //分组个数-1
        this.count--;
    }


}
