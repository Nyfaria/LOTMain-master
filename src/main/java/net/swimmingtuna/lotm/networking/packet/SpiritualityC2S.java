package net.swimmingtuna.lotm.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SpiritualityC2S {
    SpiritualityC2S() {

    }

    public SpiritualityC2S(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {


        ServerPlayer player = context.getSender();
        ServerLevel level = (ServerLevel) player.level();
        if (hasSolidBlocksAround(player, level) && player.isCrouching()) {
            player.sendSystemMessage(Component.literal("worked"));
        }});
    return true;
    }


    private static boolean hasSolidBlocksAround(ServerPlayer player, ServerLevel level) {
        return level.getBlockStates(player.getBoundingBox().inflate(2))
                .filter(blockState ->
                                !blockState.is(Blocks.AIR) ||
                                !blockState.is(Blocks.CAVE_AIR) ||
                                !blockState.is(Blocks.VOID_AIR)
                                || !blockState.is(Blocks.TRIPWIRE)
                                || !blockState.is(Blocks.TRIPWIRE_HOOK)
                                || !blockState.is(Blocks.LIGHTNING_ROD)).toArray().length > 0;
    }
}
