/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.javaProjetapiv3.service;

import com.sir.javaProjetapiv3.bean.Commande;
import com.sir.javaProjetapiv3.bean.CommandeItem;
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface CommandeItemService {
    public int save(Commande commande);
    public List<CommandeItem> findByCommande(Commande commande);

    
}
