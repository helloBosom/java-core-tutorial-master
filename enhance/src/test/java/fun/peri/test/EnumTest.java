package fun.peri.test;

import fun.peri.myenum.WeekDay;
import org.junit.Test;

import java.util.Arrays;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-11 21:31
 */


public class EnumTest {

    @Test
    public void test(){
        WeekDay weekDay = WeekDay.TUESDAY;
        WeekDay nextDay = weekDay.nextDay();
        System.out.println(weekDay);
        System.out.println(nextDay);

        WeekDay weekDay1 = WeekDay.valueOf("FRIDAY");
        System.out.println(weekDay1);
        System.out.println(weekDay1.name());
        System.out.println(weekDay1.ordinal());
        System.out.println(weekDay1.day());

        WeekDay[] weekDays = WeekDay.values();
        System.out.println(Arrays.toString(weekDays));
    }
}
