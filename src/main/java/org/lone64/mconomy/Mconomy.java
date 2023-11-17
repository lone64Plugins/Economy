package org.lone64.mconomy;

import org.bukkit.plugin.java.JavaPlugin;
import org.lone64.economy.EconomyAPI;
import org.lone64.economy.api.Economy;
import org.lone64.mconomy.command.MyMoneyCmd;
import org.lone64.mconomy.command.SetMoneyCmd;

public final class Mconomy extends JavaPlugin {

    private static Mconomy instance;
    private static Economy economy;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        economy = EconomyAPI.getInstance();

        getCommand("mymoney").setExecutor(new MyMoneyCmd());
        getCommand("setmoney").setExecutor(new SetMoneyCmd());
    }

    @Override
    public void onDisable() {

    }

    public static Mconomy getInstance() {
        return instance;
    }

    public static Economy getEconomy() {
        return economy;
    }

}