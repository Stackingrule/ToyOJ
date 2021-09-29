package interview;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

/**
 * @Title: FileDemo
 * @Package: interview
 * @description:
 * @author: Stackingrule
 * @created: 2021/09/11 23:04
 * @Copyright: Copyright (c) 2020
 * @version: v1.0
 */
public class FileDemo {

    public static void main(String[] args) throws IOException {

        Reader reader = new Reader() {
            @Override
            public int read(char[] cbuf, int off, int len) throws IOException {
                return 0;
            }

            @Override
            public void close() throws IOException {

            }
        };
        File file;
        file = new File("d://text.txt");
        boolean ret = file.createNewFile();

        System.out.println(file.exists());
        System.out.println(file.length());
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
    }
}
