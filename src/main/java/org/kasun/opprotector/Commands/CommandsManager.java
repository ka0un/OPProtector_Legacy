package org.kasun.opprotector.Commands;

import org.kasun.opprotector.OPProtector_Legacy;

public class CommandsManager {
    public CommandsManager() {
        OPProtector_Legacy plugin = OPProtector_Legacy.getInstance();
        plugin.getCommand("pas").setExecutor(new Pas());
    }
}
