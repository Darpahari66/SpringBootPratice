package com.ds.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.ds.entity.Actor;
import com.ds.service.IActorMgmtService;

@Component
public class PagingAndSortingRepoTestRunner implements CommandLineRunner {

	@Autowired
	private IActorMgmtService actorService;
	
	@Override
	public void run(String... args) throws Exception {
		// use the service
	/*	try {
			Iterable<Actor> list=actorService.showActorsSorted(true, "fee");
			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	*/	
		
		//using page
	/*	try {
			Page<Actor> page=actorService.showActorsByPageNo(3, 4);
			System.out.println(page.getNumber()+1+"/"+page.getTotalPages()+" records are.");
			Iterable<Actor> list=page.getContent();
			list.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	*/
		
		//at a time do sort and page
	/*	try {
			Page<Actor> page=actorService.showActorsDataByPageNoAsSorted(0, 4, true, "fee");
			System.out.println(page.getNumber()+1+"/"+page.getTotalPages()+" records are.");
			page.forEach(System.out::println);
			System.out.println("=============More info current page==============");
			System.out.println("Is this page Firtst Page::"+page.isFirst());
			System.out.println("Is this page Last Page::"+page.isLast());
			System.out.println("Records count in the current page::"+page.getNumberOfElements());  
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	*/	
		
		//
		try {
			actorService.showActorsDataByPagination(3);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
