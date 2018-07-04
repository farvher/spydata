package com.farvher.spydata.services

import com.farvher.spydata.entity.Data

interface DataService {
	
	fun deleteAll() : Unit
	
	fun findAll() : List<Data>
	
	fun findByComputer(computer : String) : List<Data>
	
	fun deleteByComputer(computer : String) : Unit
	
	fun findByMatchEmail() :  List<Data>
	
	fun findByContains(contains : String) : List<Data>
	
	fun findByMatchNumber() : List<Data>
	
	fun save(data : Data) : Unit
	
}