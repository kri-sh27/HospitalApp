//package com.nttdata.model;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name="medicine_assigned")
//public class MedicineAssigned {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
//	
//	//one patient may have more than one medicine
//	@ManyToOne(cascade = CascadeType.PERSIST)
//	@JoinColumn(name="user_id")
//	private User user;
//	//foregin key from medicine table
//	@ManyToOne(cascade = CascadeType.PERSIST)
//	@JoinColumn(name="medicine_id")
//	private Medicine medicine;
//	private String prescription;
//	private int medicineQty;
//	
//	public MedicineAssigned(String prescription, int medicineQty) {
//		super();
//		this.prescription=prescription;
//		this.medicineQty=medicineQty;
//	}
//
//}
