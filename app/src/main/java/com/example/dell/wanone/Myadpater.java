package com.example.dell.wanone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2019/5/29.
 */

class Myadpater extends RecyclerView.Adapter<Myadpater.ViewHolder>{
    private Context mContext;
    private ArrayList<UtilBean.DataBean.DatasBean> shuju = new ArrayList<>();

    public Myadpater(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UtilBean.DataBean.DatasBean bean = shuju.get(position);
        holder.tv.setText(bean.getNiceDate());
        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(mContext).load(bean.getEnvelopePic()).apply(requestOptions).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return shuju.size();
    }

    public void addData(List<UtilBean.DataBean.DatasBean> beans) {
        shuju.addAll(beans);
        notifyDataSetChanged();
    }

    public void resqq(List<UtilBean.DataBean.DatasBean> beans) {
        shuju.clear();
        shuju.addAll(beans);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
