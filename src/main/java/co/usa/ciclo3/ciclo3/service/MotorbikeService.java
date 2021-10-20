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

}
