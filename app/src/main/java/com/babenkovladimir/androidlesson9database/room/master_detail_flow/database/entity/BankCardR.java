package com.babenkovladimir.androidlesson9database.room.master_detail_flow.database.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bankcard")
public class BankCardR {

  public BankCardR(String ownerName, String num, float amount, String date, int pin) {
    this.ownerName = ownerName;
    this.num = num;
    this.amount = amount;
    this.date = date;
    this.pin = pin;
  }

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "id")
  public Long id;

  @ColumnInfo(name = "cowner_name")
  public String ownerName;

  @ColumnInfo(name = "num")
  public String num;

  @ColumnInfo(name = "about")
  public float amount;

  @ColumnInfo(name = "data")
  public String date;

  @ColumnInfo(name = "pin")
  public int pin;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  public String getNum() {
    return num;
  }

  public void setNum(String num) {
    this.num = num;
  }

  public float getAmount() {
    return amount;
  }

  public void setAmount(float amount) {
    this.amount = amount;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public int getPin() {
    return pin;
  }

  public void setPin(int pin) {
    this.pin = pin;
  }
}
