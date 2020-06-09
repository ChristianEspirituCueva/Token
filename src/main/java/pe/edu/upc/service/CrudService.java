package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {
    T registrar(T t);

    T modificar(T t);

    void eliminar(Integer t);

    Optional<T> listId(Integer id);

    List<T> listar();
}