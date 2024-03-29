package me.xiaoxing365.gypchat.bukkit;

import me.xiaoxing365.gypchat.bukkit.Cmds.MainCmd;
import me.xiaoxing365.gypchat.bukkit.Cmds.MainTab;
import me.xiaoxing365.gypchat.bukkit.listeners.ChatListener;
import me.xiaoxing365.gypchat.bukkit.listeners.ChatMuter;
import me.xiaoxing365.gypchat.bukkit.utils.SendUtil;
import net.Zrips.CMILib.Messages.CMIMessages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;


public final class GypChat extends JavaPlugin {

    public static GypChat instance;


    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
        SendUtil.sendToConsole(ChatColor.AQUA+"GYPChat已启动！");
        SendUtil.sendToConsole(ChatColor.AQUA+"末影阁系列插件");
        SendUtil.sendToConsole(ChatColor.AQUA+"作者:xiaoxing365");

        this.getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        Bukkit.getPluginCommand("gc").setExecutor(new MainCmd());
        Bukkit.getPluginCommand("gc").setTabCompleter(new MainTab());
        Bukkit.getPluginManager().registerEvents(new ChatListener(),this);
        Bukkit.getPluginManager().registerEvents(new ChatMuter(),this);
        //Bukkit.getPluginManager().registerEvents(new ChatFilter(),this);

        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")){
            Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"检测到PlaceholderAPI插件，开启变量！");
        }
    }

    @Override
    public void onDisable() {
        CMIMessages.consoleMessage(ChatColor.BLUE+"插件已卸载，感谢使用！");
    }
}
