package co.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/* 
@author JOSE DAVID AMAYA
 */
@Entity
/*
nombre tabla motorbike
 */
@Table(name = "motorbike")
public class Motorbike implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*
    creacion de variables y/o valores de tabla motorbike
     */
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;
    /*
    relacion  tabla category 
     */
    @ManyToOne
    @JoinColumn(name = "categoryid")
    @JsonIgnoreProperties("motorbikes")
    private Category category;

    /*
    relacion  tablas message
    */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "motorbike")
    @JsonIgnoreProperties({"motorbike", "client"})
    private List<Message> messages;
    
    /*
    relacion tabla reservation
    */

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "motorbike")
    @JsonIgnoreProperties({"motorbike", "client"})
    public List<Reservation> reservations;

    /* 
    se generan getter id
     */
    public Integer getId() {
        return id;
    }
  /* 
    se generan getter id
     */
    public void setId(Integer id) {
        this.id = id;
    }
  /* 
    se generan getter name
     */
    public String getName() {
        return name;
    }
  /* 
    se generan setter name
     */
    public void setName(String name) {
        this.name = name;
    }
  /* 
    se generan getter brand
     */
    public String getBrand() {
        return brand;
    }
  /* 
    se generan setter brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }
  /* 
    se generan getter year
     */
    public Integer getYear() {
        return year;
    }
  /* 
    se generan setter year
     */
    public void setYear(Integer year) {
        this.year = year;
    }
  /* 
    se generan getter description
     */
    public String getDescription() {
        return description;
    }
  /* 
    se generan setter description
     */
    public void setDescription(String description) {
        this.description = description;
    }
  /* 
    se generan getter category
     */
    public Category getCategory() {
        return category;
    }
  /* 
    se generan setter category
     */
    public void setCategory(Category category) {
        this.category = category;
    }
  /* 
    se generan getter message
     */
    public List<Message> getMessages() {
        return messages;
    }
  /* 
    se generan setter message
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
  /* 
    se generan getter reservation
     */
    public List<Reservation> getReservations() {
        return reservations;
    }
  /* 
    se generan ssetter reservation
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}
