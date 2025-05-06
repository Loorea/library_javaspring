package br.com.bpkedu.library_javaspring.repository;

import br.com.bpkedu.library_javaspring.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {


    List<Livro> findByTitulo(String titulo);


}

