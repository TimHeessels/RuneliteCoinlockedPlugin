package com.rogueliteplugin.challenge;

import java.util.Set;

public class ChallengeContext
{
    private final Set<String> unlockedIds;

    public ChallengeContext(Set<String> unlockedIds)
    {
        this.unlockedIds = unlockedIds;
    }

    public boolean hasUnlock(String unlockId)
    {
        return unlockedIds.contains(unlockId);
    }
}
