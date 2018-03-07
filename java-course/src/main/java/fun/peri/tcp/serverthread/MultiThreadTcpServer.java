package fun.peri.tcp.serverthread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadTcpServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1438);
            System.out.println("启动服务器....");
            int counter = 0;
            while (true) {
                Socket socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                counter++;
                System.out.println("登录客户端的数量是：" + counter);
                if (counter == 3) {
                    break;
                }
            }
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
