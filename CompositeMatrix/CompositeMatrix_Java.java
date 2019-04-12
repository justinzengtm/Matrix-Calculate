package compositematrix;

import java.util.Scanner;

public class CompositeMatrixDemo {
	
	//定义矩阵大小
	public int X = 3;
	public int Y = 3;
	
	//实例化两个矩阵
	double [][] arr_1 = new double[X][Y];
	double [][] arr_2 = new double[Y][X];
	//实例化一个存放临时数据的数组
	double [] tempMatrix = new double[10];
	//实例化一个存放结果矩阵,为合成后的矩阵
	double [][] resultMatrix = new double[X][Y];
	
	//求两者较小值方法
	public double minNum(double x, double y) {
		if(x>y) {
			return y;
		} else if(x<y) {
			return x;
		} else {
			return x;
		}
	}
	
	//求两者较大值方法
	public double maxNum(double x, double y) {
		if(x>y) {
			return x;
		} else if(x<y) {
			return y;
		} else {
			return x;
		}
	}
	
	public static void main(String[] args) {
		
		CompositeMatrixDemo matrix = new CompositeMatrixDemo();
		int X = matrix.X;
		int Y = matrix.Y;
		Scanner in = new Scanner(System.in);
		
		//初始化结果矩阵resultMatrix
		for(int i=0; i<X; i++) {
			for(int j=0; j<Y; j++) {
				matrix.resultMatrix[i][j] = 0;
			}
		}
		
		//创建两个矩阵
		System.out.println("请输入矩阵arr_1：");
		for(int i=0; i<X; i++) {
			for(int j=0; j<X; j++) {
				matrix.arr_1[i][j] = in.nextDouble();
			}
		}
		System.out.println("请输入矩阵arr_2：");
		for(int i=0; i<Y; i++) {
			for(int j=0; j<X; j++) {
				matrix.arr_2[i][j] = in.nextDouble();
			}
		}
		
		//输出两个矩阵
		System.out.println("矩阵arr_1为：");
		for(int i=0; i<X; i++) {
			for(int j=0; j<Y; j++) {
				System.out.print(String.format("%.2f ", matrix.arr_1[i][j]));
			}
			System.out.print("\r\n");
		}
		System.out.println("矩阵arr_2为：");
		for(int i=0; i<X; i++) {
			for(int j=0; j<Y; j++) {
				System.out.print(String.format("%.2f ", matrix.arr_2[i][j]));
			}
			System.out.print("\r\n");
		}

		double tmp; //存放临时结果值
		//矩阵合成
		for(int i=0; i<X; i++) {
			for(int j=0; j<Y; j++) {
				for(int k=0; k<X; k++) {
					matrix.tempMatrix[k] = matrix.minNum(matrix.arr_1[i][k], matrix.arr_2[j][k]);
					System.out.print("arr_1的第"+X+"行的第"+k+"个值"+String.format("%.2f", matrix.arr_1[i][k])+"与arr_2的第");
					System.out.print(k+"个值"+String.format("%.2f", matrix.arr_2[j][k])+"比较");
					System.out.println("较小值为"+String.format("%.2f",matrix.tempMatrix[k]));
				}
				
				//然后从这几个较小值中取最大值,并存入结果矩阵中
				for(int h=0; h<=Y; h++) {
					//逐一比较临时矩阵中的几个较小值,每次找到更小的就更新
					tmp = matrix.maxNum(matrix.tempMatrix[h], matrix.tempMatrix[h+1]);
					matrix.resultMatrix[i][j] = matrix.maxNum(tmp, matrix.resultMatrix[i][j]);
				}
				System.out.println("最大值为"+String.format("%.2f", matrix.resultMatrix[i][j]));
			}
		}
		
		System.out.print("\r\n"); //美观用的换行符
		//完成矩阵合成后,输出结果矩阵
		System.out.println("合成后结果矩阵为：");
		for(int i=0; i<X; i++) {
			for(int j=0; j<X; j++) {
				System.out.print(String.format("%.2f ", matrix.resultMatrix[i][j]));
			}
			System.out.print("\r\n");
		}
		in.close();
	}

}
