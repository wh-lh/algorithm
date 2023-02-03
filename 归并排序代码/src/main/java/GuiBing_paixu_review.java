public class GuiBing_paixu_review {
    public static void main(String[] args) {
        int []arr={8,1,9,3,2,4,5,1,6};
        int []tmp=new int [arr.length];   //新建一个数组临时存放
        mergeSort(arr,0,arr.length-1,tmp);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]+"  ");

        }

    }
    public static  void merge(int[] arr,int low,int mid,int high,int[] tmp){
        int i=0;
        int j=low,k=mid+1;  //定义两个指针
        while(j<=mid && k<=high){
            if(arr[j]<arr[k]){
                tmp[i++]=arr[j++];
            }else{
                tmp[i++]=arr[k++];
            }
        }
        //若左边序列还有剩余，则将其全部拷贝在tmp[]中
        while(j<=mid){
            tmp[i++]=arr[j++];

        }
        while(k<=high){
            tmp[i++]=arr[k++];

        }
        for(int t=0;t<i;t++){
            arr[low+t]=tmp[t];
        }
    }
    public static void mergeSort(int[] arr,int low,int high,int[] tmp){
        if(low<high){
            int mid=(low+high)/2;
            mergeSort(arr,low,mid,tmp);    //对左边序列进行排序
            mergeSort(arr,mid+1,high,tmp);   //对右边序列进行排序
            merge(arr,low,mid,high,tmp);    //合并两个有序序列


        }
    }

}
