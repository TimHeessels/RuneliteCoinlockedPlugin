package com.rogueliteplugin.requirements;

import com.rogueliteplugin.RoguelitePlugin;
import com.rogueliteplugin.challenge.ChallengeContext;

import java.util.Set;

public class RequiresUnlockRequirement implements AppearRequirement
{
    private final String requiredUnlockId;

    public RequiresUnlockRequirement(String requiredUnlockId)
    {
        this.requiredUnlockId = requiredUnlockId;
    }

    @Override
    public boolean isMet(Set<String> unlockedIds)
    {
        return unlockedIds.contains(requiredUnlockId);
    }

    @Override
    public String getDescription()
    {
        return "Requires " + requiredUnlockId;
    }
}

