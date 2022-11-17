package com.nttdata.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nttdata.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByAppointmentDateBetweenOrderByPriceAsc(LocalDate startDate, LocalDate endDate);
    
//    @Query("select s from appointment s where s.name = :name")
    List<Appointment> findBynameOfDoctor( String name);
    
//    @Query("update appointmet set prescription= :prescription, charges= :charges where id= :id")
//     void AddPrescriptionAndFees(@Param("prescription") String prescription, @Param("charges") double charges, @Param("id")Long id);

}
