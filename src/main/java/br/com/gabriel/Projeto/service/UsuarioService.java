package br.com.gabriel.Projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabriel.Projeto.dto.UsuarioDTO;
import br.com.gabriel.Projeto.entity.UsuarioEntity;
import br.com.gabriel.Projeto.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	//READ --> Listar todos os usuarios
	public List<UsuarioDTO> listarTodos(){
		List<UsuarioEntity> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(UsuarioDTO::new).toList();
	}
	
	
	//CREAT --> Criar novos usuarios
	public void inserir(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		usuarioRepository.save(usuarioEntity);
	}
	
	//UPDATE --> Alterar ou atualizar dados
	public UsuarioDTO alterar(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
	}
	
	
	//DELETE --> Exluir usuarios
	public void excluir (Long Id) {
		UsuarioEntity usuario = usuarioRepository.findById(Id).get();
		usuarioRepository.delete(usuario);
	}
	
	public UsuarioDTO buscarPorId(long Id) {
		return new UsuarioDTO(usuarioRepository.findById(Id).get());
	}

}
