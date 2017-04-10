package com.newer.io.FileIO.homework1;

import java.io.File;

/**
 * 求一个文件中的空行数，代码行数
 * Created by json on 2017/2/23.
 */
public class CodeTest {
    public static void main(String[] args) {
        File file=new File("d:\\a");
        CodeInfo info= CodeCounter.count(file);
        info.print();
    }
}
