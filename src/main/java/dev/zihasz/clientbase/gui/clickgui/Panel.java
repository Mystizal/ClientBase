package dev.zihasz.clientbase.gui.clickgui;

import dev.zihasz.clientbase.feature.module.Category;
import dev.zihasz.clientbase.feature.module.modules.client.ClickGUIModule;
import dev.zihasz.clientbase.manager.managers.ModuleManager;
import dev.zihasz.clientbase.util.utils.math.MathUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

import java.awt.*;

public class Panel extends Container {

	public String title;
	public final Category category;
	public int x, y, width;

	private boolean drag;
	private int dragX, dragY;
	private Color foreground, background, fontColor;
	private static final int COMPONENT_HEIGHT = 10;
	private static final int HEADER_HEIGHT = 15;
	private static FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;

	public Panel(Category category, int x, int y, int width) {
		this.category = category;
		this.x = x;
		this.y = y;
		this.width = width;

		this.title = category.name().toLowerCase();

		this.drag = false;
		this.foreground = getSettingColor("Foreground");
		this.background = getSettingColor("Background");
		this.fontColor  = getSettingColor("FontColor");
	}

	public void render(int mouseX, int mouseY, float partialTicks) {

	}

	public void onMouseDown(int mouseX, int mouseY, int mouseButton) {
		if (mouseButton == 0 && MathUtils.isHovered(mouseX, mouseY, x, y, width, HEADER_HEIGHT)) {
			drag = true;
		}
	}

	public void onMouseUp(int mouseX, int mouseY, int mouseButton) {
		drag = false;
	}

	public void onTyped() {}

	public int height() {
		return ModuleManager.getModules(category).size() * COMPONENT_HEIGHT;
	}
	public static Color getSettingColor(String settingName) { return (Color) ModuleManager.getModule(ClickGUIModule.class).getSetting(settingName).getValue(); }

}
