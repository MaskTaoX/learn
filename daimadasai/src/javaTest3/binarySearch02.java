package javaTest3;

/**
 * 采用递归和非递归方式 在有序列表中查找18
 */
public class binarySearch02 {
    //非递归方式
    public int binarySearch(int[] arr , int key){
        int start =0;
        int mid = 0;
        int end = arr.length-1;
        while (start <= end){
            mid = (start+end)/2;
            if(key == arr[mid]){
                return mid;
            }else if(key > arr[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }
    //递归方法
    public int binarySearch1(int[] arr,int key,int start,int end){
        if(start>end) return -1;
        int mid =(start+end)/2;
        if(key > arr[mid]){
            return binarySearch1(arr,key,mid+1,end);
        }else if(key < arr[mid]){
            return binarySearch1(arr,key,start,mid-1);
        }else{
            return mid;
        }

    }
}
