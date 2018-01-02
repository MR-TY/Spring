package com.ty.tx;

public interface BookShopDao {
	public int findBookPriceByIsbn(String ISBN);
	public void  updateBookStiock(String ISBN);
	public void updateUserAccount(String userName,int price);
}
