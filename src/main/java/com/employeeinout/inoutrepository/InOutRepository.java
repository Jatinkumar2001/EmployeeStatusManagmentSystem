package com.employeeinout.inoutrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeinout.models.InOutRecord;

public interface InOutRepository extends JpaRepository<InOutRecord, Integer>{

}
