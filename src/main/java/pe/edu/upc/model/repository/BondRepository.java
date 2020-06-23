package pe.edu.upc.model.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.edu.upc.model.entity.Bond;

@Repository
public interface BondRepository extends JpaRepository<Bond,Integer>{
    
    @Query(value = "Update Bond set tcea=:tcea,tceaEscudo=:tcea_escudo, treaBonista=:trea where id=:")
    void updateBondResults(@Param("id") Integer id,@Param("tcea") double tcea,@Param("tcea_escudo") double tcea_escudo,@Param("trea") double trea);
}