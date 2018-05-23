package com.weige.io.test;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;
import java.io.InputStream;  
import java.io.OutputStream;

  
/**
 * 文件读写
 * @author yangyiwei
 *
 */
public class FileRead {  
  
    public static void main(String[] args) {  
        // 读取文件 
        File file = new File("E:" + File.separator + "weige.txt");  
        InputStream in = null; 
        try {  
            //获取文件输入流
            in = new FileInputStream(file);  
            //开辟临时空间
            byte[] data = new byte[in.available()];  
            //读取到临时空间
            in.read(data);      
            String s = new String(data);
            System.out.println("结果：" +new String( data));
            
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                // �ر�������  
                in.close();  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        } 
        
    }  
  
}  