package leslie.util;

/**
 * Created by Leslie on 6/4/16.
 */
public class Debug {


    public static void print(String tag, int[] array) {

        System.out.print(tag);
        if (array != null) {
            for (int v : array
                    ) {
                System.out.print(v);
            }

        }
        System.out.println("");
    }
}
