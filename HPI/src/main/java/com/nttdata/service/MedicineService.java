//package com.nttdata.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.nttdata.model.Medicine;
//import com.nttdata.repository.MedicineRepository;
//@Service
//public class MedicineService {
//	
//	@Autowired
//	MedicineRepository medicineRepository;
//	
//	public Medicine addMedicine(Medicine medicine) {
//		medicineRepository.save(medicine);
//		return medicine;
//	}
//	
//	public List<Medicine> getAllMedicine(){
//		List<Medicine> list=medicineRepository.findAll();
//		return list;
//	}
//
//}
