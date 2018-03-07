package fun.peri.test;

import org.junit.Test;

public class Test20170925 {

    public void print(int[] arr, int index) {
        if (index >= 0) System.out.println(arr[index]);
        else return;
        print(arr, index - 1);
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5};
        print(arr, arr.length - 1);
    }
}
