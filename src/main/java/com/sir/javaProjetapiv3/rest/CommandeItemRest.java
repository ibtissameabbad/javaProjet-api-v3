/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.javaProjetapiv3.rest;

import com.sir.javaProjetapiv3.bean.Commande;
import com.sir.javaProjetapiv3.bean.CommandeItem;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sir.javaProjetapiv3.service.CommandeItemService;

/**
 *
 * @author lenovo
 */
@RestController()
@RequestMapping({"/commande-api-v3/commandeItems"})
public class CommandeItemRest {
    
@Autowired
    private CommandeItemService commandeItemService;

    public CommandeItemService getCommandeItemService() {
        return commandeItemService;
    }

    public void setCommandeItemService(CommandeItemService commandeItemService) {
        this.commandeItemService = commandeItemService;
    }

   
     @GetMapping("/commande/{commande}")
       public List<CommandeItem> findByCommande(Commande commande){
         return commandeItemService.findByCommande(commande);
                 }
    @PostMapping("/")
    public int save(@RequestBody Commande commande){
        return commandeItemService.save(commande);
    }
    
}