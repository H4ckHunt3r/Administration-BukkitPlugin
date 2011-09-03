/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.H4ckHunt3r.Administration;

import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

/**
 *
 * @author H4ckHunt3r
 */
public class AdministrationPlayerListener extends PlayerListener {
    private Administration plugin = null;
    
    public AdministrationPlayerListener()
    {
       this.plugin = plugin;
    }
    
    public void onPlayerJoin(PlayerJoinEvent e)
    {
        Player p = e.getPlayer();
        e.setJoinMessage("Player "+p.getDisplayName()+" joined the Server!");
    }
    
    public void onPlayerQuit(PlayerQuitEvent e)
    {
        Player p = e.getPlayer();
        e.setQuitMessage("Player "+p.getDisplayName()+" left the Server!");
    }
    
    public void onPlayerInteract(PlayerInteractEvent e)
    {
        if(Administration.instantPlayers.contains(e.getPlayer()) && e.getAction().equals(Action.LEFT_CLICK_BLOCK))
        {
            if(!(e.getClickedBlock().getTypeId()==7))
            {
                e.getClickedBlock().setTypeId(0);
            } else {
                if(e.getPlayer().hasPermission("admin.break.bedrock"))
                {
                    e.getClickedBlock().setTypeId(0);
                }
            }
        }
        if(Administration.infinitePlayers.contains(e.getPlayer()) && e.getAction().equals(Action.RIGHT_CLICK_BLOCK))
        {
            if(e.getPlayer().getItemInHand().getAmount()==1 && !(e.getPlayer().getItemInHand().getTypeId()==0))
            {
                e.getPlayer().getItemInHand().setAmount(e.getPlayer().getItemInHand().getMaxStackSize());
            }
        }
    }
        
}
