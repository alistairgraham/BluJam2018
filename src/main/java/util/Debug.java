package util;

/**
 * A utility class for handling debugging
 */
public class Debug {
    private static final boolean TO_CONSOLE = true;

    public static void log(String information){
        if(TO_CONSOLE) System.out.println(information);
    }
}
