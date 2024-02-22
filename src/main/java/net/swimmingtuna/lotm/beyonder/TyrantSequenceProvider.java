package net.swimmingtuna.lotm.beyonder;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TyrantSequenceProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<TyrantSequence> TYRANTSEQUENCE = CapabilityManager.get(new CapabilityToken<TyrantSequence>() {});

    private TyrantSequence tyrantSequence = null;
    private final LazyOptional<TyrantSequence> optional = LazyOptional.of(this::createTyrantSequence);

    private TyrantSequence createTyrantSequence() {
        if (this.tyrantSequence == null) {
            this.tyrantSequence = new TyrantSequence();
        }
        return this.tyrantSequence;
    }


    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == TYRANTSEQUENCE) {
            return optional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createTyrantSequence().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
createTyrantSequence().loadNBTData(nbt);
    }
}
