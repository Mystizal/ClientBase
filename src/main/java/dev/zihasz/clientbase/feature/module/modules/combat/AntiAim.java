package dev.zihasz.clientbase.feature.module.modules.combat;

import dev.zihasz.clientbase.feature.module.Category;
import dev.zihasz.clientbase.feature.module.Module;
import dev.zihasz.clientbase.setting.Setting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Random;

public class AntiAim extends Module {

	public AntiAim() {
		super("AntiAim", "Meme module from CS:GO Cheats.", Category.COMBAT);
	}

	private final Setting<YawMode> yawMode = new Setting<>("", "", YawMode.STATIC);
	private final Setting<PitchMode> pitchMode = new Setting<>("", "", PitchMode.DOWN);

	private final Setting<Float> yaw = new Setting<>("Yaw", "The yaw to use when \"STATIC\" mode is selected", 0f, -180f, 180f);
	private final Setting<Float> pitch = new Setting<>("Pitch", "The pitch to use when \"STATIC\" mode is selected", 0f, -180f, 180f);

	private final Setting<Float> maxJitter = new Setting<>("MaxJitter", "Maximum amount to jitter", 100f, 0f, 180f);
	private final Setting<Float> minJitter = new Setting<>("MinJitter", "Minimum amount to jitter", 10f, 0f, 180f);

	private final Random random = new Random(this.hashCode());

	private float yawValue = 0f;
	private float pitchValue = 0f;


	@SubscribeEvent
	public void onTick(TickEvent.ClientTickEvent event) {

		switch (yawMode.getValue()) {
			case STATIC:
				yawValue = yaw.getValue();
				break;
			case JITTER:
				if (mc.player.ticksExisted % 4 == 0)
					yawValue = (float) random.doubles(minJitter.getValue(), maxJitter.getValue()).findFirst().orElse(0d);
				else
					yawValue = -(float) random.doubles(minJitter.getValue(), maxJitter.getValue()).findFirst().orElse(0d);
				break;
		}

		switch (pitchMode.getValue()) {
			case STATIC:
				pitchValue = pitch.getValue();
				break;
			case ZERO:
				pitchValue = 0f;
				break;
			case DOWN:
				pitchValue = 90f;
				break;
			case UP:
				pitchValue = 270f;
				break;
		}

		mc.player.rotationYaw = yawValue;
		mc.player.rotationPitch = pitchValue;

	}

	// Horizontal
	private enum YawMode {
		STATIC,
		JITTER,
	}

	// Vertical
	private enum PitchMode {
		STATIC,
		ZERO,
		DOWN,
		UP,
	}


}
