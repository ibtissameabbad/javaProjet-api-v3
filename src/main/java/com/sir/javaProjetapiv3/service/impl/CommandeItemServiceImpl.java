/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.javaProjetapiv3.service.impl;

import com.sir.javaProjetapiv3.bean.Commande;
import com.sir.javaProjetapiv3.bean.CommandeItem;
import com.sir.javaProjetapiv3.dao.CommandeDao;
import com.sir.javaProjetapiv3.dao.CommandeItemDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.sir.javaProjetapiv3.service.CommandeItemService;
import org.springframework.stereotype.Service;

/**
 *
 * @author lenovo
 */
@Service
public class CommandeItemServiceImpl implements CommandeItemService{

    @Autowired
    private CommandeItemDao commandeItemDao;
    @Autowired
    private CommandeDao commandeDao;

    public CommandeDao getCommandeDao() {
        return commandeDao;
    }

    public void setCommandeDao(CommandeDao commandeDao) {
        this.commandeDao = commandeDao;
    }
    

    public CommandeItemDao getCommandeItemDao() {
        return commandeItemDao;
    }

    public void setCommandeItemDao(CommandeItemDao commandeItemDao) {
        this.commandeItemDao = commandeItemDao;
    }

  

    @Override
    public int save(Commande commande) {
        if(commande==null){
            return -1;
        }else{
            double montant=0;
            List<CommandeItem>commandeItems=commande.getCommandeItems();
            for (CommandeItem commandeItem : commandeItems) {
              montant=commandeItem.getPrix()*commandeItem.getQte();
            }
            commande.setTotalPaiment(montant);
            commandeDao.save(commande);
             for (int i = 0; i < commandeItems.size(); i++) {
            CommandeItem commandeItem=commandeItems.get(i);
            commandeItem.setCommande(commande);
            commandeItemDao.save(commandeItem);
        }
             return 1;
    }

   

    
    }

    @Override
    public List<CommandeItem> findByCommande(Commande commande) {
        return commandeItemDao.findByCommande(commande);
    }
}
    

