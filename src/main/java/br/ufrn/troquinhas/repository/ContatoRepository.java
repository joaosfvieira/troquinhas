package br.ufrn.troquinhas.repository;

import br.ufrn.troquinhas.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {
}
