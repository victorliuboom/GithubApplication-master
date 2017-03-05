package youga.github.app.other;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;

/**
 * Created by liuwei on 2017/3/3.
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected List<T> mDataList = new ArrayList<>();

    public BaseAdapter() {
    }

    public BaseAdapter(@NonNull List<T> dataList) {
        mDataList.clear();
        mDataList.addAll(dataList);
    }

    public void replaceData(List<T> dataList) {
        mDataList.clear();
        if (dataList != null) mDataList.addAll(dataList);
        notifyDataSetChanged();
    }

    public List<T> getDataList() {
        return mDataList;
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
