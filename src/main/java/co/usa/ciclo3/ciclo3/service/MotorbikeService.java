package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Motorbike;
import co.usa.ciclo3.ciclo3.repository.MotorbikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorbikeService {

    @Autowired
    private MotorbikeRepository motorbikeRepository;

    public List<Motorbike> getAll(){
        return motorbikeRepository.getAll();
    }

    public Optional<Motorbike> getMotorbike(int id){
        return motorbikeRepository.getMotorbike(id);
    }

    public Motorbike save(Motorbike motorbike){
        if(motorbike.getId()==null){
            return motorbikeRepository.save(motorbike);
        }else{
            Optional<Motorbike> paux=motorbikeRepository.getMotorbike(motorbike.getId());
            if(paux.isEmpty()){
                return motorbikeRepository.save(motorbike);
            }else{
                return motorbike;
            }
        }
    }
public Motorbike update(Motorbike motorbike){
        if(motorbike.getId()!=null){
            Optional<Motorbike> paux=motorbikeRepository.getMotorbike(motorbike.getId());
            if(paux.isEmpty()){
                if(motorbike.getName()!=null){
                    paux.get().setName(motorbike.getName());
                }
                if(motorbike.getBrand()!=null){
                    paux.get().setBrand(motorbike.getBrand());
                }
                if(motorbike.getYear()!=null){
                    paux.get().setYear(motorbike.getYear());
                }
                if(motorbike.getDescription()!=null){
                    paux.get().setDescription(motorbike.getDescription());
                }
                if(motorbike.getCategory()!=null){
                    paux.get().setCategory(motorbike.getCategory());
                }
                motorbikeRepository.save(paux.get());
                return paux.get();
            }else{
                return motorbike;
            }
        }else{
            return motorbike;
        }
    }


    public boolean deleteMotorbike(int motorbikeId) {
        Boolean aBoolean = getMotorbike(motorbikeId).map(motorbike -> {
            motorbikeRepository.delete(motorbike);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
