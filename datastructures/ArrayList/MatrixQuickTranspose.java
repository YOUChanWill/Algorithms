package ArrayList;

import java.util.Scanner;

public class MatrixQuickTranspose {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入矩阵的行数，列数，非零元的个数：");
        int mu,nu,tu;
        mu = scan.nextInt();
        nu = scan.nextInt();
        tu = scan.nextInt();
        Mat M1 = new Mat(mu,nu,tu);
        Mat M2 = new Mat(nu,mu,tu);
        System.out.println("输入矩阵的三元组：");
        for(int i=1; i<=tu; i++){
            M1.data[i].row = scan.nextInt();
            M1.data[i].col = scan.nextInt();
            M1.data[i].v = scan.nextInt();
        }
        System.out.println("输入的矩阵为：");
        M1.display();

        //增加两个向量
        int num[] = new int[nu+1];//M1中第col列中非零元的个数
        for(int col=1; col<=nu; col++){
            num[col] = 0;
        }
        for(int t=1; t<=tu; t++){
            num[M1.data[t].col]++;
        }
        int cpot[] = new int[nu+1];//M1中第col列的第一个非零元在M2.data中的位置。
        cpot[1] = 1;
        for(int col=2; col<=nu; col++){
            cpot[col] = cpot[col - 1] + num[col - 1];
        }
        int p,q;//实现快速转置
        for(p=1; p<=tu; p++){
            int col = M1.data[p].col;
            q = cpot[col];
            M2.data[q].row = M1.data[p].col;
            M2.data[q].col = M1.data[p].row;
            M2.data[q].v = M1.data[p].v;
            cpot[col]++;
        }
        System.out.println("转置后的矩阵为：");
        M2.display();
    }

}

// 定义矩阵
class Mat {
    final int MAXSIZE = 10;
    int mu,nu,tu;
    Triple<Integer> data[] = new Triple[MAXSIZE + 1];//Java不支持泛型数组
    public Mat(int mu,int nu,int tu){
        this.mu = mu;
        this.nu = nu;
        this.tu = tu;
        for(int i=1; i<=MAXSIZE; i++)
            data[i] = new Triple();
    }
    // 矩阵的打印
    public void display(){
        int i,j,k,count = 0;
        for(i=1; i<=mu; i++){
            for(j=1; j<=nu; j++){
                for(k=1; k<=tu; k++){
                    if(i==data[k].row && j==data[k].col){
                        System.out.print(data[k].v + " ");
                        count = -1;
                        break;
                    }
                }
                if(count != -1)
                    System.out.print("0 ");
                count = 0;
            }
            System.out.println();
        }
    }

}
// 定义三元组
class Triple<T> {
    int row,col; // 横坐标、纵坐标
    T v; // 值
    public Triple(){}
    public Triple(int row,int col, T v){
        this.row = row;
        this.col = col;
        this.v = v;
    }
}
