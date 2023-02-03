public class nixudui_count {
    public static void main(String[] args) {
//        int[] arr = {11,44,23,67,88,65,34,48,9,12};
//        int[] arr = {13,8,10,6,15,18,12,20,9,14,17,19};
        int[] arr = {4,6,8,3,5};
        int[] tmp = new int[arr.length];    //新建一个临时数组存放
        int c=0;
        c=mergeSort(arr,0,arr.length-1,tmp);
        System.out.println(c);
//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i]+" ");
//        }
    }

    public static int merge(int[] arr,int low,int mid,int high,int[] tmp){
        int cross=0;
        int i = 0;
        int j = low,k = mid+1;  //左边序列和右边序列起始索引
        while(j <= mid && k <= high){
            if(arr[j] < arr[k]){
                tmp[i] = arr[j];
                i=i+1;
                j=j+1;
            }else{
                tmp[i] = arr[k];
                i=i+1;
                cross=cross+mid-j+1;
                k=k+1;

            }
        }
        //若左边序列还有剩余，则将其全部拷贝进tmp[]中
        while(j <= mid){
            tmp[i++] = arr[j++];
        }

        while(k <= high){
            tmp[i++] = arr[k++];
        }

        for(int t=0;t<i;t++){
            arr[low+t] = tmp[t];
        }
        return cross;
    }

    public static int mergeSort(int[] arr,int low,int high,int[] tmp){
        if(low<high){
            int mid = (low+high)/2;
            int left=mergeSort(arr,low,mid,tmp); //对左边序列进行归并排序
            int right=mergeSort(arr,mid+1,high,tmp);  //对右边序列进行归并排序
            int cross=merge(arr,low,mid,high,tmp);    //合并两个有序序列
            return left+right+cross;
        }else{
            return 0;
        }
    }
}
