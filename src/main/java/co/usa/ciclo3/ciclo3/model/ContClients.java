/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.ciclo3.ciclo3.model;

/**
 *
 * @author  JOSE DAVID AMAYA
 */
public class ContClients {
    private long total;
    private Client client;
    
    public ContClients(Long total, Client client){
        this.total =total;
        this.client= client;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
}
