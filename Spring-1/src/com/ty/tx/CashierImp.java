package com.ty.tx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service("Cashier")
public class CashierImp implements Cashier {
	@Autowired
	private BookShopService bookShopService;
	//propagation：指定事物的传播行为，指当前事物的方法，被另一个事物调用
	@Transactional(propagation = Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
	@Override
	public void checkout(String name, List<String> isbn) {
		for (String isbn1 : isbn) {
			bookShopService.purchase(name, isbn1);
		}
	}
}
