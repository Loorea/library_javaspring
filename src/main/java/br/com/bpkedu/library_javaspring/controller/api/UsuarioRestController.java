package br.com.bpkedu.library_javaspring.controller.api;

import br.com.bpkedu.library_javaspring.model.Usuario;
import br.com.bpkedu.library_javaspring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioRestController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/getAll")
    public List<Usuario> getUsuarios(){
        return usuarioService.listarTodos();
    }

}