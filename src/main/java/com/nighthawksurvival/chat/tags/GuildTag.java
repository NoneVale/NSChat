package com.nighthawksurvival.chat.tags;

import com.demigodsrpg.chitchat.tag.PlayerTag;
import com.nighthawksurvival.lib.libraries.Guild;
import com.nighthawksurvival.lib.player.NSPlayer;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

/**
 * NoneVale
 * 7/29/2015
 * NSChat
 */
public class GuildTag extends PlayerTag {
    @Override
    public String getName() {
        return "Guild Tag";
    }

    @Override
    public int getPriority() {
        return 3;
    }

    @Override
    public TextComponent getComponentFor(Player player) {
        NSPlayer nsPlayer = new NSPlayer(player);
        if (nsPlayer.hasGuild()) {
            Guild guild = new Guild(nsPlayer.getGuild());
            TextComponent tag = new TextComponent("[");
            tag.setColor(ChatColor.DARK_GRAY);
            TextComponent gu = new TextComponent(guild.getName());
            gu.setColor(ChatColor.valueOf(guild.getColor()));
            tag.addExtra(gu);
            tag.addExtra("]");
            tag.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(ChatColor.valueOf(guild.getColor()) + guild.getName())));
            tag.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/g show " + guild.getName()));
            return tag;
        }
        return null;
    }
}
