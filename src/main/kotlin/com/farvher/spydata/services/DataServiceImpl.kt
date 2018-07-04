package com.farvher.spydata.services

import com.farvher.spydata.entity.Data
import org.springframework.beans.factory.annotation.Autowired
import com.farvher.spydata.repository.DataRepository
import org.springframework.stereotype.Service
import java.util.ArrayList

@Service
class DataServiceImpl(val dataRepository: DataRepository) : DataService {

	companion object {
		const val REGEX_EMAIL = "\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b";
		const val REGEX_NUMBER = "(\\+?( |-|\\.)?\\d{1,2}( |-|\\.)?)?(\\(?\\d{3}\\)?|\\d{3})( |-|\\.)?(\\d{3}( |-|\\.)?\\d{4})";
	}
	
	override fun save(data: Data) {
		dataRepository.save(data)
	}


	override fun deleteAll() {
		dataRepository.deleteAll()
	}
	
	override fun deleteById(id: Long) {
		dataRepository.deleteById(id);
	}

	override fun findAll(): List<Data> {
		return dataRepository.findAll().toList().orEmpty()
	}

	override fun findByComputer(computer: String): List<Data> {
		return dataRepository.findByComputer(computer).orElse(ArrayList<Data>())
	}

	override fun deleteByComputer(computer: String) {
		dataRepository.deleteByComputer(computer)
	}
	
	override fun findByMatchEmail(): List<Data> {
		return dataRepository.findByCharactersMatchesRegex(REGEX_EMAIL).orElse(ArrayList<Data>())
	}


	override fun findByContains(contains: String): List<Data> {
		return dataRepository.findByCharactersContaining(contains).orElse(ArrayList<Data>())
	}

	override fun findByMatchNumber(): List<Data> {
		return dataRepository.findByCharactersMatchesRegex(REGEX_NUMBER).orElse(ArrayList<Data>())
	}
}