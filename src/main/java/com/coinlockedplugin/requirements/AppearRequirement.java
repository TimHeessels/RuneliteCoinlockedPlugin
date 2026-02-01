package com.coinlockedplugin.requirements;

import com.coinlockedplugin.CoinlockedPlugin;
import java.util.Set;

public interface AppearRequirement
{
    // Convenience bridge for UI / tooltips
    default boolean isMet(CoinlockedPlugin plugin, Set<String> unlockedIds)
    {
        return true;
    }

    String getRequiredUnlockTitle();
}