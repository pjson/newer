package com.newer.text.homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by json on 2017/3/1.
 */
public class splitWord {
    public static void main(String[] args) {
        File file=new File("D:\\a");
        try(BufferedReader in=
                   new BufferedReader(
                           new FileReader(file))){
            int fileLen=(int)file.length();
            char[] chars=new char[fileLen];
            in.read(chars);
            String txt=String.valueOf(chars);
            String []a=txt.split("[^a-zA-Z]+");
            for (String s : a) {
                System.out.println(s);
            }

            int n=a.length;//获取文章中单词的个数
            int dSum=0,//dSum表示文章中不同单词的个数
                    sum=0;//sum文章中总的单词数
            Object[][]b=new Object[n][2];
            for(;sum<n;sum++){
                int k=0;//标记单词是否出现过
                for(int i=0;i<dSum;i++){
                    if(((String)b[i][0]).equalsIgnoreCase(a[sum])){
                        b[i][1]=(int)b[i][1]+1;
                        k=1;
                        break;
                    }
                }
                //单词未出现则在记录数组末尾记录此单词
                if(k==0){
                    b[dSum][0]=a[sum];//记录字符
                    b[dSum][1]=1;//记录字符频数
                    dSum++;
                }

            }
            for(int i=0;i<sum;i++){

            }




        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
