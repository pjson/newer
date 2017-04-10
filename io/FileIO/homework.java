package com.newer.io.FileIO;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 统计文本文件中总行数
 * 统计一个Java文件中注释，空行，代码的比例
 * Created by json on 2017/2/22.
 */
public class homework {
    public static void main(String[] args) {

       /* System.out.println("".trim());
        System.out.println("".startsWith("//"));
        System.out.println("".endsWith("*//*"));

        try(BufferedReader in=
                    new BufferedReader(new FileReader("D:\\a"))){
            String line;
            int lineSum=1;
            int zhushi=0;
            int space=0;
            int code=0;
            while(null!=(line=in.readLine())){
                System.out.println(lineSum+" "+line);

                if(line.equals("")){
                    space++;
                }else if(line.trim().startsWith("//")||
                        line.trim().startsWith("*//**")||
                        line.trim().startsWith("*")||
                        line.trim().startsWith("")){
                    zhushi++;
                }else{
                    code++;
                }
                lineSum++;
            }
            System.out.println("总行数:"+--lineSum);
            System.out.println("空行数:"+space);
            System.out.println("代码行数:"+code);
            System.out.println("注释行数:"+zhushi);
        }catch (Exception e){
            e.printStackTrace();
        }*/

        //方法的优化
        try(BufferedReader in=
                    new BufferedReader(new FileReader("D:\\a"))){
            //try(BufferedReader in=new BufferedReader(new  FileReader(file)))
            //是否为注释，一个标识，一个开关
            //boolean isComment=false;
            String line;
            int lineSum=1;
            int zhushi=0;
            int space=0;
            int code=0;
            while(null!=(line=in.readLine())){//判断常量时，一定要把常量放在等号的左边
                System.out.println(lineSum+" "+line);
//

                if(line.trim().equals("")){
                    //if(line.trim().length()==0)
                    space++;
                }else if(line.trim().startsWith("//")||
                        line.trim().startsWith("*//**")||
                        line.trim().startsWith("*")||
                        line.trim().startsWith("")){
                    zhushi++;
                }else{
                    code++;
                }
                lineSum++;
            }
            System.out.println("总行数:"+--lineSum);
            System.out.println("空行数:"+space);
            System.out.println("代码行数:"+code);
            System.out.println("注释行数:"+zhushi);
        }catch (Exception e){
            e.printStackTrace();
        }


        /**
         *    统计JDK中src目录文件的大小，文件数目，文件中空行数，代码数
         */


    }
}
