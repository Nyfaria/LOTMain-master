package net.swimmingtuna.lotm.beyonder.api;

import com.google.common.collect.HashMultimap;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import org.antlr.v4.runtime.misc.MultiMap;

import java.util.List;

public class BeyonderClass {
    public BeyonderClass() {
    }
    public List<String> sequenceNames() {
        return List.of("");
    }
    public List<Integer> spiritualityLevels() {
        return List.of(0);
    }
    public List<Integer> spiritualityRegen() {
        return List.of(0);
    }
    public List<Double> maxHealth() {
        return List.of(0.0);
    }
    public void tick(Player player, int sequence){
    }
    public HashMultimap<Integer,Item> getItems(){
        return HashMultimap.create();
    }
    public SimpleContainer getAbilityItemsContainer(int sequenceLevel) {
        SimpleContainer container = new SimpleContainer(27);
        for(int i = 0; i <= sequenceLevel; i++) {
            getItems().get(i).stream().map(Item::getDefaultInstance).forEach(
                    container::addItem
            );
        }
        return container;
    }
}
