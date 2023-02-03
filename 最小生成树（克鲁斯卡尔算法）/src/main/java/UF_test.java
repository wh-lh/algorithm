import java.util.Scanner;

public class UF_test {
    public static void main(String[] args) {
        UF uf=new UF(5);

        //从控制台录入两个要和合并的元素
        Scanner sc=new Scanner(System.in);

        while(true){
            System.out.println("第一个元素");
            int p=sc.nextInt();
            System.out.println("第二个元素");
            int q=sc.nextInt();
            if(uf.connected(p,q)){
                System.out.println("已在同一组");
                continue;
            }
            uf.union(p,q);
            System.out.println(uf.count()+"个分组");
        }
    }
}
