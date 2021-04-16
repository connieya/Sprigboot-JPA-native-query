package com.nlobby.usage.repository;

import com.nlobby.usage.domain.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HostRepository extends JpaRepository<Host,Long> {

    @Query(value = "select count(*) \n" +
            "  from vst_host_user\n" +
            " where is_closed = false;" , nativeQuery = true)
    Long UserCount();
}
