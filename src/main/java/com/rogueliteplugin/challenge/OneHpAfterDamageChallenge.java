package com.rogueliteplugin.challenge;

import net.runelite.api.Skill;
import net.runelite.api.events.HitsplatApplied;

public class OneHpAfterDamageChallenge implements Challenge
{
    private final String id;
    private final String name;
    private final String description;

    public OneHpAfterDamageChallenge(
            String id,
            String name,
            String description)
    {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public ChallengeType getType() {
        return ChallengeType.UNIQUE;
    }

    @Override
    public String getId()
    {
        return id;
    }

    @Override
    public String getChallengeName()
    {
        return name;
    }

    @Override
    public String getDescription()
    {
        return description;
    }

    @Override
    public Integer getLowAmount()
    {
        return 1;
    }

    @Override
    public Integer getHighAmount()
    {
        return 1;
    }
}