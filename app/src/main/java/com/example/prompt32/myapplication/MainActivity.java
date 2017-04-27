package com.example.prompt32.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MainAdapter mainAdapter;
    private List<Integer> mItems;

    private static Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Observable<String> simpleObservable = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello RxAndroid!!");
                subscriber.onCompleted();

            }
        });*/

        /*simpleObservable.subscribe(new Action1<String>() {

            @Override
            public void call(String s) {
                ((TextView)findViewById(R.id.textView)).setText(s);
            }
        });*/

        /*simpleObservable.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.d("TAG", "complete!!");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("TAG", "error: " + e.getMessage());
            }

            @Override
            public void onNext(String s) {
                ((TextView)findViewById(R.id.textView)).setText(s);
            }
        });*/

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setItemPrefetchEnabled(true);

        recyclerView.setLayoutManager(layoutManager);
        mainAdapter = new MainAdapter();
        recyclerView.setAdapter(mainAdapter);

        findViewById(R.id.btnAdd).setOnClickListener(this);

        mActivity = MainActivity.this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdd:
                addItem();
                break;
        }
    }

    private void addItem() {
        //int randLength = (new Random().nextInt(100)) + 1;
        if(mItems == null) {
            mItems = new ArrayList<>();
        }
        int oldSize = mItems.size();
        mItems.clear();
        for (int i=0; i<10; i++) {
            mItems.add(oldSize + i);
        }
        Log.d("TAG", "================== addItem ==================");
        mainAdapter.updateListItems(mItems);
    }
}
