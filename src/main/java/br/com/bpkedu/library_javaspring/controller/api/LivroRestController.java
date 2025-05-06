package br.com.bpkedu.library_javaspring.controller.api;

import br.com.bpkedu.library_javaspring.dto.LivroDTO;
import br.com.bpkedu.library_javaspring.model.Livro;
import br.com.bpkedu.library_javaspring.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/livros")
public class LivroRestController {

    @Autowired
    private LivroService livroService;


    @GetMapping("/getAll")
    public List<Livro> getAll(){
        return livroService.listarTodos();
    }

    @PostMapping()
    public ResponseEntity<Livro> novoLivro(@RequestBody LivroDTO livroDTO){
        Livro livro = livroDTO.toLivro(livroDTO);

        Livro saved =  livroService.salvar(livro);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

}

