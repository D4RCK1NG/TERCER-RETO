package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.repository.crud.CategoriaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository {
    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;

    public List<Category> getAll(){
        return (List<Category>) categoriaCrudRepository.findAll();
    }
    public Optional<Category>getCategoria(int id){
        return categoriaCrudRepository.findById(id);
    }
    public Category save(Category categoria){
        return categoriaCrudRepository.save(categoria);
    }
    public void delete(Category category){
        categoriaCrudRepository.delete(category);
    }
}
