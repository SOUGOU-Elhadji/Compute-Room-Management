package com.saraya.computerroommanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.computerroommanage.model.Machine;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Integer> {

}
