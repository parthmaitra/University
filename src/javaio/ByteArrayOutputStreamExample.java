package javaio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ByteArrayOutputStreamExample {
    public static void main(String[] args) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            // Write bytes to the stream
            String data = "Hello, ByteArrayOutputStream!";
            String moreData = "Welcome to Java Programming";
            baos.write(data.getBytes());
            baos.write(moreData.getBytes());
            byteArrayOutputStream.write(data.getBytes());
            // Convert to byte array
            byte[] byteArray = baos.toByteArray();

            // Convert to String
            String result = baos.toString(StandardCharsets.UTF_8);
            String otherString = byteArrayOutputStream.toString();
            System.out.println("Byte array length: " + byteArray.length);
            System.out.println("Resulting String: " + result);
            System.out.println("Result of the other string:"+otherString);

            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

