package com.nighthawksurvival.chat.command;

import com.nighthawksurvival.chat.data.ChatGroup;
import com.nighthawksurvival.lib.Lib;
import com.nighthawksurvival.lib.player.NSPlayer;
import com.nighthawksurvival.lib.plugins.Plugins;
import com.nighthawksurvival.lib.util.MSG;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.nighthawksurvival.chat.data.ChatGroup.*;

/**
 * Created by NoneVale on 8/28/2015.
 */
public class ChatGroupCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            NSPlayer nsPlayer = Lib.getNSPlayer(player);
            MSG msg = new MSG(Plugins.CHAT);

            if (player.hasPermission("ns.chatgroup")) {
                if (args.length == 0) {
                    player.sendMessage(msg.getHeader());
                    player.sendMessage(ChatColor.YELLOW + "Available ChatGroups" + ChatColor.GRAY + ":");
                    player.sendMessage(ChatColor.GRAY + "--> " + ChatColor.GRAY + "Global(GA), " + ChatColor.DARK_AQUA + "Guilds(G), " + ChatColor.BLUE + "Allies(A), " +
                    ChatColor.AQUA + "Staff(S)");
                }
                else if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("global") || args[0].equalsIgnoreCase("ga")) {
                        if (guildGroupContains(player)) {
                            removeFromGuildGroup(player);
                        }
                        if (allyGroupContains(player)) {
                            removeFromAllyGroup(player);
                        }
                        if (staffGroupContains(player)) {
                            removeFromStaffGroup(player);
                        }

                        player.sendMessage(msg.getMessage(ChatColor.YELLOW + "Your chat group has been set to" + ChatColor.GRAY + ": " + ChatColor.GRAY + "Global(GA)"));
                    } else if (args[0].equalsIgnoreCase("staff") || args[0].equalsIgnoreCase("s")) {
                        if (!nsPlayer.isStaff()) {
                            player.sendMessage(msg.getMessage(ChatColor.RED + "You must be staff to do this!"));
                            return true;
                        }
                        if (guildGroupContains(player)) {
                            removeFromGuildGroup(player);
                        }
                        if (allyGroupContains(player)) {
                            removeFromAllyGroup(player);
                        }
                        addToStaffGroup(player);
                        player.sendMessage(msg.getMessage(ChatColor.YELLOW + "Your chat group has been set to" + ChatColor.GRAY + ": " + ChatColor.AQUA + "Staff(S)"));
                    } else if (args[0].equalsIgnoreCase("guild") || args[0].equalsIgnoreCase("g")) {
                        if (!nsPlayer.hasGuild()) {
                            player.sendMessage(msg.getMessage(ChatColor.RED + "This requires a guild!"));
                            return true;
                        }
                        if (staffGroupContains(player)) {
                            removeFromStaffGroup(player);
                        }
                        if (allyGroupContains(player)) {
                            removeFromAllyGroup(player);
                        }
                        addToGuildGroup(player);
                        player.sendMessage(msg.getMessage(ChatColor.YELLOW + "Your chat group has been set to" + ChatColor.GRAY + ": " + ChatColor.DARK_AQUA + "Guild(G)"));

                    } else if (args[0].equalsIgnoreCase("allies") || args[0].equalsIgnoreCase("a")) {
                        if (!nsPlayer.hasGuild()) {
                            player.sendMessage(msg.getMessage(ChatColor.RED + "This requires a guild!"));
                            return true;
                        }
                        if (guildGroupContains(player)) {
                            removeFromGuildGroup(player);
                        }
                        if (staffGroupContains(player)) {
                            removeFromStaffGroup(player);
                        }
                        addToAllyGroup(player);
                        player.sendMessage(msg.getMessage(ChatColor.YELLOW + "Your chat group has been set to" + ChatColor.GRAY + ": " + ChatColor.BLUE + "Allies(A)"));

                    } else {
                        player.sendMessage(msg.getMessage(ChatColor.RED + "That is not a valid chatgroup!"));
                        return true;
                    }
                }
                else {
                    player.sendMessage(msg.syntaxError());
                    return true;
                }
            }
            else {
                player.sendMessage(msg.noPerms());
            }
        }
        return true;
    }
}
