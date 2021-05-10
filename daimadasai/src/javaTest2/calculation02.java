package javaTest2;

import javax.swing.text.html.parser.Entity;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 1）字节流到字符流的桥梁怎么理解？
 *
 *     1、计算机存储的单位是字节，如尽管txt文本中有中文汉字这样的字符，但是对计算机而言，其是字节形式存在的
 *
 *     2、字节流读取是单字节读取，但是不同字符集解码成字符需要不通过个数，因此字节流读取会报错
 *
 *    3、 那么就需要一个流把字节流读取的字节进行缓冲而后在通过字符集解码成字符返回，因而形式上看是字符流
 *
 *     4、InputStreamReader流就是起这个作用，实现从字节流到字符流的转换
 2）使用指定的字符集读取字节并将它们解码为字符怎么理解？

       字节本质是8个二进制位，且不同的字符集对同一字节解码后的字符结果是不同的，因此在读取字符时务必要指定合适的字符集，否则读取的内容会产生乱码

 3）它使用的字符集可以通过名称指定，也可以明确指定，或者可以接受平台的默认字符集怎么理解？

       意味着InputStreamReader类有多个方法或者多个构造方法来设置字符集

 4）每次调用一个InputStreamReader的read()方法都可能导致从底层字节输入流中读取一个或多个字节怎么理解？

       read()方法会尝试尽量冲底层字节流中读取2个字符到字符缓冲区中，注意这里是尽量，若遇到文件最后字符，则就只能读取到1个字符，因此每次read()方法读取的字节数是不定的

 5）为了实现字节到字符的有效转换，可以从基础流中提取比满足当前读取操作所需的更多字节，请考虑在BufferedReader中包装InputStreamReader

 */
public class calculation02 {
    public List<LoginStatistics> countLoginNums(String filePath) throws Exception{
        FileInputStream fileStream = new FileInputStream(filePath);//字节流
        InputStreamReader input = new InputStreamReader(fileStream,"GBK");//字节流按照GBK进行解码为字符流
        BufferedReader reader = new BufferedReader(input);//从字符输入流中读取文本，缓冲字符，以便有效地读取字符，数组和行。
        //
        List<LoginStatistics> datas = new ArrayList<>();
        String line = null;
        //将文件的每一行数据变成对象
        while((line = reader.readLine())!=null){
            datas.add(mappedByLine(line));
        }

        Map<String,LoginStatistics> map = new HashMap<>();
        for(LoginStatistics data : datas){
            String key = data.getName()+"|"+data.getDate();
            LoginStatistics exits = map.get(key);
            if(exits != null){
                exits = merge(exits,data);
            }else{
                exits = new LoginStatistics();
                exits.setDate(data.getDate());
                exits.setName(data.getName());
                exits.setLoginNums(1);
            }
            map.put(key,exits);
        }
        List<LoginStatistics> result = new ArrayList<>();
        for(Map.Entry<String,LoginStatistics> entry : map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }
    public LoginStatistics mappedByLine(String line){
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String[] strs = line.split("//|");
        //str[0] 姓名 str[1] ip str[2]登录时间
        //string转换成date时间类型 第二个参数是时间类型
        LocalDate localDate = LocalDate.parse(strs[2],date);
        LoginStatistics loginStatistics = new LoginStatistics();
        loginStatistics.setName(strs[0]);
        loginStatistics.setDate(localDate);
        loginStatistics.setLoginNums(1);
        return loginStatistics;
    }

    public LoginStatistics merge(LoginStatistics s1,LoginStatistics s2){
        LoginStatistics statistics = new LoginStatistics();
        statistics.setDate(s1.getDate());
        statistics.setName(s1.getName());
        statistics.setLoginNums(s1.getLoginNums()+s2.getLoginNums());
        return statistics;
    }
}

class LoginStatistics{
    private String name;
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    private int loginNums;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getLoginNums() {
        return loginNums;
    }

    public void setLoginNums(int loginNums) {
        this.loginNums = loginNums;
    }
}