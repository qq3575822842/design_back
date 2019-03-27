package com.zyse.design.untils;

/**
 * @description: 分页工具类
 * @Author: 梦醒灬纠结
 * @Date: 2019/3/19 09:23
 */
public class PageSize {


    /**
     * 分页
     * page:那一页 pageSize：一页显示多少数据
     * @description:
     * @param: page:那一页 pageSize：一页显示多少数据
     * @return: offsetIndex：查询第几条从几开始
     * @Author: yc
     * @date: 2019/3/19 9:26
     */
    public static Integer GetcountSum(Integer page,Integer pageSize){

        if (page == null || page == 0) {
            page = 1;
        }
        // 判断初始化pageSize的值,一页几行
        if (pageSize == null || pageSize == 0) {
            pageSize = 10;
        }
        // 查询第几条从几开始
        Integer offsetIndex = pageSize * (page - 1);

        return offsetIndex;

    }

    /**
     * 判断pageSize如果是null 就赋值为10
     * @param pageSize
     * @return pageSize：显示多少数据
     */
    public static Integer GetInt(Integer pageSize){


        if (pageSize == null ) {

            pageSize = 10;
        }


        return pageSize;

    }
}
