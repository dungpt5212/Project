/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Antsoft
 */
public class Matrix2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Tạo thư mục
//    File d = new File("D:\\Test\\javacore");
//    if (!d.exists())
//    	d.mkdir();

        //Tạo mới và viết nội dung vào file
//     try {
//        Formatter f = new Formatter("C:\\xuanthulab.net\\test.txt");
//        f.format("Đây là file Vidu\r\n", null);
//        f.format("%s %s %s", "1","John", "Smith \r\n");
//        f.format("%s %s %s", "2","Amy", "Brown");
//
//	    f.close();
//
//	} catch (FileNotFoundException e) {
//	    System.out.println("Error");
//	}
        //Đọc nội dung file
        try {
            Read r = new Read();
            File x = new File("D:\\Test\\javacore\\input.txt");
            Scanner sc = new Scanner(x);
            String content = "";
            while (sc.hasNextLine()) {
                content += sc.nextLine() + "\r\n";
            }
            
            int index = 0;
            r.run(content,index);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }

}
