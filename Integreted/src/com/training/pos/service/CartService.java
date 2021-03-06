package com.training.pos.service;

import java.util.List;

import com.training.pos.bean.CartBean;
import com.training.pos.bean.PosException;

public interface CartService {
	public List<CartBean> getCart(String userId) throws PosException;
	public List<CartBean> addCart(CartBean cartbean,String userId) throws PosException;
	public int delete(String cartID);
	public int updateCart(CartBean edit);
	public CartBean getCartById(String cartID);
}