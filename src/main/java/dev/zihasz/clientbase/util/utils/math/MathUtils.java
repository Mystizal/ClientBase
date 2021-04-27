package dev.zihasz.clientbase.util.utils.math;

public class MathUtils {

	public static boolean isHovered(int mouseX, int mouseY, float x, float y, float width, float height) {
		return isBetween(mouseX, x, x + width) && isBetween(mouseY, y, y + height);
	}
	public static boolean isBetween(float value, float min, float max) {
		return min < value && value < max;
	}

}
