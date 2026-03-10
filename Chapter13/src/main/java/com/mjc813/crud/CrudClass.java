package com.mjc813.crud;

public class CrudClass<A> implements CRUD<A>{
	@Override
	public void add(A item) {

	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public A set(int index, A item) {
		return null;
	}

	@Override
	public A remove(int index) {
		return null;
	}

	@Override
	public A get(int index) {
		return null;
	}

	@Override
	public String getJson(int index) {
		return "";
	}

	@Override
	public String getJsonAllItems() {
		return "";
	}
}
