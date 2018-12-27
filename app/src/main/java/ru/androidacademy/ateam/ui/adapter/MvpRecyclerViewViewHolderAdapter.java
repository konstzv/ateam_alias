package ru.androidacademy.ateam.ui.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.arellomobile.mvp.MvpDelegate;

abstract public class MvpRecyclerViewViewHolderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private MvpDelegate<? extends MvpRecyclerViewViewHolderAdapter> mMvpDelegate;
    private MvpDelegate<?> mParentDelegate;
    private String mChildId;

//    public MvpRecyclerViewViewHolderAdapter(){
//
//    }

    public MvpRecyclerViewViewHolderAdapter(MvpDelegate<?> parentDelegate, String childId) {
        mParentDelegate = parentDelegate;
        mChildId = childId;

        getMvpDelegate().onCreate();
    }

    public MvpDelegate getMvpDelegate() {
        if (mMvpDelegate == null) {
            mMvpDelegate = new MvpDelegate<>(this);
            mMvpDelegate.setParentDelegate(mParentDelegate, mChildId);

        }
        return mMvpDelegate;
    }
}
