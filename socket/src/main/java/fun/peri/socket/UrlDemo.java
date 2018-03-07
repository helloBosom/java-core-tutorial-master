package fun.peri.socket;

import org.junit.Test;

import java.io.*;
import java.net.URL;

public class UrlDemo {
    @Test
    public void test() {
        // String path = "http://www.baidu.com";
        //String path = "http://epm.ab.com/project/indexAction.action";
        //String path = "http://blog.csdn.net/liyazhou0215/article/details/77431561";
        //String path = "https://www.zhihu.com/question/41059945";
        String path = "https://wenku.baidu.com/view/59ecb2e7a6c30c2258019ed2.html";
        //String path = "https://docsend.com/view/4xdqkp6";
        InputStream in = null;
        try {
            URL url = new URL(path);
            in = url.openStream();
            BufferedInputStream buff = new BufferedInputStream(in);
            Reader reader = new InputStreamReader(buff);
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}