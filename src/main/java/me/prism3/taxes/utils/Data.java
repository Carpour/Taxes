package me.prism3.taxes.utils;

import me.prism3.taxes.Main;
import me.prism3.taxes.commands.CommandManager;

public class Data {

    private final Main main = Main.getInstance();

    public static String pluginVersion;
    public static String serverName;
    public static String pluginPrefix;

    public static int dataBaseDataDeletion;
    public static int totalStrikes;

    public static double fine;

    public static boolean isLogInteractions;
    public static boolean isDatabase;
    public static boolean isPrison;
    public static boolean isPluginPrison;

    // Permissions
    public static String taxesAdmin;

    public void initializeStrings() {

        pluginVersion = this.main.getDescription().getVersion();
        serverName = this.main.getConfig().getString("Server-Name");
        pluginPrefix = this.main.getConfig().getString("Plugin-Prefix");
    }

    public void initializeIntegers() {

        dataBaseDataDeletion = this.main.getConfig().getInt("Database.Data-Deletion");
    }

    public void initializeDoubles() {

        fine = this.main.getConfig().getDouble("Fine");
        totalStrikes = this.main.getConfig().getInt("Prison.Total-Strikes");
    }

    public void initializeBooleans() {

        isLogInteractions = this.main.getConfig().getBoolean("Log-Interactions");
        isDatabase = this.main.getConfig().getBoolean("Database.Enable");
        isPrison = this.main.getConfig().getBoolean("Prison.Enable");
        isPluginPrison = this.main.getConfig().getBoolean("Prison.Plugin-Prison");
    }

    public void initializePermissions() {

        taxesAdmin = "taxes.admin";
    }

    public void initializeCommands() {

        this.main.getCommand("taxes").setExecutor(new CommandManager());
    }
}
