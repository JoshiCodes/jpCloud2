package de.joshizockt.jpcloud;

import de.joshizockt.jpcloud.util.AsciiUtil;

public class Main {

    public static Logger logger;

    public static void main(String[] args) {

        AsciiUtil.printAscii();
        System.out.println("Loading Module...");

        Module m = selectModule(args);

        if(m == null) {
            System.err.println("No Module found! Please start with --module=<MODULE>");
            System.out.println("Possible Modules:");
            System.out.println("0 - CORE");
            System.out.println("1 - BASE");
            return;
        }

        logger = new Logger();

        m.start();

    }

    private static Module selectModule(String... args) {
        for(String arg : args) {
            if(arg.startsWith("--module=")) {
                String module = arg.replaceFirst("--module=", "");
                return Module.get(module, args);
            }
        }
        return null;
    }

}
