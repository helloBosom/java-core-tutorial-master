package fun.peri.tcp;

import java.io.*;
import java.net.Socket;

public class TcpClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1024);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(outputStream);  // 将输入流包装为打印流
            pw.write("用户名：root；密码：root");
            pw.flush();
            socket.shutdownOutput();
            InputStream ips = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(ips));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("我是客户端，服务器端想我发来信息：" + line);
            }
            br.close();
            ips.close();
            pw.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}