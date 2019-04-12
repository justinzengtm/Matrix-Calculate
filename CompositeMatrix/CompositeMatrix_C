#include <stdio.h>
#include <stdlib.h>

//自定义矩阵大小 
#define X 3 
#define Y 3

typedef struct matrixStructure *MatrixStructure;
struct matrixStructure {
	float arr_1[X][Y]; //X行Y列的矩阵 
	float arr_2[Y][X]; //Y行X列的矩阵 
	float resultMatrix[X][Y]; //结果矩阵存放合成后的矩阵
};

//函数声明
float minNum(float x, float y); //求两者较小值
float maxNum(float x, float y); //求两者较大值
void compositeMatrix(MatrixStructure matrix); //矩阵合成函数

//主函数
int main(int argc, char const* argv[]) {
	
	int i, j;

	MatrixStructure matrix;
	matrix = (MatrixStructure)malloc(sizeof(struct matrixStructure)); //分配内存
	//初始化结果矩阵 
	for(i=0; i<X; i++) {
		for(j=0; j<Y; j++) {
			matrix->resultMatrix[i][j]=0;
		}
	} 
	
	//建立两个矩阵 
	printf("请输入矩阵arr_1:\n");
	for(i=0; i<X; i++) {
		for(j=0; j<Y; j++) {
			scanf("%f", &matrix->arr_1[i][j]);
		}
	}  
	
	printf("请输入矩阵arr_2:\n");
	for(i=0; i<Y; i++) {
		for(j=0; j<X; j++) {
			scanf("%f", &matrix->arr_2[i][j]);
		}
	}
	
	//建立完两个矩阵后,输出矩阵
	printf("\n矩阵arr_1为\n"); 
	for(i=0; i<X; i++) {
		for(j=0; j<Y; j++) {
			printf("%.2f\t", matrix->arr_1[i][j]);
		}
		printf("\n"); //换行 
	}  
	
	printf("矩阵arr_2为\n");
	for(i=0; i<Y; i++) {
		for(j=0; j<X; j++) {
			printf("%.2f\t", matrix->arr_2[j][i]);
		}
		printf("\n"); //换行 
	}  
	printf("\n"); //美观用的换行符
	 
	compositeMatrix(matrix); //矩阵合成 
	
	//输出合成后的矩阵
	printf("合成后矩阵为:\n");
	for(i=0; i<X; i++) {
		for(j=0; j<X; j++) {
			printf("%.2f\t", matrix->resultMatrix[i][j]);
		}
		printf("\n"); //换行 
	} 
	
	return 0;
} 

//求两者较小值函数
float minNum(float x, float y) 
{
	if(x>y) {
		return y;
	} else if(x<y) {
		return x;
	} else {
		return x;
	}
}

//求两者较大值函数
float maxNum(float x, float y) 
{
	if(x>y) {
		return x;
	} else if(x<y) {
		return y;
	} else {
		return x;
	}
}

//矩阵合成函数 
void compositeMatrix(MatrixStructure matrix) 
{
	int i, j, k, h;
	float tmp;
	
	//定义一个存放临时结果的矩阵
	float tempMatrix[Y]; 
	
	//合成矩阵  i是矩阵arr_1的行标识,j是矩阵arr_2的列标识 
	for(i=0; i<X; i++) {
		for(j=0; j<X; j++) {
			for(k=0; k<Y; k++) {
				//k表示当前行当前列的第几个值 
				tempMatrix[k] = minNum(matrix->arr_1[i][k], matrix->arr_2[j][k]); //存放临时较小值 
				printf("矩阵arr_1的第%d行的第%d个值%.2f与矩阵arr_2的第%d列的第%d个值%.2f比较.", i, k, matrix->arr_1[i][k], j, k,matrix->arr_2[j][k]);
				printf("较小的值为:%.2f\n", tempMatrix[k]);
			}
				
			//然后取较大值,并存入结果矩阵中 
			for(h=0; h<Y; h++) {
				//逐一比较临时矩阵中的几个较小值,找出最大值 
				tmp = maxNum(tempMatrix[h], tempMatrix[h+1]);
				//如果往后的比较中找到更大值,就更新矩阵
				matrix->resultMatrix[i][j] = maxNum(tmp, matrix->resultMatrix[i][j]);  
			} 	 	
			printf("最大值为%.2f\n\n", matrix->resultMatrix[i][j]);
		}
	}
	return;
}
