package com.babenkovladimir.androidlesson9database.room.master_detail_flow;

import com.babenkovladimir.androidlesson9database.room.master_detail_flow.database.entity.BankCardR;
import java.util.List;

public interface RoomContract {

  interface RoomView {

    void updateCards(List<BankCardR> carwds);

  }

  interface RoomPresenter {

    void attachView(RoomView view);

    void detachView();

    void onResume();
  }

}
