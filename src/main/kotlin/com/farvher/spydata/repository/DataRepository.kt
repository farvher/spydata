package com.farvher.spydata.repository

import org.springframework.data.repository.CrudRepository
import com.farvher.spydata.entity.Data
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional


@Repository
interface DataRepository  : CrudRepository<Data, Long>{
	
	fun findByComputer(computer : String) : Optional<List<Data>>
	
	fun deleteByComputer(computer : String) : Unit
	
	fun findByCharactersContaining(characters : String) : Optional<List<Data>>
	
	@Query(nativeQuery=true, value="SELECT * FROM spydata WHERE characters ~* ?1 ")
	fun findByCharactersMatchesRegex(regex : String) : Optional<List<Data>>
}