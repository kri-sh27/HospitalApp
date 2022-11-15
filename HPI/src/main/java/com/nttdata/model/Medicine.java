//package com.nttdata.model;
//
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@AllArgsConstructor
//@Getter
//@Setter
//@NoArgsConstructor
//
//
//
//@Entity
//@Table(name="medicines")  
//public class Medicine {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
//	private String name;
//	
//	@OneToMany(mappedBy = "medicine",cascade = CascadeType.PERSIST)
//	private List<MedicineAssigned> mappedMedcines;
//	
//	
//}
