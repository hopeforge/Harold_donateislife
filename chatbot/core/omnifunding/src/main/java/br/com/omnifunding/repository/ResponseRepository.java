package br.com.omnifunding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.omnifunding.model.Responses;

@Repository
public interface ResponseRepository extends JpaRepository<Responses, Long> {

}
