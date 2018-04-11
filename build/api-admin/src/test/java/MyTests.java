import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class MyTests {

    private static final String YAY_IT_WORKS = "Yay it works";

    @Test
    public void test() {
        String str = YAY_IT_WORKS;
        assertEquals(YAY_IT_WORKS, str);
    }
}
