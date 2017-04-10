package com.newer.io.FileIO.homework2;



import java.io.File;

/**
 * Created by json on 2017/2/23.
 */
public class srcTest {
    static srcInfo info=new srcInfo();
    static srcInfo info1=new srcInfo();
    public static void main(String[] args) {
        File file=new File("D:\\JDK\\jdk1.8.0_60\\src");
        work(file);
        info1.print();
    }

    public static void work(File file) {

        if(!file.isFile()){
            File[] files = file.listFiles();
            for(File f : files){
                if(!file.isFile()){
                    work(f);

                }else {
                    info= srcCounter.count(file);
                    info1.total+=info.total;
                    info1.blank+=info.blank;
                    info1.code+=info.code;
                    info1.comment+=info.comment;
                }
            }
        }else {
            info= srcCounter.count(file);
            info1.total+=info.total;
            info1.blank+=info.blank;
            info1.code+=info.code;
            info1.comment+=info.comment;
        }

    }
}
