package br.com.bpkedu.library_javaspring.service;

import br.com.bpkedu.library_javaspring.model.Usuario;
import br.com.bpkedu.library_javaspring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }

}

