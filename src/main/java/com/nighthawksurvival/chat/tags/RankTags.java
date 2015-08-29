package com.nighthawksurvival.chat.tags;

import com.demigodsrpg.chitchat.tag.DefaultPlayerTag;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

/**
 * NoneVale
 * 8/25/2015
 * NSChat
 */
public enum RankTags {

    OWNER("Owner", 9, ChatColor.DARK_GREEN, "Owner"),
    ADMIN("Admin", 9, ChatColor.RED, "Admin"),
    MOD("Mod", 9, ChatColor.DARK_AQUA, "Mod"),
    BUILDER("Builder", 9, ChatColor.YELLOW, "Builder"),
    GUEST("Guest", 9, ChatColor.GRAY, "-"),
    DONOR10("Donor 10", 6, ChatColor.DARK_PURPLE, "10"),
    DONOR20("Donor 20", 6, ChatColor.DARK_PURPLE, "20"),
    DONOR30("Donor 30", 6, ChatColor.DARK_PURPLE, "30"),
    DONOR40("Donor 40", 6, ChatColor.DARK_PURPLE, "40"),
    DONOR50("Donor 50", 6, ChatColor.DARK_PURPLE, "50"),
    DONOR60("Donor 60", 6, ChatColor.DARK_PURPLE, "60"),
    DONOR70("Donor 70", 6, ChatColor.DARK_PURPLE, "70"),
    DONOR80("Donor 80", 6, ChatColor.DARK_PURPLE, "80"),
    DONOR90("Donor 90", 6, ChatColor.DARK_PURPLE, "90"),
    DONOR100("Donor 100", 6, ChatColor.DARK_PURPLE, "100"),
    DONOR125("Donor 125", 6, ChatColor.DARK_PURPLE, "125"),
    DONOR150("Donor 150", 6, ChatColor.DARK_PURPLE, "150"),
    DONOR175("Donor 175", 6, ChatColor.DARK_PURPLE, "175"),
    DONOR200("Donor 200", 6, ChatColor.DARK_PURPLE, "200");

    private DefaultPlayerTag tag;

    RankTags(String name, int priority, ChatColor color, String midtext) {
        TextComponent tag = new TextComponent("[");
        tag.setColor(ChatColor.DARK_GRAY);
        TextComponent mid = new TextComponent(midtext);
        mid.setColor(color);
        tag.addExtra(mid);
        tag.addExtra("]");
        tag.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(color + name)));
        this.tag = new DefaultPlayerTag(name, "ns.rank." + name.toLowerCase(), tag, priority);
    }

    public DefaultPlayerTag getTag() {
        return tag;
    }
}
