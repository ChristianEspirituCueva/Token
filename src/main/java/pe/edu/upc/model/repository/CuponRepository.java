package model.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import model.entity.Cupon;

@Repository
public interface CuponRepository extends JpaRepository<Cupon,Integer>
{
    
}