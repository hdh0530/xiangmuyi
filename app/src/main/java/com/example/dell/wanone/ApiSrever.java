package com.example.dell.wanone;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by DELL on 2019/5/29.
 */

public interface ApiSrever {
    String url="https://www.wanandroid.com/";
    @GET("project/list/{page}/json?cid=294")
    Observable<UtilBean> initutil(@Path("page") int page);

}
