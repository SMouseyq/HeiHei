package com.channel.heihei.view.myswipecard;

import android.content.Context;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

/**
 * Created by fangyq on 2016/4/8.
 */
public class SwipeCardAdapterView extends AdapterView{

    public SwipeCardAdapterView(Context context){
        super(context);
    }
    public Adapter getAdapter() {
        return null;
    }
    public void setAdapter(Adapter adapter) {
        ListView listView = null;

        BaseAdapter adapter1 = null;
        listView.setAdapter(adapter1);

    }

    @Override
    public View getSelectedView() {
        return null;
    }

    @Override
    public void setSelection(int position) {

    }
}
