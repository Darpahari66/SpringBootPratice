package com.ds.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import com.ds.runners.CrudRepositoryTestRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.entity.Actor;
import com.ds.repository.IActorRepository;

@Service("actorService")
public class ActorMgmtServiceImpl  implements IActorMgmtService{
   
	@Autowired
	private IActorRepository actorRepo;


    
	@Override
	public String registerActor(Actor actor) {
		
//		System.out.println("Proxy obj class name::"+actorRepo.getClass());
//		System.out.println("Proxy class implemented list of interfaces::"+Arrays.toString(actorRepo.getClass().getInterfaces()));
//		System.out.println("List of implemented methods::"+Arrays.toString(actorRepo.getClass().getDeclaredMethods()));
		//save the object(record insertion)
		
		System.out.println("Entity object data before saving the object::"+actor);
		Actor savedActor=actorRepo.save(actor);
		System.out.println("Entity object data after saving the object::"+actor);
		return savedActor.getAid()+ " is saved with the id value::";
	}


	@Override
	public long showActorsCount() {
		return actorRepo.count();
	}


	@Override
	public String checkActorAvailability(int id) {
		boolean flag=actorRepo.existsById(id);
		return flag?"Actor available.":"Actor is not available";
	}


//	@Override
//	public String registerActors(Iterable<Actor> entities) {
//		//use repo
//		Iterable<Actor> savedEntities=actorRepo.saveAll(entities);
//		//get ids of the saved Entities
//		int count=0;
//		List<Integer> ids=new ArrayList();
//		for (Actor entity:savedEntities) {
//			count++;
//			ids.add(entity.getAid());
//		}
//		
//		
//		return count+"No. of entites are saved with id values::"+ids;
//	}
	
	@Override
	public String registerActors(Iterable<Actor> entities) {
		//use repo
		Iterable<Actor> savedEntities=actorRepo.saveAll(entities);
		//get ids of the saves Entities
		List<Integer> ids= StreamSupport.stream(savedEntities.spliterator(), false).map(Actor::getAid).collect(Collectors.toList());
		
		return ids.size() + " Objects are saved having id values::"+ids;
		
	}


	@Override
	public Iterable<Actor> showAllActor() {
		return actorRepo.findAll();
	}


	@Override
	public Iterable<Actor> showActorsByIds(Iterable<Integer> ids) {
		
		return actorRepo.findAllById(ids);
	}


	//method 1
	@Override
	public String showActorById(int id) {
		Optional<Actor> opt=actorRepo.findById(id);
		if(opt.isPresent()) {
			Actor actor=opt.get();
			return id+" Actor details ::"+actor;
		}else {
			return id+" Actor not found";
		}
		
	}

//method-2
/*	@Override
	public Actor fetchActorById(int id) {
		Optional<Actor> opt=actorRepo.findById(id);
		if(opt.isEmpty()) 
			throw new IllegalArgumentException("Invalid id");
		
		else 
			return opt.get();	
	}
	*/
	
	// method-2short form
	@Override
	public Actor fetchActorById(int id) {
		
		Actor actor=actorRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid id"));
		return actor;
		
	}


	@Override
	public Actor getActorById(int id) {
		Actor actor=actorRepo.findById(id).orElse(new Actor("Duplicate Actor","BBSR","stunt master",900894045L,5000.0));
		return actor;
	}


	@Override
	public String updateActorFeeById(int id, float hikePercentage) {
		Optional<Actor> opt=actorRepo.findById(id);
		if(opt.isEmpty())
			return id+" id Actor is not found";
		else {
			//get Entity object for Optional API
			Actor actor=opt.get();
			//hike the fee
			actor.setFee(actor.getFee()+(actor.getFee()*hikePercentage/100.0));
			actorRepo.save(actor);
			return id+" id actor is updated with new fee";
		}
		
	}


	@Override
	public String updateActor(Actor actor) {
		actorRepo.save(actor);
		return "Actor object is saved or updated";
	}


	@Override
	public String deleteActorById(int id) {
		//load the object
		Optional<Actor> opt=actorRepo.findById(id);
		if(opt.isEmpty()) {
			return id +" id is not found for declaration";
		}else {
			//delete the object
			actorRepo.deleteById(id);
			return id +" id is found and deleted ";
		}
	}


	@Override
	public String deleteActor(Actor actor) {
		//load the object
				Optional<Actor> opt=actorRepo.findById(actor.getAid());
				if(opt.isEmpty()) {
					return actor.getAid() +" id is not found for declaration";
				}else {
					//delete the object
					actorRepo.delete(actor);
					return actor.getAid() +" id is found and deleted ";
				}
		
	}


	@Override
	public String deleteActorById(Iterable<Integer> ids) {
		//get the batch of ids
		Iterable<Actor> list=actorRepo.findAllById(ids);
		//count the ids 
		long count=StreamSupport.stream(list.spliterator(), true).count();
		
		//delete the obj
		actorRepo.deleteAllById(ids);
		return count+ " of objs are deleted.";
	}


	@Override
	public String deleteAllActors() {
		//get the record count
		long count=actorRepo.count();
		//delete the objs
		actorRepo.deleteAll();
		return count+ " no. of records are deleted.";
	}
	
	
		


	

}
