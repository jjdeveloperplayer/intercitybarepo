package ba.br.com.intercity.intercitybaservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import ba.br.com.intercity.intercitybaservices.entities.Empresa;

@Repository
public interface EmpresaRepository
    extends JpaRepository<Empresa, Long> { }
