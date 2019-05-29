package com.example.dell.wanone.view;



import com.example.dell.wanone.UtilBean;

import java.util.List;

/**
 * Created by DELL on 2019/5/29.
 */

public interface IView {
    void Yes(List<UtilBean.DataBean.DatasBean> beans);
    void No(String error);
}
