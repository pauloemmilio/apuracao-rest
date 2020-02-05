package com.paulo.apuracao.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paulo.apuracao.models.Quesito;

@Repository
public interface QuesitoRepository extends JpaRepository<Quesito, Long> {

}
