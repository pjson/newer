package com.newer.io.FileIO.homework1;

import java.io.*;

/**
 * Created by json on 2017/2/23.
 */
public class CodeCounter {
    public static CodeInfo count(File file) {
        String line;
        //是否为注释，一个标识，一个开关
        boolean isComment = false;
        CodeInfo info = new CodeInfo();
        try (BufferedReader in =
                     new BufferedReader(new FileReader(file))) {
            while (null != (line = in.readLine())) {
                line = line.trim();
                info.total++;
                if (line.startsWith("/*")) {
                    isComment = true;
                }
                if (isComment) {
                    info.comment++;
                }
                if (line.endsWith("*/")) {
                    isComment = false;
                    continue;
                }
                if (!isComment) {
                    if (line.length() == 0) {
                        info.blank++;
                    }
                    if (line.startsWith("//")) {
                        info.comment++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        info.code=info.codeCount();
        return info;
    }
}
