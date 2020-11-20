package com.farvher.spydata.entity

import java.time.LocalDate
import javax.persistence.*


@Entity
@Table(name="spydata")
data class Data (var date : LocalDate ,
			val computer : String,
			@Column(columnDefinition="TEXT")
			var characters :String ,
			@Id @GeneratedValue
			val id : Long = -1 )
