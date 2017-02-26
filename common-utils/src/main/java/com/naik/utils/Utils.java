package com.naik.utils;

import java.io.*;
import java.nio.channels.Channels;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static Timestamp getCurrentTime() {
        return new Timestamp(new Date().getTime());
    }

    public static byte[] objectToBytes(Object obj) throws IOException {
        byte[] data = null;
        try (
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos)
        ) {
            oos.writeObject(obj);
            data = bos.toByteArray();
        }
        return data;
    }

    public static Object bytesToObject(byte[] data) throws IOException, ClassNotFoundException {
        Object obj = null;
        try (
            ByteArrayInputStream in = new ByteArrayInputStream(data);
            ObjectInputStream is = new ObjectInputStream(in)
        ) {
            obj = is.readObject();
        }
        return obj;
    }

    public static byte[] fileToBytes(RandomAccessFile file) throws IOException {
        return fileToBytes(Channels.newInputStream(file.getChannel()));
    }

    public static byte[] fileToBytes(File file) throws IOException {
        return fileToBytes(new FileInputStream(file));
    }

    public static byte[] fileToBytes(InputStream inputStream) throws IOException {
        byte[] document = null;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             InputStream is = inputStream) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1)
            {
                bos.write(buffer, 0, bytesRead);
            }
            document = bos.toByteArray();
        }
        return document;
    }

    public void writeToFile(File file, byte[] content) throws IOException {
        try (FileOutputStream out = new FileOutputStream(file)) {
            out.write(content);
        }
    }

    public static String getMatchedString(String str, String pattern) {
        Pattern regx = Pattern.compile(pattern);
        Matcher regexMatcher = regx.matcher(str);
        if (regexMatcher.find()) {
            return regexMatcher.group();
        }
        return null;
    }
}
