package com.ds.runners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.ds.BootDataJpaProj1CrudeRepositoryApplication;
import com.ds.entity.Actor;
import com.ds.service.ActorMgmtServiceImpl;
import com.ds.service.IActorMgmtService;

@Component
public class CrudRepositoryTestRunner implements CommandLineRunner{
	
    @Autowired
	private IActorMgmtService actorService;
    

	
	@Override
	public void run(String... args) throws Exception {
		//for insert or set the data
		try {
			//prepare Entity object
			Actor actor=new Actor();
			actor.setAname("Kp");
			actor.setAddrs("JAJ");
			actor.setCategory("Heroine");
			actor.setContactNo(8097878328L);
			actor.setFee(58000.0);
			
			//invoke the service method
			String msg=actorService.registerActor(actor);
			System.out.println(msg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//for count
		
	/*	try {
			long count=actorService.showActorsCount();
			System.out.println("Actors count::"+count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	*/
		
		//checK or get the aid is avialevle or not
	/*	try {
			String msg=actorService.checkActorAvailability(103);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	*/
		
		
		//save all recode or batch 
//		try {
//		Actor actor1=new Actor("Chinu", "HYD", "Sidehero", 98790667L, 45000.0);
//		Actor actor2=new Actor("Mamuni", "BBSR", "Comedian", 778790607L, 45000.0);
//		Actor actor3=new Actor("Raju", "Banglor", "villen", 637900981L, 45000.0);
//		List<Actor> list=List.of(actor1, actor2, actor3);
//		String msg=actorService.registerActors(list);
//		System.out.println(msg);
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
		
		//get all the record
//		try {
//			Iterable<Actor> list=actorService.showAllActor();
//			list.forEach(actor->{
//				System.out.println(actor);
//			});
//			System.out.println("-------------------");
//			list.forEach(System.out::println);
//			System.out.println("-------------------");
//			StreamSupport.stream(list.spliterator(), false).forEach(System.out::println);
//			System.out.println("-------------------");
//			for(Actor actor:list) {
//				System.out.println(actor);
//			}
//			System.out.println("--------------------");
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	
		
		//get record by ids
	/*	try {
			//if u insert null getting error error
			//Iterable<Actor> list=actorService.showActorsByIds(List.of(102,103,104,105,109));
			
			//second method bcz if u insert null no error
			//Iterable<Actor> list=actorService.showActorsByIds(Arrays.asList(106,107,108,null));
			
			//method 3
			List<Integer> ids=new ArrayList();
			ids.add(102);
			ids.add(103);
			ids.add(109);
			ids.add(null);
			Iterable<Actor> list=actorService.showActorsByIds(ids);
			list.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	*/
		
		//optional use to get the id or not using isPresent()
	/*	try {
			String msg=actorService.showActorById(103);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		*/
		
		//optional using isEmpty() 
		/*	try {
			Actor actor=actorService.fetchActorById(103);
			System.out.println("Actor details are::"+actor);
		} catch (Exception e) {
			e.printStackTrace();
		}
	*/
	
		//if not found then it dummy obj show
	/*	try {
			Actor actor=actorService.getActorById(1036);
			System.out.println("Actor details are::"+actor);
		} catch (Exception e) {
			e.printStackTrace();
		}
	*/
		
		//update the record with hike fee
	/*	try {
			String msg=actorService.updateActorFeeById(103, 10.0f);
			System.out.println("update details are::"+msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	*/
		
		//save or update
	/*	try {
			Actor actor=new Actor(1150,"Natraj","HYD","Legend",7683857361L,70000.0);
			String msg=actorService.updateActor(actor);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	*/
	
		
		//delete record by id
	/*	try {
			String msg=actorService.deleteActorById(1150);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	*/
		
		//delete by obj
	/*	try {
			Actor actor=new Actor();
			actor.setAid(115 );
			String msg=actorService.deleteActor(actor);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	*/
		
		//delete using iterable/batch of delete using ids
	/*	try {
			String msg=actorService.deleteActorById(List.of(107, 109, 108));
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	*/	
		
		//delete all the objs
	/*	try {
			String msg=actorService.deleteAllActors();
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	*/	
		
	}

}
