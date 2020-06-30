package pe.edu.upc.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.entity.UserApp;

@Repository
public interface UserRepository extends JpaRepository<UserApp,Integer>{
    
    @Query(value = "select b.id from UserApp b where b.username=:username and b.password=:password")
    int logIn(@Param("username") String username,@Param("password") String password);

    @Query(value = "select COUNT(b.id) from UserApp b where b.username=:username and b.password=:password")
    int validator(@Param("username") String username,@Param("password") String password);
}