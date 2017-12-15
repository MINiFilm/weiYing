package com.weiying.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.weiying.R;
import com.weiying.actiity.VideoDetailActivity;
import com.weiying.adapter.MyFindAdapter;
import com.weiying.bean.FindBean;
import com.weiying.mvp.find_mvp.Find_Presenter;
import com.weiying.mvp.find_mvp.IFind_View;

import java.util.List;

import me.yuqirong.cardswipelayout.CardItemTouchHelperCallback;
import me.yuqirong.cardswipelayout.CardLayoutManager;
import me.yuqirong.cardswipelayout.OnSwipeListener;

/**
 * 1.类的用途
 * 2.@author棒棒糖：赵姗杉
 * 3.@date2017/12/14  14：02
 */

public class FragmentFind extends Fragment implements View.OnClickListener,IFind_View {
    View view;
    private Find_Presenter find_presenter;
    int num=0;
    private List<FindBean.RetBean.ListBean> dataList;
    private Button button;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       if (view==null){
           view=View.inflate(getContext(), R.layout.fragment_find,null);
       }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent!=null){
            parent.removeView(view);
        }
        button = (Button) view.findViewById(R.id.find_button);
        find_presenter = new Find_Presenter(this);
        find_presenter.getData(num);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                find_presenter.getData(num++);
            }
        });


        return view;

    }

    private void ininData(final List<FindBean.RetBean.ListBean> list) {
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        MyFindAdapter myFindAdapter = new MyFindAdapter(getContext(), list);
        recyclerView.setAdapter(myFindAdapter);
        myFindAdapter.setSetOnClickItem(new MyFindAdapter.SetOnClickItem() {
            @Override
            public void setonclickitem(int position) {

                Toast.makeText(getContext(), "第"+position+"个", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getActivity(), VideoDetailActivity.class);
                intent.putExtra("dataId",list.get(position).getDataId());
                startActivity(intent);

            }
        });


        CardItemTouchHelperCallback cardCallback = new CardItemTouchHelperCallback(recyclerView.getAdapter(), list);
        cardCallback.setOnSwipedListener(new OnSwipeListener<FindBean.RetBean.ListBean>() {
            @Override
            public void onSwiping(RecyclerView.ViewHolder viewHolder, float ratio, int direction) {}

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, FindBean.RetBean.ListBean listBean, int direction) {}
            @Override
            public void onSwipedClear() {
                Toast.makeText(getContext(), "data clear", Toast.LENGTH_SHORT).show();
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ininData(list);
                        recyclerView.getAdapter().notifyDataSetChanged();
                    }
                }, 3000L);
            }

        });
        final ItemTouchHelper touchHelper = new ItemTouchHelper(cardCallback);
        final CardLayoutManager cardLayoutManager = new CardLayoutManager(recyclerView, touchHelper);
        recyclerView.setLayoutManager(cardLayoutManager);
        touchHelper.attachToRecyclerView(recyclerView);
    }
    @Override
    public void onClick(View v) {
    }
    @Override
    public void showData(FindBean findBean) {
        dataList = findBean.getRet().getList();
        ininData(dataList);


    }

}
