package com.nighthawksurvival.chat.tags;

import com.demigodsrpg.chitchat.tag.PlayerTag;
import com.nighthawksurvival.lib.player.NSPlayer;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

/**
 * NoneVale
 * 8/22/2015
 * NSChat
 */
public class BetaTag extends PlayerTag {
    @Override
    public String getName() {
        return "Beta Tag";
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public TextComponent getComponentFor(Player player) {
        NSPlayer offlinePlayer = new NSPlayer(player);
        if (offlinePlayer.isBeta()) {
            TextComponent tag = new TextComponent("[");
            tag.setColor(ChatColor.DARK_GRAY);
            TextComponent beta = new TextComponent("B");
            beta.setColor(ChatColor.GOLD);
            beta.setBold(true);
            tag.addExtra(beta);
            tag.addExtra("]");
            String b = ChatColor.GOLD + "" + ChatColor.BOLD + "BETA";
            tag.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(b)));
            return tag;
        }
        return null;
    }
}
