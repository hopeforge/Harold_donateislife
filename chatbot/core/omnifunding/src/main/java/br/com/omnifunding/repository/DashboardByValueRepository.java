package br.com.omnifunding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.omnifunding.model.DashboardByValue;

@Repository
public interface DashboardByValueRepository extends JpaRepository<DashboardByValue, Integer> {

}
