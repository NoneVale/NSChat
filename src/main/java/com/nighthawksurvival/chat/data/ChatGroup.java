package com.nighthawksurvival.chat.data;

import com.google.common.collect.Lists;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by NoneVale on 8/28/2015.
 */
public class ChatGroup {

    private static ArrayList<Player> guild = Lists.newArrayList();
    private static ArrayList<Player> allies = Lists.newArrayList();
    private static ArrayList<Player> staff = Lists.newArrayList();

    public static ArrayList<Player> getStaff() {
        return staff;
    }

    public static ArrayList<Player> getGuild() {
        return guild;
    }

    public static ArrayList<Player> getAllies() {
        return allies;
    }

    public static boolean staffGroupContains(Player player) {
        return getStaff().contains(player);
    }

    public static boolean guildGroupContains(Player player) {
        return getGuild().contains(player);
    }

    public static boolean allyGroupContains(Player player) {
        return getAllies().contains(player);
    }

    public static void addToStaffGroup(Player player) {
        getStaff().add(player);
    }

    public static void addToGuildGroup(Player player) {
        getGuild().add(player);
    }

    public static void addToAllyGroup(Player player) {
        getAllies().add(player);
    }

    public static void removeFromStaffGroup(Player player) {
        getStaff().remove(player);
    }

    public static void removeFromGuildGroup(Player player) {
        getGuild().remove(player);
    }

    public static void removeFromAllyGroup(Player player) {
        getAllies().remove(player);
    }

    public static void clearStaffGroup() {
        getStaff().clear();
    }

    public static void clearGuildGroup() {
        getGuild().clear();
    }

    public static void clearAllyGroup() {
        getAllies().clear();
    }

    public static void clearAllGroups() {
        clearAllyGroup();
        clearGuildGroup();
        clearStaffGroup();
    }
}
