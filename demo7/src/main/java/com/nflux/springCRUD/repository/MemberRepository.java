package com.nflux.springCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.nflux.springCRUD.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

}