package com.gx303.fastrxjavaretrofitdemo;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.gx303.fastrxjavaretrofitdemo.bean.MovieBean;
import com.gx303.fastrxjavaretrofitdemo.data.Http1;

import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickme(final View view)
    {
        //测试获取数据
        Http1.builder().getMovieService().getTopMovie(0,20)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        Snackbar.make(view,"获取中",Snackbar.LENGTH_SHORT).show();
                    }
                })
                .subscribe(new Action1<MovieBean>() {
                    @Override
                    public void call(MovieBean movieBean) {
                        L("访问成功"+movieBean.toString());
                        Snackbar.make(view,"访问成功"+movieBean.toString(),Snackbar.LENGTH_SHORT).show();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        L("错误"+throwable.toString());
                        Snackbar.make(view,"访问出错"+throwable.toString(),Snackbar.LENGTH_SHORT).show();
                    }
                });
    }
    public void L(String s)
    {
        Log.e("Unity",s);
    }
}
