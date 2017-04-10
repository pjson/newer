package com.newer.io.otherIO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by json on 2017/2/23.
 */
public class DataIO {
    public static void main(String[] args) {
        //写数据
        writeData();
        //读数据
        readDate();
    }

    private static void readDate() {
        try (DataInputStream in=
                     new DataInputStream(
                             new FileInputStream("data.txt"))){
            int age=in.readInt();
            boolean isSingle=in.readBoolean();
            String name=in.readUTF();
            System.out.println(age);
            System.out.println(isSingle);
            System.out.println(name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void writeData() {
        int age=22;
        boolean isSingle=true;
        String name="bob";

        try (DataOutputStream out=
                                new DataOutputStream(
                                        new FileOutputStream("data.txt"))){
            out.writeInt(age);
            out.writeBoolean(isSingle);
            out.writeUTF(name);
            System.out.println("over");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
