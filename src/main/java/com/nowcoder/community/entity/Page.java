package com.nowcoder.community.entity;

import lombok.Data;


public class Page {
    //当前的页码
    private int current = 1;

    //显示1页上限
    private int limit = 10;

    //数据总数(用于计算总页数)
    private int rows;

    //查询路径(复用分页连接)
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current > 0) {
            this.current = current;
        }

    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit > 1 && limit <= 100) {
            this.limit = limit;
        }
    }

    public int getRows() {

        return rows;
    }

    public void setRows(int rows) {
        if (rows > 0) {
            this.rows = rows;
        }

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Page{" +
                "current=" + current +
                ", limit=" + limit +
                ", rows=" + rows +
                ", path='" + path + '\'' +
                '}';
    }

    public int getCurrentOffset(){
        // current * limit - limit
        return (current - 1) * limit;
    }

    //获取总页数
    public int getTotal(){
        return (int) Math.ceil((double) rows /limit);
    }
    //从第几页
    public int getFrom(){
        int from = current-2;
        return Math.max(from, 1);
    }
    //到第几页

    public int getTo(){
        int to  = current+2;
        int total  = getTotal();
        return Math.min(to, total);
    }
}
