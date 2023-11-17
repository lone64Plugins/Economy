package org.lone64.mconomy.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.lone64.economy.api.EconomyResponse;
import org.lone64.mconomy.Mconomy;
import org.lone64.wrapper.builder.command.CommandBuilder;
import org.lone64.wrapper.util.color.ColorUtil;
import org.lone64.wrapper.util.math.IntUtil;

public class SetMoneyCmd extends CommandBuilder {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String[] args) {
        if (sender instanceof Player player) {
            if (Mconomy.getEconomy().hasAccount(player)) {
                if (args.length == 0) {
                    player.sendMessage(ColorUtil.getColor("&c설정할 금액을 입력해주세요."));
                    return true;
                }

                int amount;
                try {
                    amount = Integer.parseInt(args[0]);
                    if (amount < 0) {
                        player.sendMessage(ColorUtil.getColor("&c설정할 금액은 최소 1원부터 가능합니다."));
                        return true;
                    }
                } catch (NumberFormatException e) {
                    player.sendMessage(ColorUtil.getColor("&c설정할 금액은 숫자만 허용됩니다."));
                    return true;
                }

                EconomyResponse response = Mconomy.getEconomy().setMoney(player, amount);
                if (response.completed()) {
                    int balance = Mconomy.getEconomy().getMoney(player);
                    player.sendMessage(ColorUtil.getColor(String.format("&a당신의 잔고가 업데이트되었습니다! &7(잔고 : %s원)", IntUtil.getNumberFormat(balance))));
                } else {
                    player.sendMessage(ColorUtil.getColor("&c당신의 잔고를 설정하는 도중 오류가 발생했습니다."));
                }
            }
        }
        return false;
    }

}