package com.nlobby.usage.repository;

import com.nlobby.usage.domain.Access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface AccessRepository extends JpaRepository<Access, Long> {

    //방문 현황 - 인원 - 방문
   @Query(value = "select count(*) as 방문완료_인원 \n" +
           "  from vst_access_log \n" +
           " where entrance_date >= :date \n" +
           "   and entrance_date <  :date2" ,nativeQuery = true)
    Long SearchAccess(@Param("date")Date date , @Param("date2") Date date2);

    //방문 현황 - 인원 - 미방문
    @Query(value = "select count(*) as 미방문_인원 \n" +
            "  from vst_visit_request\n" +
            " where start_date < :date2\n" +
            "   and end_date   >= :date\n" +
            "   and ((checkin_dt < :date or checkin_dt >= :date2) or checkin_dt is null)"
            ,nativeQuery = true)
    Long SearchNotAccess(@Param("date")Date date , @Param("date2") Date date2);

    //방문 현황 - 차량 - 방문
    @Query(value = "select count(*) as 방문완료_차량 \n" +
            "  from vst_visit_request R \n" +
            " inner join vst_access_log L \n" +
            "    on R.id = L.visit_request_id \n" +
            " where L.entrance_date >= :date \n" +
            "   and L.entrance_date < :date2 \n" +
            "   and char_length(car_number) > 0;"
            ,nativeQuery = true)
    Long SearchCarAccess(@Param("date")Date date , @Param("date2") Date date2);

    //방문 현황 - 차량 - 미방문
    @Query(value = "select count(*) as 미방문_차량 \n" +
            "  from vst_visit_request\n" +
            " where start_date <  :date2 \n" +
            "   and end_date   >= :date\n" +
            "   and ((checkin_dt < :date or checkin_dt >= :date2) or checkin_dt is null)\n" +
            "   and char_length(car_number) > 0;"
            ,nativeQuery = true)
    Long SearchCarNotAccess(@Param("date")Date date , @Param("date2") Date date2);

    //방문 인원 최대 시간
    @Query(value = "select to_char(max(exit_date - entrance_date),'dd HH24:MI:SS' ) as 인원최대체류시간 \n" +
            "  from vst_access_log \n" +
            " where entrance_date >= :date \n" +
            "   and entrance_date <  :date2 \n" +
            "   and exit_date is not null; "
            ,nativeQuery = true)
    String SearchVisitMax(@Param("date")Date date , @Param("date2") Date date2);


    //방문 인원 평균시간
    @Query(value = "select to_char(avg(exit_date - entrance_date),'dd HH24:MI:SS' ) as 인원최대체류시간 \n" +
            "  from vst_access_log \n" +
            " where entrance_date >= :date \n" +
            "   and entrance_date <  :date2 \n" +
            "   and exit_date is not null; "
            ,nativeQuery = true)
    String SearchVisitAvg(@Param("date")Date date , @Param("date2") Date date2);


}

