package br.ufrn.troquinhas.repository;

import br.ufrn.troquinhas.model.Colecionador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Colecionador, Integer> {
}
