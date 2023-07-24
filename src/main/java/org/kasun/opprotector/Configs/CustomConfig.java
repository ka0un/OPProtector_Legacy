package org.kasun.opprotector.Configs;
import org.bukkit.configuration.file.YamlConfiguration;
import org.kasun.opprotector.OPProtector_Legacy;

public class CustomConfig {
    OPProtector_Legacy plugin = OPProtector_Legacy.getInstance();
    //private HashMap<String, Object> Messages;
    private YamlConfiguration yamlConfigurationIp;
    //private YamlConfiguration yamlConfigurationMsg;


    public CustomConfig() {
        if (plugin.isFirstTime()) {
            createconfigfiles();
        }
        loadConfig();
    }

    private void loadConfig() {

    }


    private void createconfigfiles() {
        plugin.saveResource("operators.yml", false);
    }

    public void saveIpList() {

    }

    /*public void saveMessages() {
        Messages.forEach((key, value) -> {
            yamlConfigurationMsg.set(key, value);
        });
        try {
            yamlConfigurationMsg.save(fileMsg);
        } catch (Exception ignored) {}
    }

     */


    /*
    public HashMap<String, Object> getMessages() {
        return Messages;
    }

     */

}