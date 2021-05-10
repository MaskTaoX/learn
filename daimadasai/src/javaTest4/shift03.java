package javaTest4;

public class shift03 {
    public int alignTimes(String string){
        //计数变量 最后一次shift操作必定与原单词重合
        int counter = 1;
        int length = string.length();
        //以第i个为字符为新字符串的初始字符
        for(int i = 1;i<length;i++){
            String temp = "";//声明 字符串 用于存放shift操作后的字符串
            //将第i位及之后的字符将入新字符串中
            for(int j = i; j<length; j++){
                temp+=string.charAt(j);
            }
            //将第0位至i-1位的字符加入新字符串中
            for(int k=0;k<i;k++){
                temp+=string.charAt(k);
            }
            //至此一次shift操作完成 判断新字符串与原字符串是否相等 相等则计数器counter+1；
            if(temp.equals(string)){
                counter++;
            }
        }
        return counter;
    }
}
