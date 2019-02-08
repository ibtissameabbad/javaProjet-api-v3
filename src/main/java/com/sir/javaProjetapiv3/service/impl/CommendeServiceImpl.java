/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.javaProjetapiv3.service.impl;

import com.sir.javaProjetapiv3.bean.Commande;
import com.sir.javaProjetapiv3.bean.CommandeItem;
import com.sir.javaProjetapiv3.dao.CommandeDao;
import com.sir.javaProjetapiv3.service.CommendeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sir.javaProjetapiv3.service.CommandeItemService;

/**
 *
 * @author lenovo
 */
@Service
public class CommendeServiceImpl implements CommendeService{
  @Autowired
    private CommandeDao commandeDao;
  @Autowired
  private CommandeItemService commanteItemService;

    public CommandeItemService getCommanteItemService() {
        return commanteItemService;
    }

    public void setCommanteItemService(CommandeItemService commanteItemService) {
        this.commanteItemService = commanteItemService;
    }
  
    @Override
    public Commande findByReference(String reference) {
        return commandeDao.findByReference(reference);
    }

    @Override
    public int payer(String reference, double montant) {
        Commande commande=findByReference(reference);
        if(commande==null){
            return -1;
        }else if(commande.getTotalPaiment()+montant>commande.getTotal()){
            return -2;
        }else{
            double nvPaiement=commande.getTotalPaiment()+montant;
            commande.setTotalPaiment(nvPaiement);
            commandeDao.save(commande);
            return 1;
        }
    }

    public CommandeDao getCommandeDao() {
        return commandeDao;
    }

    public void setCommandeDao(CommandeDao commandeDao) {
        this.commandeDao = commandeDao;
    }

    @Override
    public int creer(Commande commande) {
        Commande c=findByReference(commande.getReference());
        if(c!=null){
            return -1;
        }else{
            commande.setTotalPaiment(0);
            commandeDao.save(commande);
            return 1;
        }
    }

    
    
}
