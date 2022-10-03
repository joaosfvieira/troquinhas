package br.ufrn.troquinhas.repository;

import br.ufrn.troquinhas.model.PontoTroca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontoTrocaRepository extends JpaRepository<PontoTroca, Integer> {
}
