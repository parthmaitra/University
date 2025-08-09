package javaio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamExample {
    public static void main(String[] args) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            // Write bytes to the stream
            String data = "Hello, ByteArrayOutputStream!";
            String moreData = "Welcome to Java Programming";
            baos.write(data.getBytes());
            baos.write(moreData.getBytes());
            // Convert to byte array
            byte[] byteArray = baos.toByteArray();

            // Convert to String
            String result = baos.toString("UTF-8");
            System.out.println("Byte array length: " + byteArray.length);
            System.out.println("Resulting String: " + result);

            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

