//package com.nttdata.controller;
//
//import java.util.List;
//
//import javax.annotation.security.RolesAllowed;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.nttdata.model.Doctor;
//import com.nttdata.model.Medicine;
//import com.nttdata.service.MedicineService;
//
//@RestController
//@RequestMapping("/")
//@CrossOrigin(origins = "*")
//public class MedicineController {
//	
//	@Autowired
//	MedicineService medicineService;
//	
//	@RolesAllowed("DOCTOR")
//	@PostMapping(value="/addmedicine" ,  consumes= { "application/json"})
//	public Medicine addMedicine(@RequestBody Medicine medicine)throws Exception {			
//			return medicineService.addMedicine(medicine);
//
//	}
//	
//	@RolesAllowed("DOCTOR")
//	@GetMapping("/getallmedicine")
//	public List<Medicine> get() {
//		return medicineService.getAllMedicine();
//	}
//
//}
