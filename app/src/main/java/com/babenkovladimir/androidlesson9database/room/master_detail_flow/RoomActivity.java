package com.babenkovladimir.androidlesson9database.room.master_detail_flow;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.babenkovladimir.androidlesson9database.BaseActivity;
import com.babenkovladimir.androidlesson9database.R;
import com.babenkovladimir.androidlesson9database.room.master_detail_flow.adapter.MyRecyclerAdapter;
import com.babenkovladimir.androidlesson9database.room.master_detail_flow.database.entity.BankCardR;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;

public class RoomActivity extends BaseActivity implements RoomContract.RoomView {

  // Binding

  @BindView(R.id.recycler)
  RecyclerView mRecycler;

  @BindView(R.id.btAddBankCard)
  FloatingActionButton btAddCard;

  // Variables

  private MyRecyclerAdapter mRecyclerAdapter;
  private RoomContract.RoomPresenter mPresenter;

  // Life

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_master_detail_flow);
    ButterKnife.bind(this);

    setupRecycler();
    attachPresenter();
  }

  private void attachPresenter() {
    mPresenter = new RoomPresenter();
    mPresenter.attachView(this);
  }

  @Override
  protected void onStart() {
    super.onStart();

  }

  @OnClick(R.id.btAddBankCard)
  public void openAddCardActivity() {
    startActivity(new Intent(this, AddCardActivity.class));
  }

  private void setupRecycler() {
    mRecyclerAdapter = new MyRecyclerAdapter();

    LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

    mRecycler.setLayoutManager(layoutManager);
    mRecycler.setAdapter(mRecyclerAdapter);
  }

  @Override
  protected void onResume() {
    super.onResume();
    mPresenter.onResume();
  }

  @Override
  public void updateCards(List<BankCardR> cards) {
    mRecyclerAdapter.setCards(cards);
    mRecyclerAdapter.notifyDataSetChanged();
  }

  @Override
  protected void onDestroy() {
    mPresenter.detachView();
    super.onDestroy();
  }
}
