package pe.edu.upc.model.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.edu.upc.model.entity.Bond;
import pe.edu.upc.model.entity.Cupon;

@Repository
public interface CuponRepository extends JpaRepository<Cupon,Integer>
{
    @Query(value = "select b from Cupon b where b.idBond =:idBono")
    List<Cupon> CuponsBond(@Param("idBono") Bond idBono);
}