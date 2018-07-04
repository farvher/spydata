package com.farvher.spydata.repository

import org.springframework.data.repository.CrudRepository
import com.farvher.spydata.entity.Data
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query


@Repository
interface DataRepository  : JpaRepository<Data, Long>{
	
	fun findByComputer(computer : String) : List<Data>
	
	fun deleteByComputer(computer : String) : Unit
	
	fun findByCharactersContaining(characters : String) : List<Data>
	
	@Query(nativeQuery=true, value="SELECT * FROM spydata WHERE characters regexp ?1 ")
	fun findByCharactersMatchesRegex(regex : String) : List<Data>
}