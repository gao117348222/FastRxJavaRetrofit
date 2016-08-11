#FastRxJavaRetrofit
这是一个基于RxJava和Retrofit的网络访问基类,基本算是一个用法指南。

使用方法
###1.创建一个你的网络基类
```java
public class Http1  {
    private static final String baseUrl="https://api.douban.com/v2/movie/";
    public static Http1 builder()
    {
        return new Http1();
    }
    public Http1()
    {
        //你可以在这里设置你的个性化OkHttpClient,使用函数BaseHttp.builder().setOkHttpClient(client);
    }
    public  MovieService getMovieService()
    {
        return BaseHttp.builder().getService(baseUrl,MovieService.class);
    }
}
```
###2.在需要访问接口的地方调用接口
```java
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
                        Snackbar.make(view,"访问成功"+movieBean.toString(),Snackbar.LENGTH_SHORT).show();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Snackbar.make(view,"访问出错"+throwable.toString(),Snackbar.LENGTH_SHORT).show();
                    }
                });
    }
```
