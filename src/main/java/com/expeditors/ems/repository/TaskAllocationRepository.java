package com.expeditors.ems.repository;

import com.expeditors.ems.dto.resquest.TaskAllocationRequest;
import com.expeditors.ems.entity.TaskAllocation;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskAllocationRepository extends JpaRepository<TaskAllocation, Integer> {
List<TaskAllocation> findByDevIdId(Integer Dev);
}
