package com.nlobby.usage.repository;

import com.nlobby.usage.domain.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {

  @Query(value = "select count(*) as 방문신청_인원 \n" +
          "  from vst_visit_request \n" +
          " where start_date <  :date2\n" +
          "   and end_date  >= :date \n" +
          "   and (visit_type is null or visit_type = 'regist')", nativeQuery = true)
    Long SearchRequest(@Param("date") Date date , @Param("date2") Date date2);



  //임원 신청
  @Query(value = "select count(*) as 방문예약_인원 \n" +
          "  from vst_visit_request \n" +
          " where start_date <  :date2 \n" +
          "   and end_date   >= :date\n" +
          "   and visit_type = 'reserve';",nativeQuery = true)
  Long SearchRequestReserve(@Param("date") Date date, @Param("date2") Date date2);





  @Query(value = "select * " +
          "from vst_visit_request where name = ?1" ,nativeQuery = true)
  List<Request> SearchRequestByName(String name);


}
