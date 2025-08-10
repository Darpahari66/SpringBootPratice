  package com.ds.service;

import java.util.List;

import com.ds.entity.Actor;

public interface IActorMgmtService {

	public String registerActor(Actor actor);
	public long showActorsCount();
	public String checkActorAvailability(int id);
	public String registerActors(Iterable<Actor> entities);
	public Iterable<Actor> showAllActor();
	public Iterable<Actor> showActorsByIds(Iterable<Integer> ids);
	public String showActorById(int id);
	public Actor fetchActorById(int id);
	public Actor getActorById(int id);
	public String updateActorFeeById(int id,float hikePercentage);
	public String updateActor(Actor actor);
	public String deleteActorById(int id);
	public String deleteActor(Actor actor);
	public String deleteActorById(Iterable<Integer> ids);
	public String deleteAllActors();
	
	  
}

