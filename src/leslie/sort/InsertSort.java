package leslie.sort;

import leslie.util.Debug;

/**
 * Created by Leslie on 6/5/16.
 */
public class InsertSort {


    /**
     * @param array
     */

    public static void sort(int[] array) {

        final int len = array.length;

        int target;
        int j;
        for (int i = 1; i < len; i++) {

            j = i;
            target = array[i];

            while (j > 0 && target < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = target;
            Debug.print("--", array);
        }


        Debug.print("insert : ", array);
    }
}
