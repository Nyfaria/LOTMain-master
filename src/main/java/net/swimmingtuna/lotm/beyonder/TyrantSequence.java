package net.swimmingtuna.lotm.beyonder;

import net.minecraft.nbt.CompoundTag;

public class TyrantSequence {
    private int tyrantSequence;
    public final int MIN_TYRANTSEQUENCE = 0; //sets Minimum Spirituality
    public final int MAX_TYRANTSEQUENCE = 9; //sets Maximum Spirituality

    public int getTyrantSequence() {
        return tyrantSequence;
    }

    public void addSpectatorSequence(int add) {this.tyrantSequence = Math.min(tyrantSequence + add, MAX_TYRANTSEQUENCE);}

    public void subSpectatorSequence(int sub) {this.tyrantSequence = Math.max(tyrantSequence - sub, MIN_TYRANTSEQUENCE);
    }

    public void copyFrom(TyrantSequence source) {
        this.tyrantSequence = source.tyrantSequence;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("spectatorSequence", tyrantSequence);
    } //nbts are pretty much tags on a player

    public void loadNBTData(CompoundTag nbt) {
        tyrantSequence = nbt.getInt("spectatorSequence");
    }
}

