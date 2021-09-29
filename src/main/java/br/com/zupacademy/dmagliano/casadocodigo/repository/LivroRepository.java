package br.com.zupacademy.dmagliano.casadocodigo.repository;

import br.com.zupacademy.dmagliano.casadocodigo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
