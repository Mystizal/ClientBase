package dev.zihasz.clientbase.feature.command.commands;

import dev.zihasz.clientbase.feature.command.Command;
import dev.zihasz.clientbase.feature.module.Module;
import dev.zihasz.clientbase.manager.managers.ModuleManager;
import net.minecraft.util.text.TextComponentString;

public class ModulesCommand extends Command {

	public ModulesCommand() {
		super("Modules", "Get all modules", "modules", "listmodules");
	}

	@Override
	public void run(String[] args) {
		mc.player.sendMessage(new TextComponentString("Loaded modules: "));
		for (Module module : ModuleManager.getModules()) {
			mc.player.sendMessage(new TextComponentString(module.getName()));
		}
	}
}
