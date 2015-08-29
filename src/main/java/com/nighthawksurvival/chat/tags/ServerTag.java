package com.nighthawksurvival.chat.tags;

import com.demigodsrpg.chitchat.tag.PlayerTag;
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
public class ServerTag extends PlayerTag {
    @Override
    public String getName() {
        return "Server Tag";
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public TextComponent getComponentFor(Player player) {
        String ns = ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "Nighthawk " + ChatColor.DARK_RED + "" + ChatColor.BOLD + "Survival";
        TextComponent tag = new TextComponent("[");
        tag.setColor(ChatColor.DARK_GRAY);
        TextComponent n = new TextComponent("N");
        n.setColor(ChatColor.DARK_BLUE);
        n.setBold(true);
        TextComponent s = new TextComponent("S");
        s.setColor(ChatColor.DARK_RED);
        s.setBold(true);
        tag.addExtra(n);
        tag.addExtra(s);
        tag.addExtra("]");
        tag.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(ns)));
        tag.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/info"));
        return tag;
    }
}
