package com.ds.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "JPA_ACTOR_INFO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Actor {

	@Column(name="AID")
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)   //same as auto generator
	//@SequenceGenerator(name = "gen1",sequenceName = "AID_SEQ1",initialValue = 100,allocationSize = 1)
	//@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer aid;
	
	@Column(name = "ANAME",length=30)
	@NonNull
	private String aname;
	
	@Column(name = "ADDRS",length=30)
	@NonNull
	private String addrs;
	
	@Column(name = "CATEGORY",length=30)
	@NonNull
	private String category;
	
	@Column(name = "CONTACT_NO")
	@NonNull
	//@Transient   //in this annotation does not participate persistence logic
	private Long contactNo;
	
	@Column(name = "FEE")
	@NonNull
	private Double fee;
}
