package fun.peri.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {

    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName("localhost");
        int port = 3333;
        byte[] data = "用户名：root；密码：root".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
        DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.send(packet);
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        datagramSocket.receive(receivePacket);
        String line = new String(receiveData, 0, receiveData.length);
        System.out.println("我是客户端，服务器端发送的数据是：" + line);
        datagramSocket.close();
    }
}
