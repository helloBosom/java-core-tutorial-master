package fun.peri.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String... args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1024);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = buffer.readLine()) != null) {
                System.out.println("我是服务器端，客户端发来信息：" + line);
            }
            socket.shutdownInput();
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(outputStream);
            pw.write("欢迎你登录服务器。");
            pw.flush();
            pw.close();
            pw.close();
            outputStream.close();
            buffer.close();
            inputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}