/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.H4ckHunt3r.Administration.cmd;

import net.H4ckHunt3r.Administration.Administration;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;

/**
 *
 * @author H4ckHunt3r
 */
public class heal extends Administration {
    
    public static boolean heal(Player p, String[] args, Server sv)
    {
        if(args.length != 0)
            {
                Player hp = sv.getPlayer(args[0]);
                
                if(hp instanceof Player)
                {
                    hp.setHealth(20);
                    hp.sendMessage(ChatColor.GOLD+"You Got Healed by "+p.getDisplayName());
                    p.sendMessage(ChatColor.GOLD+"Player "+hp.getDisplayName()+" Got Healed by You!");
                    return true;
                } else {
                    p.sendMessage(ChatColor.RED+"There is no Player with name "+args[0]+"!");
                    return false;
                }
            } else {
                p.setHealth(20);
                p.sendMessage(ChatColor.GOLD+"You Got Healed by "+p.getDisplayName());
                return true;
            }
    }
    
}
