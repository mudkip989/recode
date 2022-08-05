package io.github.homchom.recode.mod.events.impl;

import io.github.homchom.recode.event.*;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;

public class LegacyReceiveSoundEvent {
    private static int cancelNextSounds;

    public LegacyReceiveSoundEvent() {
        RecodeEvents.PlaySound.listen(this::run);
    }

    private boolean run(ClientboundSoundPacket packet, boolean playSound) {
        if (cancelNextSounds > 0) {
            cancelNextSounds--;
            return false;
        }
        return playSound;
    }

    public static void cancelNextSounds(int amount) {
        cancelNextSounds = amount;
    }

    public static void cancelNextSound() {
        cancelNextSounds(1);
    }
}
