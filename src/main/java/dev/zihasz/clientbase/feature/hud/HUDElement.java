package dev.zihasz.clientbase.feature.hud;

import dev.zihasz.clientbase.feature.Feature;
import dev.zihasz.clientbase.feature.traits.IToggleable;

public abstract class HUDElement extends Feature implements IToggleable {

	public boolean enabled;
	public float x, y;

	public boolean drag = false;
	public float dragX, dragY;

	public HUDElement(String name, String description) {
		super(name, description);
	}

	public abstract void render();

	/**
	 * The width of the element
	 * @return the width of the element
	 */
	public abstract float width();

	/**
	 * The height of the element
	 * @return the height of the element
	 */
	public abstract float height();

	public void enable() {
		this.enabled = true;
		this.onEnable();
	}
	public void disable() {
		this.enabled = false;
		this.onDisable();
	}
	public void toggle() {
		if (enabled) disable();
		else enable();
	}

	public boolean isEnabled() { return enabled; }
	public void setEnabled(boolean enabled) { this.enabled = enabled; }

	public void onEnable() {}
	public void onDisable() {}

}
