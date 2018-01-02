package com.ty.tx;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringTransactionTest {
	private ApplicationContext ctx = null;
	private BookShopDao bookShopDao = null;
	private Cashier cashier = null;
	private BookShopService bookShopService = null;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContex.xml");
		bookShopDao = ctx.getBean(BookShopDao.class);
		bookShopService = ctx.getBean(BookShopService.class);
		cashier = ctx.getBean(Cashier.class);
	}
	@Test
	public void TestTransactionPropagation(){
		cashier.checkout("AA", Arrays.asList("1001","1002"));
	}
	@Test
	public void TestBooK(){
		bookShopService.purchase("AA", "1001");
	}
	
	@Test
	public void testBook() {
		System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
	}
	@Test
	public void TestBook1(){
		bookShopDao.updateBookStiock("1001");
	}
	@Test
	public void TestBook2(){
		bookShopDao.updateUserAccount("AA", 100);
	}
}
