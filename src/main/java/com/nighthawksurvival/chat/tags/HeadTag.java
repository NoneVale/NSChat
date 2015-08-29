package com.nighthawksurvival.chat.tags;

import com.demigodsrpg.chitchat.tag.PlayerTag;
import com.nighthawksurvival.lib.player.NSPlayer;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

/**
 * Created by NoneVale on 8/25/2015.
 */
public class HeadTag extends PlayerTag {
    @Override
    public String getName() {
        return "Head Tag";
    }

    @Override
    public int getPriority() {
        return 7;
    }

    @Override
    public TextComponent getComponentFor(Player player) {
        NSPlayer offlinePlayer = new NSPlayer(player);
        if (offlinePlayer.isHead()) {
            TextComponent tag = new TextComponent("[");
            tag.setColor(ChatColor.DARK_GRAY);
            TextComponent beta = new TextComponent("H");
            beta.setColor(ChatColor.YELLOW);
            beta.setBold(true);
            tag.addExtra(beta);
            tag.addExtra("]");
            String b = ChatColor.YELLOW + "" + ChatColor.BOLD + "HEAD";
            tag.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(b)));
            return tag;
        }
        return null;
    }
}
