package com.employeeinout.inoutrepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employeeinout.models.InOutRecord;

import jakarta.transaction.Transactional;

public interface InOutRepository extends JpaRepository<InOutRecord, Integer>{

	@Query("from InOutRecord where date=:d and eid=:e")
     List<InOutRecord> getInOutRecord(@Param("e") int i,@Param("d") String string);

	@Modifying
	@Transactional
	@Query("update InOutRecord set outTime=:nt where date=:d and eid=:e and outTime is null")
	void updateOutRecord(@Param("nt") String string,@Param("e") int i, @Param("d") String string2);

	@Query("from InOutRecord where eid=:e")
	List<InOutRecord> findbyEid(@Param("e") int eid);
	@Query("from InOutRecord where date=:e")
	List<InOutRecord> findbyDate(@Param("e") String date);


}
