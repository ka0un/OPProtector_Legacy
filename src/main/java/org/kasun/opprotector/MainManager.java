package org.kasun.opprotector;

import org.kasun.opprotector.Scanner.LiveScanner;
import org.kasun.opprotector.AuthObjects.TempAuth;
import org.kasun.opprotector.Commands.CommandsManager;
import org.kasun.opprotector.Configs.ConfigManager;
import org.kasun.opprotector.Listners.ListnerManager;
import org.kasun.opprotector.Punishments.PunishmentManager;
import org.kasun.opprotector.Utils.Log;
import org.kasun.opprotector.VerificationProcess.VerificationProcessManager;

public class MainManager {
    private ConfigManager configManager;
    private ListnerManager listnerManager;
    private PunishmentManager punishmentManager;
    private TempAuth tempAuth;
    private CommandsManager commandsManager;
    private VerificationProcessManager verificationProcessManager;
    private LiveScanner liveScanner;
    private Log log;
    OPProtector_Legacy plugin = OPProtector_Legacy.getInstance();
    public MainManager() {
        configManager = new ConfigManager();
        listnerManager = new ListnerManager();
        punishmentManager = new PunishmentManager();
        commandsManager = new CommandsManager();
        tempAuth = new TempAuth();
        verificationProcessManager = new VerificationProcessManager();
        liveScanner = new LiveScanner();
        log = new Log();

    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public ListnerManager getListnerManager() {
        return listnerManager;
    }

    public PunishmentManager getPunishmentManager() {
        return punishmentManager;
    }

    public TempAuth getAuthorizedPlayers() {
        return tempAuth;
    }

    public CommandsManager getCommandsManager() {
        return commandsManager;
    }

    public VerificationProcessManager getVerificationProcessManager() {
        return verificationProcessManager;
    }

    public LiveScanner getLiveScanner() {
        return liveScanner;
    }

    public Log getLog() {
        return log;
    }

}
