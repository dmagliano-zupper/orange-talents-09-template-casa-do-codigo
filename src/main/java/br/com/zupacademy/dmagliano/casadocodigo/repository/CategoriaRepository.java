package br.com.zupacademy.dmagliano.casadocodigo.repository;

import br.com.zupacademy.dmagliano.casadocodigo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Optional<Categoria> findByNome(String nome);
}
