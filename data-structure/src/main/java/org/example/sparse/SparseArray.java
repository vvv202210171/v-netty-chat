package org.example.sparse;

public class SparseArray {
    public static void main(String[] args) {
        int[][] chessArr=new int[11][11];
        chessArr[0][1]=1;
        chessArr[2][1]=2;
        chessArr[10][10]=2;
        int sum=0;
        for (int[] ints : chessArr) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
                if(anInt!=0){
                    sum++;
                }
            }
            System.out.println();
        }
        int[][] sparseArr=new int[sum+1][3];
        sparseArr[0][0]=chessArr.length;
        sparseArr[0][1]=chessArr[0].length;
        sparseArr[0][2]=sum;
        int count=0;

        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if(chessArr[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr[i][j];
                }
            }
        }

        System.out.println("===========show sparse==============");
        for (int[] sparse : sparseArr) {
            for (int s : sparse) {
                System.out.printf("%d\t",s);
            }
            System.out.println();
        }

        //1.初始化数组
        //2.遍历稀疏数组
        System.out.println("=========show restore================");
        int[][] restoreArr=new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            int[] ints=sparseArr[i];
            restoreArr[ints[0]][ints[1]]=ints[2];
        }
        for (int[] ints : restoreArr) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
                if(anInt!=0){
                    sum++;
                }
            }
            System.out.println();
        }

    }
}
