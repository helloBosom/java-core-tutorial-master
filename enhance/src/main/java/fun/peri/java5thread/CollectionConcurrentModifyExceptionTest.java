package fun.peri.java5thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionConcurrentModifyExceptionTest {

    public static void main(String... args) {
        Collection<String> coll = new ArrayList<String>();
        coll.add("llll");
        coll.add("oooo");
        coll.add("hhhh");
        coll.add("cccc");

        Iterator<String> iter = coll.iterator();
        while (iter.hasNext()) {
            String val = iter.next();
            if ("hhhh".equals(val))
                System.out.println(val);
            coll.remove(val);
            // java.util.ConcurrentModificationException
        }
    }

    @Test
    public void concurrentCollectionTest() {
        Collection<String> coll = new CopyOnWriteArrayList<>();
        coll.add("llll");
        coll.add("oooo");
        coll.add("hhhh");
        coll.add("cccc");

        Iterator<String> iter = coll.iterator();
        while (iter.hasNext()) {
            String val = iter.next();
            if ("hhhh".equals(val))
                coll.remove(val);
            System.out.println(val);
        }
    }
}
