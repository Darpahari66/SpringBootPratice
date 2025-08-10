package com.ds.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ds.entity.Actor;

public interface IActorRepository extends CrudRepository<Actor, Integer>, PagingAndSortingRepository<Actor, Integer>{

}
