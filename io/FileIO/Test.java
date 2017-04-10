package com.newer.io.FileIO;

import java.io.File;

/**
 * Created by 何子洋 on 2017/2/22.
 */
public class Test {
    public static void main(String[] args) {

        long time=System.currentTimeMillis();
        FileUtil.copy(
                new File("D:\\Java\\jdk1.8.0_121"),
				new File("d:/code3"));
        time=System.currentTimeMillis()-time;
        System.out.println(time);

        FileInfo info=FileUtil.getFileInfo(
                                        new File(""));
        info.print();
//        info.save("D:/a.txt");


        File file = new File("F:\\t");
//        System.out.println(FileUtil.fileSize(file));
//        System.out.println(FileUtil.dirSize(file));
    }
}
