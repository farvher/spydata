package com.farvher.spydata.entity

import java.time.LocalDate
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Entity
import javax.persistence.Table


@Entity
@Table(name="spydata")
data class Data (var date : LocalDate ,
			val computer : String,
			var characters :String ,
			@Id @GeneratedValue
			val id : Long = -1 )
