package com.expeditors.ems.repository;

import com.expeditors.ems.entity.ExpenseDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<ExpenseDetailEntity,Integer> {
}
