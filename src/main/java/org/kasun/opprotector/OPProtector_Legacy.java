package org.kasun.opprotector;


import org.bukkit.plugin.java.JavaPlugin;

public final class OPProtector_Legacy extends JavaPlugin {
    private static OPProtector_Legacy instance;
    private boolean isFirstTime;
    MainManager mainManager;


    @Override
    public void onEnable() {
        instance = this;
        fisttimecheck();
        mainManager = new MainManager();


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static OPProtector_Legacy getInstance() {
        return instance;
    }

    public void fisttimecheck() {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
            isFirstTime = true;
        }
    }

    public boolean isFirstTime() {
        return isFirstTime;
    }

    public MainManager getMainManager() {
        return mainManager;
    }


}
