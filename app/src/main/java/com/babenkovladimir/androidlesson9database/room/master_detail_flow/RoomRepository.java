package com.babenkovladimir.androidlesson9database.room.master_detail_flow;

import com.babenkovladimir.androidlesson9database.room.master_detail_flow.database.SkillupDb;
import com.babenkovladimir.androidlesson9database.room.master_detail_flow.database.entity.BankCardR;
import java.util.List;

public class RoomRepository {

  private static RoomRepository INSTANCE;

  private RoomRepository() {
  }


  public static RoomRepository getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new RoomRepository();
    }
    return INSTANCE;
  }


  public List<BankCardR> getBankCards() {
    List<BankCardR> cards = SkillupDb.getAppDatabase().bankCardDao().getAllBankCards();
    return cards;
  }

}
