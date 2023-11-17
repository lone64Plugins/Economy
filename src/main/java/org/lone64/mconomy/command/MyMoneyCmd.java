package org.lone64.mconomy.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.lone64.mconomy.Mconomy;
import org.lone64.wrapper.builder.command.CommandBuilder;
import org.lone64.wrapper.util.color.ColorUtil;
import org.lone64.wrapper.util.math.IntUtil;

public class MyMoneyCmd extends CommandBuilder {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String[] args) {
        if (sender instanceof Player player) {
            if (Mconomy.getEconomy().hasAccount(player)) {
                int balance = Mconomy.getEconomy().getMoney(player);
                player.sendMessage(ColorUtil.getColor(String.format("&a%s님의 잔고는 %s원입니다.", player.getName(), IntUtil.getNumberFormat(balance))));
            }
        }
        return false;
    }

}