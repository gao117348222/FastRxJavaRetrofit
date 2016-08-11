package com.gx303.fastrxjavaretrofitdemo.data;

import com.gx303.fastrxjavaretrofit.BaseHttp;

/**
 * Created by gao117348222 on 2016/8/11.
 */

public class Http1  {
    private static final String baseUrl="https://api.douban.com/v2/movie/";
    public static Http1 builder()
    {
        return new Http1();
    }
    public Http1()
    {

    }
    public  MovieService getMovieService()
    {
        return BaseHttp.builder().getService(baseUrl,MovieService.class);
    }
}
