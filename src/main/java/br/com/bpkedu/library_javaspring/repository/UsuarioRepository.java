package br.com.bpkedu.library_javaspring.repository;

import br.com.bpkedu.library_javaspring.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
