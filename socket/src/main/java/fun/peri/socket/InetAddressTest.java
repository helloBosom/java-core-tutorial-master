package fun.peri.socket;

import java.net.*;
import java.util.Enumeration;

/**
 * InetAddresss,
 * NetworkInterface
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaceList = NetworkInterface.getNetworkInterfaces();
            if (interfaceList == null) {
                System.out.println("--No interfaces found--");
            } else {
                while (interfaceList.hasMoreElements()) {
                    NetworkInterface anInterface = interfaceList.nextElement();
                    System.out.println("Interface " + anInterface.getName() + ":");
                    Enumeration<InetAddress> addressList = anInterface.getInetAddresses();
                    if (!addressList.hasMoreElements())
                        System.out.println("\t(No addresses for this interface)");
                    while (addressList.hasMoreElements()) {
                        InetAddress address = addressList.nextElement();
                        System.out.print("\tAddress " +
                                ((address instanceof Inet4Address ? "(v4)" : (address instanceof Inet6Address ? "(v6)" : "(?)")))
                        );
                        System.out.println(": " + address.getHostAddress());
                    }
                }
            }
        } catch (SocketException except) {
            System.out.println("Error getting network interfaces : " + except.getMessage());
            System.out.println("Error getting network interfaces : " + except.getMessage());
        }
        for (String host : args) {
            try {
                System.out.println(host + ":");
                InetAddress[] addressList = InetAddress.getAllByName(host);
                for (InetAddress address : addressList) {
                    System.out.println("\t" + address.getHostName() + "/" + address.getHostAddress());
                }
            } catch (UnknownHostException e) {
                System.out.println("\tUnable to find address for " + host);
            }
        }
    }
}