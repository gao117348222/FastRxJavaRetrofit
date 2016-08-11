package com.gx303.fastrxjavaretrofitdemo.data;

import com.gx303.fastrxjavaretrofitdemo.bean.MovieBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by gao117348222 on 2016/8/11.
 */

public interface MovieService {
    @GET("top250")
    Observable<MovieBean> getTopMovie(@Query("start") int start,@Query("count") int count);
}
