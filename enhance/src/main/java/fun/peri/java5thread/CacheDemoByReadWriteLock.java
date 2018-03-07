package fun.peri.java5thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDemoByReadWriteLock {

    private Map<String, Object> cache = new HashMap<>();

    private ReadWriteLock rwlock = new ReentrantReadWriteLock();

    public synchronized Object getData1(String key) {
        Object value = cache.get(key);
        if (value == null) {
            value = "get data from db";  // 从数据库中查询数据并放在缓存中
        }
        return value;
    }

    public Object getData2(String key) {
        Object value;
        rwlock.readLock().lock();
        try {
            value = cache.get(key);
            if (value == null) {
                rwlock.readLock().unlock();
                rwlock.writeLock().lock();  // 锁后面紧跟try...finally代码块
                try {
                    if (value == null) {   // 第一个写锁执行完之后，其他的写锁不会再执行查询操作
                        value = "get data from db";  // 从数据库中查询数据并放在缓存中
                    }
                } finally {
                    rwlock.writeLock().unlock();
                }
                rwlock.readLock().lock();  // 为了保证后面的finally中的readLock()处于锁住的状态
            }
        } finally {
            rwlock.readLock().unlock();
        }
        return value;
    }
}


