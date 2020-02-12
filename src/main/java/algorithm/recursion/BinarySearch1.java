package algorithm.recursion;

import java.util.Arrays;

//输入：已排序的数组，目标数字
//输出：
public class BinarySearch1 {
    public static void main(String[] args) {
        int[] array = {1,3,5,6,7,9,11,99};
        int target = 3;
        System.out.println(binarySearch2(array,target));
    }

    /**
     * @Author:Xiang Chen
     * @Description:
     * @Date:2019/9/1 17:03
     **/
    public static int binarySearch(int[] sortedArray, int target, int lowerLimit, int upperLimit){
        if(sortedArray.length == 0){
            return -1;
        }
        int middle = (lowerLimit + upperLimit)/2;
        if(target == sortedArray[middle]){
            return middle;
        }else if(target > sortedArray[middle]){
            return binarySearch(sortedArray,target,middle+1,sortedArray.length);
        }else if (target < sortedArray[middle]){
            return binarySearch(sortedArray,target, lowerLimit,middle-1);
        }
        return  -1;
    }

    /**
     * @Author Xiang Chen
     * @Description:
     * @Date: 2019/9/2 16:47
     **/
    public static int binarySearch2(int[] sortedArray, int target){
        if(sortedArray.length == 0){
            return -1;
        }
        int middle = sortedArray.length/2;
        if(target == sortedArray[middle]){
            return middle;
        }else if (target > sortedArray[middle]){
            int[] newArray = Arrays.copyOfRange(sortedArray,middle+1,sortedArray.length);
            return middle + 1 + binarySearch2(newArray, target);
        }else if (target < sortedArray[middle]){
            int[] newArray = Arrays.copyOfRange(sortedArray,0,middle+1);
            return binarySearch2(newArray, target);
        }
        return  -1;
    }
}
