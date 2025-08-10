package com.ds.service;

import org.springframework.data.domain.Page;

import com.ds.entity.Actor;

public interface IActorMgmtService {

	public Iterable<Actor> showActorsSorted(boolean ascOrder,String... props);
	public Page<Actor> showActorsByPageNo(int pageNo,int pageSize);
	public Page<Actor> showActorsDataByPageNoAsSorted(int pageNo,int pageSize,boolean ascOrder,String... props);
	public void showActorsDataByPagination(int pageSize);
}
