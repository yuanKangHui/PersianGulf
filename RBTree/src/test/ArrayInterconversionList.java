package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ykh
 * @Date: 2023-02-01-17:32
 * @Description: 数组与List的互相转化
 */
public class ArrayInterconversionList {
    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        String[] arr = {"zs", "ls", "ww"};
        List<String> list = Arrays.asList(arr);
        System.out.println(list);

        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("张三");
        list1.add("李四");
        list1.add("王五");
        String[] arr1 = list1.toArray(new String[0]);
        System.out.println(Arrays.toString(arr1));
        for (String s : arr1) {
            System.out.println(s);
        }
        long late = System.currentTimeMillis();
        System.out.println("代码执行时间：" + (late - before));
    }
}
