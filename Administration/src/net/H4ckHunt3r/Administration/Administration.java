/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.H4ckHunt3r.Administration;

import java.util.HashSet;
import java.util.Set;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author H4ckHunt3r
 */
public class Administration extends JavaPlugin {
    private AdministrationPlayerListener playerListener = null;
    private AdministrationEntityListener entityListener = null;
    
    public static Set<Player> instantPlayers = null;
    public static Set<Player> godPlayers = null;
    public static Set<Player> infinitePlayers = null;

    @Override
    public void onDisable() {
        System.out.print("Plugin \"Administration\" (dev by H4ckHunt3r.NET) unloaded!");
        this.playerListener = new AdministrationPlayerListener();
        this.entityListener = new AdministrationEntityListener();
        
        instantPlayers = new HashSet<Player>();
        godPlayers = new HashSet<Player>();
        infinitePlayers = new HashSet<Player>();
        
        registerHooks();
        PluginDescriptionFile pdfFile = this.getDescription();
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel1, String[] args)
    {
        if(!(sender instanceof Player))
        {
            return false;
        }
        Player p = (Player) sender;
        
        // HEAL
        if(cmd.getName().equalsIgnoreCase("heal"))
        {
            if(checkPerms("admin.cmd.heal",p)){ return false; }
            return net.H4ckHunt3r.Administration.cmd.heal.heal(p, args, this.getServer());
        }
        
        return false;
    }
    
    public boolean checkPerms(String perm, Player chP)
    {
        if(!(chP.hasPermission(perm)||chP.isOp()))
        {
            chP.sendMessage("You dont have the permission ("+perm+") to do that!");
            return true;
        }
        return false;
    }
    
    public void registerHooks()
    {
        PluginManager em = this.getServer().getPluginManager();
        em.registerEvent(Type.PLAYER_JOIN, playerListener, Priority.Normal, this);
        em.registerEvent(Type.PLAYER_QUIT, playerListener, Priority.Normal, this);
        em.registerEvent(Type.PLAYER_INTERACT, playerListener, Priority.Normal, this);
        em.registerEvent(Type.ENTITY_DAMAGE, entityListener, Priority.Normal, this);
    }

    @Override
    public void onEnable() {
        System.out.print("Plugin \"Administration\" (dev by H4ckHunt3r.NET) loaded!");
    }
    
}
