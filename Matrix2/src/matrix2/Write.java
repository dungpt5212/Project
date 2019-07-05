/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix2;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Formatter;

/**
 *
 * @author Antsoft
 */
public class Write {

    private static PrintStream originalStream;
    private static PrintStream newStream;
    private static ByteArrayOutputStream newConsole = new ByteArrayOutputStream();

    static {

        // store original printstream
        originalStream = System.out;

        // set new print stream, now anything written via
        // System.out will be stored in the byte array 'newConsole'
        newStream = new PrintStream(newConsole);
        System.setOut(newStream);
    }

    public void Write() {
// anything written via System.out will go to new stream
//        System.out.println("data on new stream line 1");
//        System.out.println("data on new stream line 2");

        // Change stream to original, now anything written
        // via System.out will go to console.
        System.setOut(originalStream);

        // it goes to console
//        System.out.println("on console");
        // flush data to new console
        newStream.flush();

        // retrieve data as string from new console,
        // now you can use it as you want
        String newStreamData = newConsole.toString();

        // print new console data on original console
//        System.out.println("****Retrieved from new Stream****");
        //System.out.println(newStreamData);
        try {
            Formatter f = new Formatter("D:\\Test\\javacore\\output.txt");
            f.format(newStreamData);

            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
        // close the newStream
        newStream.close();
    }

}
