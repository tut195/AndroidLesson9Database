package com.babenkovladimir.androidlesson9database.room.master_detail_flow.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.babenkovladimir.androidlesson9database.room.master_detail_flow.database.entity.BankCardR;
import java.util.List;

@Dao
public interface BankCardDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  public Long insertBankCard(BankCardR bankCard);

  @Update(onConflict = OnConflictStrategy.IGNORE)
  public int updateBankCard(BankCardR bankCard);

  @Delete
  public void deleteBankCard(BankCardR bankCardR);

  @Query("SELECT * FROM bankcard")
  public List<BankCardR> getAllBankCards();

  @Query("SELECT * FROM bankcard WHERE cowner_name=:ownerName")
  public List<BankCardR> getAllBankCards(String ownerName);
}
