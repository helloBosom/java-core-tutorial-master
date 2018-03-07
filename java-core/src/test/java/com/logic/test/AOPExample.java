package com.logic.test;

import com.logic.dao.DAOInvocationHandler;
import com.logic.dao.StudentDAO;
import com.logic.factory.DaoProxyFactory;
import com.logic.model.Student;
import com.logic.service.DAO;
import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-27 21:36
 */

public class AOPExample {
    @Test
    public void testProxy() {
        StudentDAO<Student> target = new StudentDAO<Student>();
        DAO targetProxy = (DAO) DaoProxyFactory.getProxyObject(target);  // 只能转换为接口类型
        targetProxy.save(new Student());
        System.out.println();
        targetProxy.remove("001");
    }


    @Test
    public void testProxy02() {
        StudentDAO<Student> target = new StudentDAO<>();
        DAO proxyInstance = (DAO) new DAOInvocationHandler(target).getProxy();
        proxyInstance.save(new Student());
        System.out.println();
        proxyInstance.remove("0001");
    }

}
