/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.repository.crud;

import co.usa.ciclo3.ciclo3.model.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author 57314
 */
public interface MessageCrudRepository  extends CrudRepository<Message,Integer>{
    
}
