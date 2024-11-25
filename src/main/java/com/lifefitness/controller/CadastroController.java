package com.lifefitness.controller;

import com.lifefitness.Entity.Usuario;
import com.lifefitness.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class CadastroController {

    @Autowired
    private UsuarioService usuarioService;

    // Listar todos os usuários
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    // Buscar usuário por ID
    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id);
    }

    // Criar um novo usuário
    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.salvarUsuario(usuario);
    }

    // Atualizar um usuário existente
    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
        Usuario usuario = usuarioService.atualizarUsuario(id, usuarioAtualizado);
        if (usuario != null) {
            return usuario;
        } else {
            // Caso o usuário não tenha sido encontrado, retorna um status 404
            throw new RuntimeException("Usuário não encontrado para atualização");
        }
    }

    // Remover um usuário
    @DeleteMapping("/{id}")
    public void removerUsuario(@PathVariable Long id) {
        usuarioService.removerUsuario(id);
    }
}
