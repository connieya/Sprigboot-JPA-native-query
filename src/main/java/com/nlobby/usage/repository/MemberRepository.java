package com.nlobby.usage.repository;

import com.nlobby.usage.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {

}
