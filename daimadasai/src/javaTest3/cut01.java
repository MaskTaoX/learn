package javaTest3;

/**
 * 给定一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],…,k[m]。请问k[0]* k[1] * … *k[m]可能的最大乘积是多少？
 */
public class cut01 {
    //将绳子尽可能多取长度3的绳子
    //math.pow 底数 幂
    public int maxCut(int length){
        if(length < 2) return 0;
        if(length == 2) return 1;
        if(length == 3) return 2;

        int num1 = length/3;//能剪出几个3米
        //当最后剩下的是4时 不能再减去长度为3的绳子段 2*2》3*1
        if(length - num1*3==1)//最后剩下的是4
            num1-=1;//3的个数少一个
        //剪完全部3还剩几个2
        int num2 = (length - num1*3)/2;
        return (int) (Math.pow(3,num1)*Math.pow(2,num2));
    }
    //递归
    public  static  int maxCut1(int length){
        if(length < 2) return 0;
        if(length == 2) return 2;
        if(length == 3) return 3;
        if(length == 4) return 4;
        return 3*maxCut1(length-3);
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(maxCut1(n));
    }


}
