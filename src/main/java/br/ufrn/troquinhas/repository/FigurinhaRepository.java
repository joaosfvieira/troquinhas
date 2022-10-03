package br.ufrn.troquinhas.repository;

import br.ufrn.troquinhas.model.Figurinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FigurinhaRepository extends JpaRepository<Figurinha, Integer> {
}
