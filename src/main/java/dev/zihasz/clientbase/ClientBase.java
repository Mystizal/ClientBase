package dev.zihasz.clientbase;

import dev.zihasz.clientbase.event.EventProcessor;
import dev.zihasz.clientbase.manager.managers.CommandManager;
import dev.zihasz.clientbase.manager.managers.ConfigManager;
import dev.zihasz.clientbase.manager.managers.ModuleManager;
import dev.zihasz.clientbase.mixin.MixinLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ClientBase.MOD_ID, name = ClientBase.MOD_NAME, version = ClientBase.MOD_VER)
public class ClientBase {

    /**
     * The name of the client
     */
    public static final String MOD_NAME = "ClientBase";
    /**
     * The identifier of the client (for Forge and Minecraft)
     */
    public static final String MOD_ID   = "clientbase";
    /**
     * The version of the client
     */
    public static final String MOD_VER  = "v1.0.0";

    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);
    // public static final EventBus EVENT_BUS = new EventBus();

    public static EventProcessor eventProcessor;
    public static MixinLoader mixinLoader;

    // Managers
    public static CommandManager commandManager;
    public static ConfigManager configManager;
    public static ModuleManager moduleManager;

    /**
     * Load mixins and events here
     */
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        eventProcessor = new EventProcessor();
        LOGGER.info("Initialized EventProcessor!");

        mixinLoader = new MixinLoader();
        LOGGER.info("Initialized MixinLoader!");
    }

    /**
     * Load features here
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        commandManager = new CommandManager();
        LOGGER.info("Initialized CommandManager!");

        moduleManager = new ModuleManager();
        LOGGER.info("Initialized ModuleManager!");

        configManager = new ConfigManager();
        LOGGER.info("Initialized ConfigManager!");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            ConfigManager.save();
            LOGGER.info("Config saved!");
        }));
        LOGGER.info("Shutdown hook registered for config saving.");

        ConfigManager.load();
        LOGGER.info("Config loaded!");

    }

    /**
     * Load events, capes, rich presence here
     */
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

}