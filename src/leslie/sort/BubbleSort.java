package leslie.sort;


import leslie.util.Debug;
import leslie.util.Util;

/**
 * Created by Leslie on 6/5/16.
 */
public class BubbleSort {

    public static void sort(int[] array) {


        final int len = array.length;


        for (int i = 0; i < len - 1; i++) {

            int j = i + 1;
            for (; j < len; j++) {

                if (array[i] > array[j]) {
                    Util.swap(array, i, j);
                    Debug.print("i:" + i + " j:" + j + ",", array);

                }

            }
        }

        Debug.print("bubble :", array);


    }

}
