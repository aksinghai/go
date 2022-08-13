package all.company.com.GoogleAToZ;

import java.util.ArrayList;
import java.util.List;

//Incomplete
public class Q2_FindKClosest {
    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1,2,3,4,5}, 4, -1));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int ind = findIndex(arr, 0, arr.length-1, x);
        int i;
        int j;
        int c = 0;
        if(ind >= 0 && ind < arr.length && arr[ind] == x){
            i = ind;
            j = ind;
        } else {
            i = Math.max(ind-1, 0);
            j = Math.min(ind, arr.length-1);
        }
        List<Integer> list = new ArrayList<>();
        while(c <= k){
            if(i >= 0 && j < arr.length && Math.abs(arr[i]-x) <= Math.abs(arr[j]-x)){
                i--;
            } else if(i >= 0 && j < arr.length && Math.abs(arr[i]-x) >= Math.abs(arr[j]-x)){
                j++;
            } else if(j < arr.length) {
                j++;
            } else if(i >= 0){
                i--;
            }
            c++;
        }
        for(i = i+1; i < j ; i++){
            list.add(arr[i]);
        }
        return list;
    }


    private static int findIndex(int[] arr, int l, int h, int x){
        if(h <= l && arr[l] != x){
            if(arr[l] > x){
                return  l - 1;
            } else {
                return l + 1;
            }
        }
        int m = (l+((h-l)/2));
        if(arr[m] == x){
            return m;
        } else if (arr[m] < x) {
            return findIndex(arr, m+1, h, x);
        } else {
            return findIndex(arr, l, m-1, x);
        }
    }
}
