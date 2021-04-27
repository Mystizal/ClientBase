package dev.zihasz.clientbase.event;

import dev.zihasz.clientbase.feature.module.Module;
import dev.zihasz.clientbase.manager.managers.ModuleManager;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

/**
 * This is for translating Forge and Minecraft events into your clients events.
 */
public class EventProcessor {

	public EventProcessor() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		if (Keyboard.getEventKeyState()) {
			if (!(Keyboard.getEventKey() == Keyboard.KEY_NONE || Keyboard.getEventCharacter() == Keyboard.CHAR_NONE)) {
				for (Module module : ModuleManager.getModules()) {
					if (module.getBind() == Keyboard.getEventKey()) module.toggle();
				}
			}
		}
	}

	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event) {
		// for (Module module : ModuleManager.getModules()) module.onClientTick();
		ModuleManager.getModules().stream().filter(Module::isEnabled).forEach(Module::onUpdate);
	}

	@SubscribeEvent
	public void onRenderTick(TickEvent.RenderTickEvent event) {
		// for (Module module : ModuleManager.getModules()) module.onRender();
		ModuleManager.getModules().stream().filter(Module::isEnabled).forEach(Module::onRender);
	}

	@SubscribeEvent
	public void onRenderWorldLast(RenderWorldLastEvent event) {
		// for (Module module : ModuleManager.getModules()) module.onWorldRender(event);
		ModuleManager.getModules().stream().filter(Module::isEnabled).forEach(module -> module.onWorldRender(event));
	}

}
