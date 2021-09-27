package br.com.zupacademy.dmagliano.casadocodigo.repository;

import br.com.zupacademy.dmagliano.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
