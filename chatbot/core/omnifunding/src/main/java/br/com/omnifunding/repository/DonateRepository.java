package br.com.omnifunding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.omnifunding.model.Donate;

public interface DonateRepository extends JpaRepository<Donate, Long> {

}
