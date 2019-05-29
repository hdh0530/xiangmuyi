package com.example.dell.wanone;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.dell.wanone.preaa.Preaampl;
import com.example.dell.wanone.view.IView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IView{
    private RecyclerView xr;
    private BallPulseFooter mBf;
    private Myadpater mMyadpater;
    private Preaampl mPreaampl;
    int page = 1;
    private SmartRefreshLayout mSm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }
    private void initData() {
        mPreaampl = new Preaampl(this);
        mPreaampl.liu(page);
    }

    private void initView() {
        xr = (RecyclerView) findViewById(R.id.xr);
        mBf = (BallPulseFooter) findViewById(R.id.bf);
        xr.setLayoutManager(new LinearLayoutManager(this));
        mMyadpater = new Myadpater(this);
        xr.setAdapter(mMyadpater);
        mSm = (SmartRefreshLayout) findViewById(R.id.sm);
        mSm.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                mPreaampl.liu(page);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page++;
                mPreaampl.liu(page);
            }
        });
    }

    @Override
    public void Yes(List<UtilBean.DataBean.DatasBean> beans) {
        if (page == 1) {
            mMyadpater.resqq(beans);
            mSm.finishRefresh();
        } else {
            mMyadpater.addData(beans);
            mSm.finishLoadMore();
        }
    }

    @Override
    public void No(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}

