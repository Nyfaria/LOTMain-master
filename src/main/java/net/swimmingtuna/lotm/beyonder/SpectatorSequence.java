package net.swimmingtuna.lotm.beyonder;

import net.minecraft.nbt.CompoundTag;

public class SpectatorSequence {
    private int spectatorSequence;
    public final int MIN_SPECTATORSEQUENCE = 0; //sets Minimum Spirituality
    public final int MAX_SPECTATORSEQUENCE = 9; //sets Maximum Spirituality

    public int getSpectatorSequence() {
        return spectatorSequence;
    }

    public void addSpectatorSequence(int add) {this.spectatorSequence = Math.min(spectatorSequence + add, MAX_SPECTATORSEQUENCE);}

    public void subSpectatorSequence(int sub) {this.spectatorSequence = Math.max(spectatorSequence - sub, MIN_SPECTATORSEQUENCE);
    }

    public void copyFrom(SpectatorSequence source) {
        this.spectatorSequence = source.spectatorSequence;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("spectatorSequence", spectatorSequence);
    } //nbts are pretty much tags on a player

    public void loadNBTData(CompoundTag nbt) {spectatorSequence = nbt.getInt("spectatorSequence");
    }
}

