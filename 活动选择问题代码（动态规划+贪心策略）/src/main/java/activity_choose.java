public class activity_choose {
    public static void main(String[] args) {
        int[] start_time={3,7,0,10,7,12,15,20,20,4};
        int[] end_time={10,12,15,17,22,22,25,28,30,35};
        int[] p=new int[start_time.length];
        int[] max_profit=new int[start_time.length+1];
        int[] record=new int[start_time.length+1];
        int[] weight={1,6,4,7,3,12,2,9,11,8};
        find_last_activity(start_time,end_time,p);
        choose_max(weight,max_profit,record,p);
        System.out.println("最大收益为"+max_profit[start_time.length]);
        recall(record,start_time.length,p);


    }
    public static void find_last_activity(int[] start_time,int[] end_time,int[] p){
        for(int i=0;i<start_time.length;i++){
            sort_activity(end_time,start_time[i],0, end_time.length-1,p,i);
        }
    }
    public static void sort_activity(int[] end_time,int target,int start,int end,int[] p,int i){
        int mid=(start+end)/2;
        if(start==end){
            if(target==end_time[start]){
                p[i]=start+1;
            }else{
                p[i]=start;
            }

        }else if(target>end_time[mid]){
            start=mid+1;
            sort_activity(end_time,target,start,end,p,i);
        }else if(target<end_time[mid] || target==end_time[mid]){
            end=mid;
            sort_activity(end_time,target,start,end,p,i);
        };
    }
    public static void choose_max(int[] weight,int[] max_profit,int[] record,int[] p){
        max_profit[0]=0;
        record[0]=0;
        for(int i=1;i<max_profit.length;i++){
            if(max_profit[p[i-1]]+weight[i-1]>max_profit[i-1]){
                max_profit[i]=max_profit[p[i-1]]+weight[i-1];
                record[i]=1;
            }else if(max_profit[p[i-1]]+weight[i-1]<max_profit[i-1] || max_profit[p[i-1]]+weight[i-1]==max_profit[i-1]){
                max_profit[i]=max_profit[i-1];
                record[i]=0;
            }
        }
    }
    public static void recall(int[] record,int i,int[] p){
        if(i==0){
            System.out.println("结束");
        }else if(record[i]==1){
            System.out.println("选择项目"+i);
            i=p[i-1];
            recall(record,i,p);
        }else if(record[i]==0){
            i=i-1;
            recall(record,i,p);
        }
    }

}


