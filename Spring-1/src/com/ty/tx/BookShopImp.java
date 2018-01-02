package com.ty.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository("BookShop")
public class BookShopImp implements BookShopDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int findBookPriceByIsbn(String ISBN) {
		String sql = "SELECT price FROM book WHERE isbn = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class,ISBN);
	}

	@Override
	public void updateBookStiock(String ISBN) {
		//检查书的账户是否足够，不够就跑出异常
		String sql2 = "SELECT stock FROM book_stock WHERE isbn = ?";
		int stock = jdbcTemplate.queryForObject(sql2, Integer.class,ISBN);
		if (stock==0) {
			 throw new RuntimeException("库存不足");
		}
		
		String sql = "UPDATE book_stock SET stock = stock-1 WHERE isbn = ?";
		jdbcTemplate.update(sql,ISBN);
	}

	@Override
	public void updateUserAccount(String userName, int price) {
		String sql2 = "SELECT balance FROM account WHERE username = ?";
		int balance = jdbcTemplate.queryForObject(sql2, Integer.class,userName);
		if (balance<price) {
			 throw new RuntimeException("余额不足");
		}
		
		String sql = "UPDATE account SET balance = balance-? WHERE username = ?";
		jdbcTemplate.update(sql,price,userName);
	}

}
