package com.bde.exam.entity;
import java.util.ArrayList;
import java.util.List;


public class ChineseSplit {

//    public static final String chineseString = "我是testString哈哈哈";
//
//    public static void main(String[] args) {
//        List<String> splitStringList = chineseSplitFunction(chineseString, 2);
//        for (String split:splitStringList) {
//            System.out.println(split);
//        }
//    }

    public static List<String> chineseSplitFunction(String src, int bytes){
        try {
            if(src == null){
                return null;
            }
            List<String> splitList = new ArrayList<String>();
            int startIndex = 0;    //字符串截取起始位置
            int endIndex = bytes > src.length() ? src.length() : bytes;  //字符串截取结束位置
            while(startIndex < src.length()){
                String subString = src.substring(startIndex,endIndex);
                //截取的字符串的字节长度大于需要截取的长度时，说明包含中文字符
                //在GBK编码中，一个中文字符占2个字节，UTF-8编码格式，一个中文字符占3个字节。
                while (subString.getBytes("GBK").length > bytes) {
                    --endIndex;
                    subString = src.substring(startIndex,endIndex);
                }
                splitList.add(src.substring(startIndex,endIndex));
                startIndex = endIndex;
                //判断结束位置时要与字符串长度比较(src.length())，之前与字符串的bytes长度比较了，导致越界异常。
                endIndex = (startIndex + bytes) > src.length() ?
                        src.length()  : startIndex+bytes ;

            }
            return splitList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
