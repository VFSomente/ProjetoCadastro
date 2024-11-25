package com.lifefitness.Service;

import com.lifefitness.repository.UsuarioRepository;
import com.lifefitness.Entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Listar todos os usuários
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // Buscar um usuário por ID
    public Usuario getUsuarioById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    // Salvar um novo usuário
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Atualizar um usuário existente
    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();
            // Atualizando os campos do usuário existente
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setSobrenome(usuarioAtualizado.getSobrenome());
            usuario.setEmail(usuarioAtualizado.getEmail());
            usuario.setSenha(usuarioAtualizado.getSenha());
            usuario.setCpf(usuarioAtualizado.getCpf());
            usuario.setTelefone(usuarioAtualizado.getTelefone());
            usuario.setExperiencia(usuarioAtualizado.getExperiencia());
            usuario.setPlano(usuarioAtualizado.getPlano());

            // Salvando o usuário atualizado
            return usuarioRepository.save(usuario);
        } else {
            return null; // Usuário não encontrado
        }
    }

    // Remover um usuário
    public void removerUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
