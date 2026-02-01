package com.coinlockedplugin.requirements;

import com.coinlockedplugin.CoinlockedPlugin;
import com.coinlockedplugin.unlocks.UnlockRegistry;
import net.runelite.api.Skill;

import java.util.Set;

public class MaxSkillLevelUnlocked implements AppearRequirement {
    private final Skill skill;

    public enum LevelRanges {
        _10,
        _20,
        _30,
        _40,
        _50,
        _60,
        _70,
        _80,
        _90,
        _99
    }

    private final LevelRanges levelRange;
    private String unlockId;
    private final UnlockRegistry unlockRegistry;


    public MaxSkillLevelUnlocked(Skill skill, LevelRanges levelRange, UnlockRegistry unlockRegistry) {
        this.skill = skill;
        this.levelRange = levelRange;
        this.unlockRegistry = unlockRegistry;
    }

    @Override
    public boolean isMet(CoinlockedPlugin coinlockedPlugin, Set<String> unlockedIds) {
        if (unlockId == null)
            unlockId = setUnlockId();
        return coinlockedPlugin.isUnlocked(unlockId);
    }

    @Override
    public String getRequiredUnlockTitle() {
        if (unlockId == null)
            unlockId = setUnlockId();
        String displayName = unlockId;
        if (unlockRegistry != null) {
            var unlock = unlockRegistry.getAll().stream()
                    .filter(u -> u.getId().equals(unlockId))
                    .findFirst();
            if (unlock.isPresent()) {
                displayName = unlock.get().getDisplayName();
            }
        }
        return "Requires " + displayName;
    }

    String setUnlockId() {
        return "SKILL_" + skill.name() + "_" + levelRange.toString()
                .substring(levelRange.toString().lastIndexOf('_') + 1);
    }
}
