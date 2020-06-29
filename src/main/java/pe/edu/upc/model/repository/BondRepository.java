package pe.edu.upc.model.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.edu.upc.model.entity.Bond;

@Repository
public interface BondRepository extends JpaRepository<Bond,Integer>{
    
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "Update Bond b set b.tcea=:tcea,b.tceaEscudo=:tcea_escudo, b.treaBonista=:trea,b.cPrice =:cprice, b.vna=:vna  where b.id=:id")
    void updateBondResults(@Param("id") int id,@Param("tcea") double tcea,@Param("tcea_escudo") double tcea_escudo,@Param("trea") double trea
    , @Param("cprice") double cPrice, @Param("vna") double vna);
}