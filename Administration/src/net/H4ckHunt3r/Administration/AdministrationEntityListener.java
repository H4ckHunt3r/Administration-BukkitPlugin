/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.H4ckHunt3r.Administration;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityListener;

/**
 *
 * @author H4ckHunt3r
 */
public class AdministrationEntityListener extends EntityListener {
    private Administration plugin = null;
    
    public AdministrationEntityListener()
    {
       this.plugin = plugin;
    }
    
    public void onEntityDamage(EntityDamageEvent e)
    {
        
        // God
        if(e.isCancelled())
            return;
        if(!(e.getEntity() instanceof Player))
            return;
        Player cp = (Player)e.getEntity();
        if(Administration.godPlayers.contains(cp))
        {
            e.setCancelled(true);
            e.setDamage(0);
        }
                
    }
    
}
