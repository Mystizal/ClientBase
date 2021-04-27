package dev.zihasz.clientbase.feature.hud.elements;

import dev.zihasz.clientbase.ClientBase;
import dev.zihasz.clientbase.feature.hud.HUDElement;

import java.awt.*;

public class WaterMark extends HUDElement {

	String watermark = "";

	public WaterMark() {
		super("WaterMark", "Puts a watermark on the screen so you know what clients your using :`)");
		watermark = ClientBase.MOD_NAME + " " + ClientBase.MOD_VER;
	}

	@Override
	public void render() {
		mc.fontRenderer.drawString(
				watermark,
				(int) x - (mc.fontRenderer.getStringWidth(watermark) / 2),
				(int) y + (mc.fontRenderer.FONT_HEIGHT / 2),
				new Color(255, 255, 255, 200).getRGB());

	}

	@Override public float width() {
		return mc.fontRenderer.getStringWidth(watermark) + 2*2;
	}
	@Override public float height() {
		return mc.fontRenderer.FONT_HEIGHT + 2*2;
	}
}
