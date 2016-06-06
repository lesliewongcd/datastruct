package leslie.sort;

import leslie.util.Debug;

/**
 * Created by Leslie on 6/3/16.
 */
public class QuickSort {


    public static void sort(int[] array, int left, int right) {

        if (left >= right) {
            return;
        }

        int key = array[left];
        int l = left;
        int r = right;
        while (l < r) {

            /**
             * 先从右查找比key小的值
             */
            while (l < r && array[r] > key) {
                r--;
            }
            if (l < r) {
                array[l++] = array[r];
            }
            Debug.print("-r(" + l + ":" + r + ")  ", array);

            /**
             * 再从左查找比key大的值
             */
            while (l < r && array[l] < key) {
                l++;
            }
            if (l < r) {
                array[r--] = array[l];
            }
            Debug.print("-l(" + l + ":" + r + ")  ", array);
        }

        array[l] = key;

        Debug.print("----", array);

        sort(array, left, l - 1);
        sort(array, l + 1, right);
    }


}
