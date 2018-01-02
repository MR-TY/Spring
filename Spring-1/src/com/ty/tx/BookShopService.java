package com.ty.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookShopService {
	@Autowired
	private BookShopDao bookShopDao;
	@Transactional
	public void purchase(String username, String isbn){
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		
		bookShopDao.updateBookStiock(isbn);
		
		bookShopDao.updateUserAccount(username, price);
	}
}
