package br.com.bpkedu.library_javaspring.controller;

import br.com.bpkedu.library_javaspring.model.Livro;
import br.com.bpkedu.library_javaspring.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping("/listar")
    public String listarLivros(Model model) {
        model.addAttribute("livros", livroService.listarTodos());
        return "livros/listar";
    }

    @GetMapping("/{idLivro:\\d+}")
    public String detalharLivro(@PathVariable Long idLivro, Model model) {
        model.addAttribute("livro", livroService.buscarPorId(idLivro));
        return "livros/detalhar";
    }

    @GetMapping("/novo")
    public String formularioNovoLivro(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/novo";
    }

    @PostMapping("/salvar")
    public String salvarLivro(@ModelAttribute Livro livro) {
        livroService.salvar(livro);
        return "redirect:/livros/listar";
    }

    @GetMapping("/editar/{idLivro:\\d+}")
    public String formularioEditarLivro(@PathVariable Long idLivro, Model model) {
        model.addAttribute("livro", livroService.buscarPorId(idLivro));
        return "livros/editar";
    }

    @PostMapping("/editar/{idLivro}")
    public String atualizarLivro(@PathVariable Long idLivro, @ModelAttribute Livro livro) {
        livro.setId(idLivro);
        livroService.salvar(livro);
        return "redirect:/livros/listar";
    }



    @GetMapping("/deletar/{idLivro:\\d+}")
    public String deletarLivro(@PathVariable Long idLivro) {
        livroService.deletar(idLivro);
        return "redirect:/livros/listar";
    }
}