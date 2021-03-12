package com.nlobby.usage.repository;

import com.nlobby.usage.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface NoticeRepository extends JpaRepository<Notice,Long> {

    @Query(value = "select count(*) \n" +
            "  from vst_notice\n" +
            " where created_at >= :date \n" +
            "   and created_at <  :date2  " , nativeQuery = true)
    Long NoticeCount(@Param("date")Date date, @Param("date2") Date date2);


}
