package countingtexthandler;

/**
 *
 * @author Anwar
 */
/*x CountingTextHandler.1 */
public class CountingTextHandler {
    public static void main(String[] args) {
        /*x CountingTextHandler.2 */
        CountText handler= new CountText();
        handler.handle("hello world");
        handler.handle("goodbye");
        /*x*/
        System.out.println(handler);
    }
}