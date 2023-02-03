public class quick_paixu {
    public static void main(String[] args) {
        int[] A={2,6,7,1,3,5,6,4};
        QuickSort(A,0,A.length-1);
        for(int i=0;i<A.length;i++){
            System.out.println(A[i]);
        }


    }


    public static int Partition(int[] A,int p,int r){    //p为起始位置   r为终点位置
        int i=p-1;
        int x=A[r];
        for(int j=p;j<r;j++){
            if(A[j]<x){
                int pro=A[i+1];
                A[i+1]=A[j];
                A[j]=pro;
                i=i+1;
            }
        }
        int pro2=A[i+1];
        A[i+1]=A[r];
        A[r]=pro2;
        int q=i+1;
        //返回数组划分的分界线q
        return q;
    }

    public static void QuickSort(int[] A,int p,int r){
        if(p<r){
            int q=Partition(A,p,r);
            QuickSort(A,p,q-1);
            QuickSort(A,q+1,r);
        }
    };

}
