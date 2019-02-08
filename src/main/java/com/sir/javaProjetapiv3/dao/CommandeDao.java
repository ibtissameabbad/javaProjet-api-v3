/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.javaProjetapiv3.dao;

import com.sir.javaProjetapiv3.bean.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lenovo
 */
@Repository
public interface CommandeDao extends JpaRepository<Commande,Long>{
    
    public Commande findByReference(String reference);
    
}
