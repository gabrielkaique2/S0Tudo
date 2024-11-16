package br.com.gabriel.Projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabriel.Projeto.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

}
