package leslie.util;

/**
 * Created by Leslie on 6/5/16.
 */
public class Util {


    public static void swap(int[] array, int x, int y) {

        if (array == null) {
            return;
        }

        if (array.length < 2) {
            return;
        }

        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;

    }

}
