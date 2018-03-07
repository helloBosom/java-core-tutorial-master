import com.logic.myenum.SeasonEnum;
import org.junit.Test;

import java.util.Arrays;

public class Test1 {
    @Test
    public void test() {
        char a = '\u0000';
        System.out.println(a);
        String[][] strs = {{"aaa"}, {"bbb"}};
        test("aaa", "bbb", "ccc");
        int x = 0;
        double y = 1 / 0.0;
        Integer X = Integer.valueOf("123");
        Integer Y = x;
        // String str = new String(1);
        for (SeasonEnum ele : SeasonEnum.values()) {
            System.out.println(ele);
        }
        System.out.println(SeasonEnum.SPRING.name());
        System.out.println(SeasonEnum.SPRING);


    }

    public void test(String... names) {
        System.out.println(Arrays.toString(names));
    }
}


