package com.training.pos.service;

import java.util.List;

import com.training.pos.bean.OrderBean;
import com.training.pos.bean.PosException;

public interface OrderService {
	public List<OrderBean> getOrder() throws PosException;
	public List<OrderBean> getOrder(String UserID) throws PosException;
	public List<OrderBean> addOrder(OrderBean ord,String UserId) throws PosException;
	public int delete(String orderId);
	public OrderBean getOrderById(String orderId);
	public int update(OrderBean order);

}
