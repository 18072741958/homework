package com.geek.zeng;

import java.io.*;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;

public class CustomClassloader extends ClassLoader {

    public static void main(String[] args) throws Exception {
        Class clazz = new CustomClassloader().findClass("Hello");
        Method method = clazz.getMethod("hello");
        method.invoke(clazz.newInstance());

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = loadFile("Hello.xlass");
        return defineClass(name, bytes, 0, bytes.length);
    }

    private static byte[] loadFile(String fileName) {
        byte[] decocdBytes = null;
        try {
            URL url = ClassLoader.getSystemResource(fileName);
            File file = null;
            file = new File(url.toURI());
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int len = 0;
            byte b = 0;
            while ((len = fileInputStream.read()) != -1) {
                b = (byte) (255 - len);
                byteArrayOutputStream.write(b);
            }
            fileInputStream.close();
            byteArrayOutputStream.close();
            decocdBytes = byteArrayOutputStream.toByteArray();
        } catch (URISyntaxException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return decocdBytes;
    }

}
