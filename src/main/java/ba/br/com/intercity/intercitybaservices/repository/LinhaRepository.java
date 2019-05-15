package ba.br.com.intercity.intercitybaservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import ba.br.com.intercity.intercitybaservices.entities.Linha;

@Repository
public interface LinhaRepository
    extends JpaRepository<Linha, Long> { }