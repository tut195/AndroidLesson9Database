package com.babenkovladimir.androidlesson9database.room.master_detail_flow;

import com.babenkovladimir.androidlesson9database.room.master_detail_flow.RoomContract.RoomView;

public class RoomPresenter implements RoomContract.RoomPresenter {

  RoomRepository mRepository;
  private RoomView mView;


  public RoomPresenter() {
    mRepository = RoomRepository.getInstance();
  }

  @Override
  public void attachView(RoomView view) {
    mView = view;
    updateView();

  }

  @Override
  public void detachView() {
    mView = null;
  }

  @Override
  public void onResume() {
    updateView();
  }


  private void updateView() {
    if (mView != null) {
      mView.updateCards(mRepository.getBankCards());
    }
  }
}
