package com.nighthawksurvival.chat;

import com.demigodsrpg.chitchat.Chitchat;
import com.demigodsrpg.chitchat.format.ChatFormat;
import com.demigodsrpg.chitchat.tag.PlayerTag;
import com.nighthawksurvival.chat.tags.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * NoneVale
 * 7/29/2015
 * NSChat
 */
public class Chat extends JavaPlugin
{

    private ServerTag SERVER;
    private BetaTag BETA;
    private HeadTag HEAD;
    private TrustedTag TRUSTED;

    public void onEnable() {

        SERVER = new ServerTag();
        BETA = new BetaTag();
        HEAD = new HeadTag();
        TRUSTED = new TrustedTag();

        ChatFormat format = Chitchat.getChatFormat();

        format.addAll(new PlayerTag[]{SERVER, BETA, HEAD, TRUSTED});

        for (RankTags tags : RankTags.values()) {
            format.add(tags.getTag());
        }

        if (Bukkit.getPluginManager().isPluginEnabled("NSGuilds"))
        {
            format.add(new GuildTag());
        }
    }

    public void onDisable() {
    }
}
