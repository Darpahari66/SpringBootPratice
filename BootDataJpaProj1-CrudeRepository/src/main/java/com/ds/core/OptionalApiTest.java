package com.ds.core;

import java.util.Date;
import java.util.Optional;

public class OptionalApiTest {

	public  static Date showDateByMonth(int month) {
		if(month>12 || month<1)
			return null;
		else {
			Date d=new Date();
			d.setMonth(month);
			return d;
			}
}
	
	public  static Optional<Date> showDateByMonth1(int month) {
		if(month>12 || month<1)
			return Optional.empty();
		else {
			Date d=new Date();
			d.setMonth(month);
			return Optional.of(d);
		}
	}
	
	public static void main(String[] args) {
//		Date d= showDateByMonth(-11);
//		System.out.println("MOnth is"+d.getMonth());
		
		Optional<Date> opt=showDateByMonth1(10);
		if(opt.isPresent()) {
		Date d=opt.get();
		System.out.println("Sys date ::"+d);
		System.out.println("Month is ::"+d.getMonth());
		System.out.println("houres ::"+d.getHours());
		}else {
			System.out.println("Wrong month is given");
		}
	}
	
}
