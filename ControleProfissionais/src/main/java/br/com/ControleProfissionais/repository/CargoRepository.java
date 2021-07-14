package br.com.ControleProfissionais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ControleProfissionais.entity.CargoEntity;

@Repository
public interface CargoRepository extends JpaRepository<CargoEntity, Long> {


}
