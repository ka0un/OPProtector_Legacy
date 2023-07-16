package org.kasun.opprotector.VerificationProcess;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.kasun.opprotector.OPProtector;
import org.kasun.opprotector.Punishments.Ban;

public class PasswordFlash {
    private BukkitTask titleTask;
    private BukkitTask countdownTask;
    private boolean stopTasks = false;
    private int countdownSeconds = 20;
    private Player player;
    private OPProtector plugin = OPProtector.getInstance();
    public PasswordFlash(Player Player) {
        this.player = Player;
    }

    public void start(){
        titleTask = new BukkitRunnable() {
            boolean flash = false;

            @Override
            public void run() {

                    if (flash) {
                        player.sendTitle(ChatColor.RED + "⚠", "", 0, 20, 0);
                        Sound sound = Sound.BLOCK_NOTE_BLOCK_HARP;
                        player.playSound(player.getLocation(), sound, 1, 1);
                    } else {
                        player.sendTitle("", "", 0, 20, 0);
                    }

                flash = !flash;
            }
        }.runTaskTimer(plugin, 0, 10); // Change the flashing interval if desired (10 ticks = 0.5 seconds)

        countdownTask = new BukkitRunnable() {
            int remainingTime = plugin.getMainManager().getConfigManager().getMainConfig().interval_secounds;
            @Override
            public void run() {
                if (remainingTime > 0) {
                    player.sendMessage(ChatColor.RED + "You have " + remainingTime + " seconds to enter the password.(/pas <password>)");
                    remainingTime--;
                } else {
                    Ban ban = new Ban(player, "You didnt enter the password in time", "Unautharized Access");
                    cancel();
                }
            }
        }.runTaskTimer(plugin, 0, 20); // Change the countdown interval if desired (20 ticks = 1 second)
    }

    public void stopTasks() {
        stopTasks = true;
        if (titleTask != null) {
            titleTask.cancel();
        }
        if (countdownTask != null) {
            countdownTask.cancel();
        }
    }


}
