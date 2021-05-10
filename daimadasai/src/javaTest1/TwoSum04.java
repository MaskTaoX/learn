package javaTest1;

/**
 * 已经排列好的整数数组numstr 找出指定和为target的两个数的下标
 * 二分查找
 */
public class TwoSum04 {
    public static void main(String[] args) {
        int[] numStr= {3,5,7,8,11};
        int target = 16;
        int [] res= sumTwo(numStr,target);
        System.out.println("["+res[0]+","+res[1]+"]");

    }

    public static int[] sumTwo(int[] numStr,int target){
        for(int i = 0; i < numStr.length; i++){
            int anotherNum = target-numStr[i];
            if(anotherNum<=numStr[i]){
                //优化
                throw new IllegalArgumentException("no such nums");//不合法的参数异常
            }
            int anotherNumPosition = binarySearch(numStr,anotherNum);
            if(anotherNumPosition>=0){
                return new int[]{i,anotherNumPosition};
            }
        }
        throw new IllegalArgumentException("no such nums");//不合法的参数异常
    }

    public static int binarySearch(int[] numStr,int anotherNum){
        int left=0;
        int right=numStr.length-1;
        int mid=0;
        while(left<=right){
            mid = (left+right)/2;
            //mid = left + (right-left)/2;
            if(anotherNum>numStr[mid]){
                left=mid+1;
            }else if(anotherNum<numStr[mid]){
                right=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
