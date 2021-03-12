package com.nlobby.usage.repository;

import com.nlobby.usage.domain.Access;
import com.nlobby.usage.domain.AccessList;
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
            "   and entrance_date <  :date2", nativeQuery = true)
    Long SearchAccess(@Param("date") Date date, @Param("date2") Date date2);

    //방문 현황 - 인원 - 미방문
    @Query(value = "select count(*) as 미방문_인원 \n" +
            "  from vst_visit_request\n" +
            " where start_date < :date2\n" +
            "   and end_date   >= :date\n" +
            "   and ((checkin_dt < :date or checkin_dt >= :date2) or checkin_dt is null)"
            , nativeQuery = true)
    Long SearchNotAccess(@Param("date") Date date, @Param("date2") Date date2);

    //방문 현황 - 차량 - 방문
    @Query(value = "select count(*) as 방문완료_차량 \n" +
            "  from vst_visit_request R \n" +
            " inner join vst_access_log L \n" +
            "    on R.id = L.visit_request_id \n" +
            " where L.entrance_date >= :date \n" +
            "   and L.entrance_date < :date2 \n" +
            "   and char_length(car_number) > 0;"
            , nativeQuery = true)
    Long SearchCarAccess(@Param("date") Date date, @Param("date2") Date date2);

    //방문 현황 - 차량 - 미방문
    @Query(value = "select count(*) as 미방문_차량 \n" +
            "  from vst_visit_request\n" +
            " where start_date <  :date2 \n" +
            "   and end_date   >= :date\n" +
            "   and ((checkin_dt < :date or checkin_dt >= :date2) or checkin_dt is null)\n" +
            "   and char_length(car_number) > 0;"
            , nativeQuery = true)
    Long SearchCarNotAccess(@Param("date") Date date, @Param("date2") Date date2);

    //방문 인원 최대 시간
    @Query(value = "select to_char(max(exit_date - entrance_date),'dd HH24:MI:SS' ) as 인원최대체류시간 \n" +
            "  from vst_access_log \n" +
            " where entrance_date >= :date \n" +
            "   and entrance_date <  :date2 \n" +
            "   and exit_date is not null; "
            , nativeQuery = true)
    String SearchVisitMax(@Param("date") Date date, @Param("date2") Date date2);


    //방문 인원 평균시간
    @Query(value = "select to_char(avg(exit_date - entrance_date),'dd HH24:MI:SS' ) as 인원최대체류시간 \n" +
            "  from vst_access_log \n" +
            " where entrance_date >= :date \n" +
            "   and entrance_date <  :date2 \n" +
            "   and exit_date is not null; "
            , nativeQuery = true)
    String SearchVisitAvg(@Param("date") Date date, @Param("date2") Date date2);

    // 방문 차량 최대시간
    @Query(value = "select to_char(max(L.exit_date - L.entrance_date),'dd HH24:MI:SS') as 차량최대체류시간 \n" +
            "  from vst_visit_request R \n" +
            " inner join vst_access_log L \n" +
            "     on R.id = L.visit_request_id \n" +
            " where L.entrance_date >= :date \n" +
            "   and L.entrance_date <  :date2 \n" +
            "   and L.exit_date is not null\n" +
            "   and char_length(car_number) > 0;"
            , nativeQuery = true)
    String SearchVisitCarMax(@Param("date") Date date, @Param("date2") Date date2);

    // 방문 차량 평균시간
    @Query(value = "select to_char(avg(L.exit_date - L.entrance_date),'dd HH24:MI:SS') as 차량최대체류시간 \n" +
            "  from vst_visit_request R \n" +
            " inner join vst_access_log L \n" +
            "     on R.id = L.visit_request_id \n" +
            " where L.entrance_date >= :date \n" +
            "   and L.entrance_date <  :date2 \n" +
            "   and L.exit_date is not null\n" +
            "   and char_length(car_number) > 0;"
            , nativeQuery = true)
    String SearchVisitCarAvg(@Param("date") Date date, @Param("date2") Date date2);


    // 출입 분석-인원-최대
    @Query(value = "select count(*) as 일별방문객\n" +
            "  from vst_access_log \n" +
            " where entrance_date >= :date \n" +
            "   and entrance_date <  :date2 \n" +
            " group by to_char(entrance_date, 'YYYY-MM-DD')\n" +
            " order by 일별방문객 desc limit 1", nativeQuery = true)
    Long EntranceMax(@Param("date") Date date, @Param("date2") Date date2);

    // 출입 분석 - 차량 - 최대
    @Query(value = "select count(*) as 일별방문차량\n" +
            "  from vst_visit_request R \n" +
            " inner join vst_access_log L \n" +
            "    on R.id = L.visit_request_id \n" +
            " where L.entrance_date >= :date \n" +
            "   and L.entrance_date <  :date2 \n" +
            "   and char_length(R.car_number) > 0 \n" +
            " group by to_char(L.entrance_date,'YYYY-MM-DD')\n" +
            " order by 일별방문차량 desc\n" +
            " limit 1 ", nativeQuery = true)
    Long EntranceCarMax(@Param("date") Date date, @Param("date2") Date date2);


    //일별 방문 현황 - 인원
    @Query(value = " select count(*) as count, to_char(entrance_date ,'YYYY-MM-DD') as enter_dt \n" +
            "  from vst_access_log \n" +
            " where entrance_date >= :date \n" +
            "   and entrance_date <  :date2 \n" +
            " group by enter_dt \n" +
            " order by enter_dt asc",nativeQuery = true)
    List<Object> accessList(@Param("date") Date date, @Param("date2") Date date2);

    //일별 방문 현황 - 차량
    @Query(value = "select count(*) as 일별방문차량,  to_char(L.entrance_date ,'YYYY-MM-DD') as enter_dt \n" +
            "  from vst_visit_request R \n" +
            " inner join vst_access_log L \n" +
            "    on R.id = L.visit_request_id \n" +
            " where L.entrance_date >= :date \n" +
            "   and L.entrance_date <  :date2 \n" +
            "   and char_length(R.car_number) > 0 \n" +
            " group by enter_dt \n" +
            " order by enter_dt asc",nativeQuery = true)
    List<Object> accessCarList(@Param("date") Date date, @Param("date2") Date date2);

}


