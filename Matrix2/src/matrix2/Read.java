/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix2;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Antsoft
 */
public class Read {
    int count = 0;
    public void run(String content, int index) {
        Write wr = new Write();
        
        content = content + "\n";
        String[] output = content.split("\\\r\n");
        ArrayList<String> arr = new ArrayList<String>();
        ArrayList<String> last_matrix = new ArrayList<String>();
        //Lấy ra maxtrix cuối cùng
        for (int i = output.length - 2; i > 0; i--) {
            if (output[i].length() == 0) {
                break;
            } else {
                last_matrix.add(output[i]);
            }
        }
        //Đảo ngược arraylist
        Collections.reverse(last_matrix);
        //Lấy từ ma trận đầu tiên
        for (int i = index; i < output.length - 1; i++) {
            if (output[i].length() == 0) {
                index = i;
                break;
            } else {
                arr.add(output[i]);
            }
        }
        //So sánh ma trận cắt được với ma trận cuối cùng
        if (arr.equals(last_matrix)) {
            if (count == 0) {
                //Gặp ma trận cuối cùng lần 1 + count lên
                count++;
                //Nếu ma trận cắt được không có phần tử (Dấu xuống dòng)
                if (arr.size() < 1) {
                    index = index + 1;
                    //Gọi lại hàm với index cắt ma trận tăng lên 1
                    run(content, index);
                } else {
                    //In ra ma trận cắt được
                    for (int i = 0; i < arr.size(); i++) {
                        System.out.println(arr.get(i));
                    }
                    //Chuẩn hóa dòng đầu tiên của ma trận
                    String fist_line = arr.get(0).trim();
                    fist_line.replaceAll("\\s+", " ");
                    // Xác định số kí tự hàng đầu tiên
                    int fl_len = (fist_line.length() + 1) / 2;
                    // Số kí tự > 0  thì check chữ cái không thì gọi lại hàm run
                    if (fl_len > 0) {
                        //Check có chứa kí tự khác số tự nhiên không
                        boolean check_digit = true;
                        for (int i = 0; i < arr.size(); i++) {
                            for (int j = 0; j < arr.get(i).length(); j = j + 2) {
                                if (Character.getNumericValue(arr.get(i).charAt(j)) < 0
                                        || Character.getNumericValue(arr.get(i).charAt(j)) > 9) {
                                    check_digit = false;
                                }
                            }
                        }
                        //Nếu số cột không khớp số hàng hoặc chứa kí tự khác int
                        if (fl_len - arr.size() != 1 || check_digit == false) {
                            System.out.println("Day khong la ma tran");
                            System.out.println("================================================");
                            run(content, index);
                        } else {
                            System.out.println("Day la ma tran");
                            System.out.println("================================================");
                            run(content, index);
                        }
                    } else {
                        run(content, index);
                    }
                }
            } else {
                //Đã check hết ma trận. Ghi ra file và dừng chương trình
                wr.Write();
                System.exit(0);
            }
        } else {
            if (arr.size() < 1) {
                index = index + 1;
                run(content, index);
            } else {
                for (int i = 0; i < arr.size(); i++) {
                    System.out.println(arr.get(i));
                }
                String fist_line = arr.get(0).trim();
                fist_line.replaceAll("\\s+", " ");
                int fl_len = (fist_line.length() + 1) / 2;
                if (fl_len > 0) {
                    boolean check_digit = true;
                    for (int i = 0; i < arr.size(); i++) {
                        for (int j = 0; j < arr.get(i).length(); j = j + 2) {
                            if (Character.getNumericValue(arr.get(i).charAt(j)) < 0
                                    || Character.getNumericValue(arr.get(i).charAt(j)) > 9) {
                                check_digit = false;
                            }
                        }
                    }
                    if (fl_len - arr.size() != 1 || check_digit == false) {
                        System.out.println("Day khong la ma tran");
                        System.out.println("================================================");
                        run(content, index);
                    } else {
                        System.out.println("Day la ma tran");
                        System.out.println("================================================");
                        run(content, index);
                    }
                } else {
                    run(content, index);
                }
            }
        }

    }
}
