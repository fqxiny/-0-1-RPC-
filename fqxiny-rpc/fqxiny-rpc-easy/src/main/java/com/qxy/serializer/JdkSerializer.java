package com.qxy.serializer;

import java.io.*;

/**
 * @author : 戚欣扬
 * @description :
 * @createDate : 2025/2/28 下午3:55
 */
public class JdkSerializer implements Serializer {
    @Override
    public <T> byte[] serialize(T object) throws IOException {
     ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
     ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        try {

            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
        } finally {
            objectOutputStream.close();
        }
        return outputStream.toByteArray();
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> type) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        try {
            return (T) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            objectInputStream.close();
        }
    }
}


