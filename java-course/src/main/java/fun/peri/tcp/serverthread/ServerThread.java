package fun.peri.tcp.serverthread;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ServerThread extends Thread {
    private Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        InputStream ips = null;
        BufferedReader br = null;
        OutputStream ops = null;
        PrintWriter pw = null;
        try {
            ips = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(ips));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("我是服务器端，接收到客户端发送的消息：" + line);
            }
            InetAddress inetAddress = socket.getInetAddress();
            System.out.println("客户端的ip是 " + inetAddress);
            socket.shutdownInput();
            ops = socket.getOutputStream();
            pw = new PrintWriter(ops);
            pw.write("欢迎登录服务器端！");
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ips != null) ips.close();
                if (br != null) br.close();
                if (ops != null) ops.close();
                if (pw != null) pw.close();
                socket.close();
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }
}
