package com.nlobby.usage.repository;

import com.nlobby.usage.domain.Access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccessRepository extends JpaRepository<Access, Long> {

    @Query(value = "select id, entrance_date from vst_access_log" ,nativeQuery = true)
    List<Access> SearchAccessDatas(String datas);
}
