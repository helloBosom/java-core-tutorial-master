package fun.peri.socket;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    @Test
    public void test() {
        try {
            InetAddress address = InetAddress.getByName("www.baidu.com");
            System.out.println(address);
            System.out.println("address.getHostAddress() = " + address.getHostAddress());
            address = InetAddress.getByAddress(address.getAddress());
            System.out.println(address);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
