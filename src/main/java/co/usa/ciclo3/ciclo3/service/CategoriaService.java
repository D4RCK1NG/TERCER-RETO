package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Category> getAll() {
        return categoriaRepository.getAll();
    }

    public Optional<Category> getCategoria(int id) {
        return categoriaRepository.getCategoria(id);
    }

    public Category save(Category categoria) {
        if (categoria.getId() == null) {
            return categoriaRepository.save(categoria);
        } else {
            Optional<Category> paux = categoriaRepository.getCategoria(categoria.getId());
            if (paux.isEmpty()) {
                return categoriaRepository.save(categoria);
            } else {
                return categoria;
            }
        }
    }
}
