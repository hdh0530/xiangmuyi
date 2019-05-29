package com.example.dell.wanone.model;


import com.example.dell.wanone.UtilBean;

import java.util.List;

/**
 * Created by DELL on 2019/5/29.
 */

public interface ICallback {
    void Yes(List<UtilBean.DataBean.DatasBean> beans);
    void No(String error);
}
