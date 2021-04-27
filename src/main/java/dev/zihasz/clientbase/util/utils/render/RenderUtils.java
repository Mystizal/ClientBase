package dev.zihasz.clientbase.util.utils.render;

import dev.zihasz.clientbase.util.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class RenderUtils extends Util {

	public static void drawRect(int left, int top, int right, int bottom, int color) {
		int j;
		if (left < right) {
			j = left;
			left = right;
			right = j;
		}

		if (top < bottom) {
			j = top;
			top = bottom;
			bottom = j;
		}

		float f3 = (float)(color >> 24 & 255) / 255.0F;
		float f = (float)(color >> 16 & 255) / 255.0F;
		float f1 = (float)(color >> 8 & 255) / 255.0F;
		float f2 = (float)(color & 255) / 255.0F;
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder bufferbuilder = tessellator.getBuffer();
		GlStateManager.enableBlend();
		GlStateManager.disableTexture2D();
		GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		GlStateManager.color(f, f1, f2, f3);
		bufferbuilder.begin(7, DefaultVertexFormats.POSITION);
		bufferbuilder.pos((double)left, (double)bottom, 0.0D).endVertex();
		bufferbuilder.pos((double)right, (double)bottom, 0.0D).endVertex();
		bufferbuilder.pos((double)right, (double)top, 0.0D).endVertex();
		bufferbuilder.pos((double)left, (double)top, 0.0D).endVertex();
		tessellator.draw();
		GlStateManager.enableTexture2D();
		GlStateManager.disableBlend();
	}
	public static void drawRect(float left, float top, float right, float bottom, int color) {
		float j;
		if (left < right) {
			j = left;
			left = right;
			right = j;
		}

		if (top < bottom) {
			j = top;
			top = bottom;
			bottom = j;
		}

		float f3 = (float)(color >> 24 & 255) / 255.0F;
		float f = (float)(color >> 16 & 255) / 255.0F;
		float f1 = (float)(color >> 8 & 255) / 255.0F;
		float f2 = (float)(color & 255) / 255.0F;
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder bufferbuilder = tessellator.getBuffer();
		GlStateManager.enableBlend();
		GlStateManager.disableTexture2D();
		GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		GlStateManager.color(f, f1, f2, f3);
		bufferbuilder.begin(7, DefaultVertexFormats.POSITION);
		bufferbuilder.pos(left, bottom, 0.0D).endVertex();
		bufferbuilder.pos(right, bottom, 0.0D).endVertex();
		bufferbuilder.pos(right, top, 0.0D).endVertex();
		bufferbuilder.pos(left, top, 0.0D).endVertex();
		tessellator.draw();
		GlStateManager.enableTexture2D();
		GlStateManager.disableBlend();
	}
	public static void drawRect(double left, double top, double right, double bottom, int color) {
		double j;

		if (left < right) {
			j = left;
			left = right;
			right = j;
		}

		if (top < bottom) {
			j = top;
			top = bottom;
			bottom = j;
		}

		float f3 = (float)(color >> 24 & 255) / 255.0F;
		float f = (float)(color >> 16 & 255) / 255.0F;
		float f1 = (float)(color >> 8 & 255) / 255.0F;
		float f2 = (float)(color & 255) / 255.0F;
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder bufferbuilder = tessellator.getBuffer();
		GlStateManager.enableBlend();
		GlStateManager.disableTexture2D();
		GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		GlStateManager.color(f, f1, f2, f3);
		bufferbuilder.begin(7, DefaultVertexFormats.POSITION);
		bufferbuilder.pos(left, bottom, 0.0D).endVertex();
		bufferbuilder.pos(right, bottom, 0.0D).endVertex();
		bufferbuilder.pos(right, top, 0.0D).endVertex();
		bufferbuilder.pos(left, top, 0.0D).endVertex();
		tessellator.draw();
		GlStateManager.enableTexture2D();
		GlStateManager.disableBlend();
	}

	public static void drawHorizontalLine(int startX, int endX, int y, int width, int color) {
		if (endX < startX) {
			int i = startX;
			startX = endX;
			endX = i;
		}

		drawRect(startX, y, endX + 1, y + width, color);
	}
	public static void drawHorizontalLine(float startX, float endX, float y, float width, int color) {
		if (endX < startX) {
			float i = startX;
			startX = endX;
			endX = i;
		}

		drawRect(startX, y, endX + 1, y + width, color);
	}
	public static void drawHorizontalLine(double startX, double endX, double y, double width, int color) {
		if (endX < startX) {
			double i = startX;
			startX = endX;
			endX = i;
		}

		drawRect(startX, y, endX + 1, y + width, color);
	}

	public static void drawVerticalLine(int x, int startY, int endY, int width, int color) {
		if (endY < startY) {
			int i = startY;
			startY = endY;
			endY = i;
		}

		drawRect(x, startY + 1, x + width, endY, color);
	}
	public static void drawVerticalLine(float x, float startY, float endY, float width, int color) {
		if (endY < startY) {
			float i = startY;
			startY = endY;
			endY = i;
		}

		drawRect(x, startY + 1, x + width, endY, color);
	}
	public static void drawVerticalLine(double x, double startY, double endY, double width, int color) {
		if (endY < startY) {
			double i = startY;
			startY = endY;
			endY = i;
		}

		drawRect(x, startY + 1, x + width, endY, color);
	}

	public static void drawString(FontRenderer fontRendererIn, String text, int x, int y, int color) {
		fontRendererIn.drawStringWithShadow(text, (float)x, (float)y, color);
	}
	public static void drawString(FontRenderer fontRendererIn, String text, double x, double y, int color) {
		fontRendererIn.drawStringWithShadow(text, (float)x, (float)y, color);
	}

	public static void drawCenteredString(FontRenderer fontRendererIn, String text, int x, int y, int color) {
		fontRendererIn.drawStringWithShadow(
				text,
				(float)(x - fontRendererIn.getStringWidth(text) / 2),
				(float)y,
				color);
	}
	public static void drawCenteredString(FontRenderer fontRendererIn, String text, float x, float y, int color) {
		fontRendererIn.drawStringWithShadow(
				text,
				(float)(x - fontRendererIn.getStringWidth(text) / 2),
				(float)y,
				color);
	}
	public static void drawCenteredString(FontRenderer fontRendererIn, String text, double x, double y, int color) {
		fontRendererIn.drawStringWithShadow(
				text,
				(float) (x - fontRendererIn.getStringWidth(text) / 2),
				(float) y,
				color);
	}

	public static void drawLeftString    (FontRenderer fontRendererIn, String text, int x, int y, int width, int height, int color) {
		fontRendererIn.drawStringWithShadow(
				text,
				(x + width) - fontRendererIn.getStringWidth(text),
				y + (Minecraft.getMinecraft().fontRenderer.FONT_HEIGHT / 2f),
				color);
	}
	public static void drawLeftString    (FontRenderer fontRendererIn, String text, float x, float y, float width, float height, int color) {
		fontRendererIn.drawStringWithShadow(
				text,
				(x + width) - fontRendererIn.getStringWidth(text),
				y + (Minecraft.getMinecraft().fontRenderer.FONT_HEIGHT / 2f),
				color);
	}
	public static void drawLeftString    (FontRenderer fontRendererIn, String text, double x, double y, double width, double height, int color) {
		fontRendererIn.drawStringWithShadow(
				text,
				(float) (x + width) - fontRendererIn.getStringWidth(text),
				(float) (y + (Minecraft.getMinecraft().fontRenderer.FONT_HEIGHT / 2f)),
				color);
	}

}
