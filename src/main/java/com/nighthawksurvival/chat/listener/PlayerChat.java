package com.nighthawksurvival.chat.listener;

import com.nighthawksurvival.chat.data.ChatGroup;
import com.nighthawksurvival.lib.Lib;
import com.nighthawksurvival.lib.libraries.Guild;
import com.nighthawksurvival.lib.player.NSPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import static com.nighthawksurvival.chat.data.ChatGroup.*;

/**
 * Created by NoneVale on 8/28/2015.
 */
public class PlayerChat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        NSPlayer nsPlayer = Lib.getNSPlayer(player);

        if (allyGroupContains(player)) {
            event.setCancelled(true);
            Guild[] guildies = new Guild[]{};

            Guild guild = Lib.getGuild(nsPlayer);
            for (Guild guilds : guildies) {
                for (Player players : guilds.getOnlineMembers()) {
                    players.sendMessage("message allies");
                }
            }
        }
        else if (guildGroupContains(player)) {
            event.setCancelled(true);

            Guild guild = Lib.getGuild(nsPlayer);
            for (Player players: guild.getOnlineMembers()) {
                players.sendRawMessage("message guild");
            }
        }
        else if (staffGroupContains(player)) {
            event.setCancelled(true);

            for (Player players : Bukkit.getOnlinePlayers()) {
                if (players.hasPermission("ns.staff")) {
                    players.sendMessage("message staff");
                }
            }
        }
    }
}
