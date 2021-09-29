package interview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Title: IODemo
 * @Package: interview
 * @description:
 * @author: Stackingrule
 * @created: 2021/09/12 09:20
 * @Copyright: Copyright (c) 2020
 * @version: v1.0
 */
public class IODemo {

    public static void main(String[] args) {
        copyFile("d://text.txt", "d://copy.txt");
    }

    public static void copyFile(String srcFilePath, String desFilePath)  {
        try (
            FileInputStream fileInputStream = new FileInputStream(srcFilePath);
            FileOutputStream outputStream = new FileOutputStream(desFilePath);
        ) {
          byte[] bytes = new byte[128];
          int len = 0;  // 实际读取字节数
            while ((len = fileInputStream.read(bytes, 0,128)) > 0) {
                outputStream.write(bytes, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
