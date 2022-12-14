package ufrn.br.ProjetoRestJustica.controller.generic;

import org.springframework.http.ResponseEntity;
import ufrn.br.ProjetoRestJustica.model.generic.AbstractEntity;

import java.util.List;

public interface InterfaceGenericController<E extends AbstractEntity> {

    List<E> listAll();

    ResponseEntity<E> create(E e);
    ResponseEntity<E> findById(Long id);
    ResponseEntity<E> update(Long id, E e);
    ResponseEntity<?>  delete(Long id);

}
