package com.example.dell.wanone.model;



import com.example.dell.wanone.ApiSrever;
import com.example.dell.wanone.UtilBean;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DELL on 2019/5/29.
 */

public class Modelmpl implements IModel{
    @Override
    public void chun(final ICallback iCallback, int page) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiSrever.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        retrofit.create(ApiSrever.class).initutil(page).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UtilBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UtilBean utilBean) {
                        List<UtilBean.DataBean.DatasBean> datas = utilBean.getData().getDatas();
                        iCallback.Yes(datas);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iCallback.No(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
