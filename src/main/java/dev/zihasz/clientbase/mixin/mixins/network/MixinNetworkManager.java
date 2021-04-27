package dev.zihasz.clientbase.mixin.mixins.network;

import dev.zihasz.clientbase.event.EventEra;
import dev.zihasz.clientbase.event.events.PacketEvent;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetworkManager.class)
public class MixinNetworkManager {

    // Pre send packet
    @Inject(method = "sendPacket(Lnet/minecraft/network/Packet;)V", at = @At("HEAD"), cancellable = true)
    private void preSendPacket(Packet<?> packet, CallbackInfo callbackInfo) {
        PacketEvent event = new PacketEvent.Send(EventEra.PRE, packet);
        MinecraftForge.EVENT_BUS.post(event);

        if (event.isCancelable()) callbackInfo.cancel();
    }

    // Post send packet
    @Inject(method = "sendPacket(Lnet/minecraft/network/Packet;)V", at = @At("TAIL"), cancellable = true)
    private void dispatchSendPacket(Packet<?> packet, CallbackInfo callbackInfo) {
        PacketEvent event = new PacketEvent.Send(EventEra.POST, packet);
        MinecraftForge.EVENT_BUS.post(event);

        if (event.isCancelable()) callbackInfo.cancel();
    }

    // Pre packet receive
    @Inject(method = "channelRead0", at = @At("HEAD"), cancellable = true)
    private void preChannelRead(ChannelHandlerContext context, Packet<?> packet, CallbackInfo callbackInfo) {
        PacketEvent event = new PacketEvent(EventEra.PRE, packet);
        MinecraftForge.EVENT_BUS.post(event);

        if (event.isCancelable()) callbackInfo.cancel();
    }

    // Post packet receive
    @Inject(method = "channelRead0", at = @At("TAIL"), cancellable = true)
    private void dispatchChannelRead(ChannelHandlerContext context, Packet<?> packet, CallbackInfo callbackInfo) {
        PacketEvent event = new PacketEvent.Receive(EventEra.POST, packet);
        MinecraftForge.EVENT_BUS.post(event);

        if (event.isCancelable()) callbackInfo.cancel();
    }

}
