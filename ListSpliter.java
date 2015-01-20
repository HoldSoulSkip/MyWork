package com.zwt.web;

import java.util.ArrayList;
import java.util.List;

/**
 * list 分割
 *
 * @author wentaozhang
 */
public class ListSpilter {

    public static void main(String[] args) {
        List<Object> arrayList = new ArrayList(); // 完成验证
        for (int i = 0; i < 17; i++) {
            arrayList.add(i + 1);

        }

        // ***********切割算法 如下***************************
        ListSpilter listSpilter =new ListSpilter();
       List<List<Object>> subs = listSpilter.getSubList(arrayList, 4);   ///调用分割算法

        // ************切割算法结束*******************

         //*********************页面的输出开始************
        for (List<Object> arrayList2 : subs) {
            System.out.println("这是一个输出");
            for (Object integer : arrayList2) {

                System.out.println(integer);

            }
            System.out.println("输出结束");
        }
        //*************************页面的输出结束************
    }

    /***
     * 按照count完成数据List 的切割 完成对list的切割
     *  一个整体的list里面包含很多个小的list ，每个list中有count个值
     *
     * @param list
     * @param count
     * @return
     */
    public List<List<Object>> getSubList(List<Object> list, int count) {
        List<List<Object>> subs = new ArrayList<List<Object>>();
        int page = list.size() / count; // 得出有划分多少组

        int last = list.size() % count; //得出是否能整除
        if (last != 0) {                //如果不能整除的话，则在原来的组上加1
            page++;
        }
        for (int i = 0; i < page - 1; i++) {
            subs.add(list.subList(i * count, (i + 1) * count));  // 把最大组之前的数据都存到组中
        }
        subs.add(list.subList((page - 1) * count, list.size()));  //存最大的组中的数据

        return subs;

    }

}
