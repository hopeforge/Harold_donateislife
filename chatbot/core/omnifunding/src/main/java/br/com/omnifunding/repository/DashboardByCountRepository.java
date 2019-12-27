package br.com.omnifunding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.omnifunding.model.DashboardByCount;

@Repository
public interface DashboardByCountRepository extends JpaRepository<DashboardByCount, Integer> {

}
