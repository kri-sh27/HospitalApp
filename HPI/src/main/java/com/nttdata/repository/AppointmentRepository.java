package com.nttdata.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nttdata.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByAppointmentDateBetweenOrderByPriceAsc(LocalDate startDate, LocalDate endDate);
    
//    @Query("select s from appointment s where s.name = :name")
    List<Appointment> findBynameOfDoctor( String name);
    
    @Transactional
    @Modifying
    @Query(value="update appointment set prescription= :prescription,charges= :charges where id= :id",nativeQuery = true)
     void AddPrescriptionAndFees(@Param("prescription") String prescription, @Param("charges") double charges, @Param("id")Long id);

}
