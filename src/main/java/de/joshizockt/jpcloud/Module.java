package de.joshizockt.jpcloud;

import de.joshizockt.jpcloud.base.BaseModule;
import de.joshizockt.jpcloud.core.CoreModule;

import java.util.Locale;

public abstract class Module {

    public Module(String[] args) {  }

    abstract public void start();
    abstract public void stop();

    public static Module get(String module, String[] args) {
        return switch (module.toLowerCase(Locale.ROOT)) {
            case "0", "core" -> new CoreModule(args);
            case "1", "base" -> new BaseModule(args);
            default -> null;
        };
    }

}
