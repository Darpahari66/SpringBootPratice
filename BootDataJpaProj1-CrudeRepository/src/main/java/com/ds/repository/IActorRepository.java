package com.ds.repository;

import org.springframework.data.repository.CrudRepository;

import com.ds.entity.Actor;

public interface IActorRepository extends CrudRepository<Actor, Integer> {

}
