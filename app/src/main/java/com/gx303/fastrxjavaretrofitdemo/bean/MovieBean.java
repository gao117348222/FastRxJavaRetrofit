package com.gx303.fastrxjavaretrofitdemo.bean;

/**
 * Created by gao117348222 on 2016/8/11.
 */

public class MovieBean {
    private int count;
    private int start;
    private int total;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTota(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "count:"+count+"start:"+start+"total:"+total;
    }
}
