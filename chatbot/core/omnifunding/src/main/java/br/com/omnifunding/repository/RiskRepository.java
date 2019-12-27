package br.com.omnifunding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.omnifunding.model.Risk;

@Repository
public interface RiskRepository extends JpaRepository<Risk, Long> {

}
