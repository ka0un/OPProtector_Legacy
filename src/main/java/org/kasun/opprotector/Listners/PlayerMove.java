package org.kasun.opprotector.Listners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.kasun.opprotector.OPProtector_Legacy;
import org.kasun.opprotector.Punishments.Lockdown;

public class PlayerMove implements Listener {
    Lockdown lockdown;
    OPProtector_Legacy plugin = OPProtector_Legacy.getInstance();
    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerMove(PlayerMoveEvent e) {
        lockdown = plugin.getMainManager().getPunishmentManager().getLockdown();
        boolean allow = plugin.getMainManager().getConfigManager().getMainConfig().block_player_move;

        if (allow && lockdown.isPlayerLocked(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
}