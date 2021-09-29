package obj;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @Title: QuickSort
 * @Package: obj
 * @description:
 * @author: Stackingrule
 * @created: 2021/09/26 16:33
 * @Copyright: Copyright (c) 2020
 * @version: v1.0
 */
public class QuickSort {



    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;

        int i = lo - 1, j = hi + 1;
        int x = arr[(lo + hi) / 2];

        while (i < j) {
            do i++; while (arr[i] < x);
            do j--; while (arr[j] > x);

            if (i < j) swap(arr, i, j);
        }

        quickSort(arr, lo, j);
        quickSort(arr, j + 1, hi);
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {2, 5, 1, 7, 9, 0};
        int[] arr2 = new int[] {2};
        int[] arr3 = new int[] {};
        int[] arr4 = new int[] {10, 9, 8,7, 6, 5, 4, 3, 2 , 1, 0};
        int[] arr5 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        quickSort(arr1, 0, 5);
        quickSort(arr2, 0, 0);
        //quickSort(arr3, 0, 5);
        quickSort(arr4, 0, 10);
        System.out.println();
        for (int a : arr1){
            System.out.print(a + " ");
        }
        System.out.println("");

        for (int a : arr2){
            System.out.print(a + " ");
        }
        System.out.println("");
//        for (int a : arr3){
//            System.out.print(a + " ");
//        }
        for (int a : arr4){
            System.out.print(a + " ");
        }
        System.out.println("");
        for (int a : arr5){
            System.out.print(a + " ");
        }

        ConcurrentSkipListMap<String, Integer> m = new ConcurrentSkipListMap<>();

    }
}
