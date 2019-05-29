package com.example.dell.wanone.preaa;


import com.example.dell.wanone.UtilBean;
import com.example.dell.wanone.model.ICallback;
import com.example.dell.wanone.model.Modelmpl;
import com.example.dell.wanone.view.IView;

import java.util.List;

/**
 * Created by DELL on 2019/5/29.
 */

public class Preaampl implements IPreaa{
    private final Modelmpl mModelmpl;
    IView iview;

    public Preaampl(IView iview) {
        this.iview = iview;
        mModelmpl = new Modelmpl();
    }

    @Override
    public void liu(int page) {
        if (mModelmpl!=null){
            mModelmpl.chun(new ICallback() {
                @Override
                public void Yes(List<UtilBean.DataBean.DatasBean> beans) {
                    iview.Yes(beans);
                }

                @Override
                public void No(String error) {
                    iview.No(error);
                }
            },page);
        }
    }
}
