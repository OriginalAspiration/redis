package edu.hubu.jedisdemo.utils;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName SerializeUitl
 * @Description TODO
 * @createTime 2019年10月17日 22:34:00
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUitl {
    /**
     * 序列化
     */
    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * 反序列化
     */
    public static <T> T deSerialize(byte[] bytes, Class<T> clazz) {
        ByteArrayInputStream bais = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (T) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
