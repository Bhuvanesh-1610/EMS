package com.expeditors.ems.repository;

import com.expeditors.ems.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<CandidateEntity,Integer> {
   // List<CandidateEntity> findByHIringStatusId(Integer id);
}
