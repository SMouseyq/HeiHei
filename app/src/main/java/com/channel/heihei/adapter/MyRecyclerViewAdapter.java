package com.channel.heihei.adapter;

/**
 * Created by SMouse on 2016/3/9.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import com.channel.heihei.R;
/**
 * Created by Monkey on 2015/6/29.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyRecyclerViewHolder> {

    // 点击事件接口
    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    public OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


    public Context mContext;
    public List<String> mDatas;
    public LayoutInflater mLayoutInflater;

    public MyRecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
        // 这里是模拟数据。
        mDatas = new ArrayList<>();
        for (int i = 'A'; i <= 'z'; i++) {
            mDatas.add((char) i + "");
        }
    }

    /**
     * 创建ViewHolder
     */
    @Override
    public MyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = mLayoutInflater.inflate(R.layout.item_main, parent, false);
        MyRecyclerViewHolder mViewHolder = new MyRecyclerViewHolder(mView);
        return mViewHolder;
    }

    /**
     * 绑定ViewHoler，给item中的控件设置数据
     */
    @Override
    public void onBindViewHolder(final MyRecyclerViewHolder holder, final int position) {
        //点击事件在这里实现，主要是利用RecyclerView中填充的布局控件可以被点击这个原理
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(holder.itemView, position);
                }
            });

            // 长点击事件
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.onItemLongClick(holder.itemView, position);
                    return true;
                }
            });

        }

        holder.mTextView.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class MyRecyclerViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public MyRecyclerViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.id_textview);
        }
    }


}