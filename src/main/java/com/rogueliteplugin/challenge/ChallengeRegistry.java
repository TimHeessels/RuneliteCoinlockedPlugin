package com.rogueliteplugin.challenge;

import com.rogueliteplugin.unlocks.Unlock;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ChallengeRegistry
{
    private final Map<String, Challenge> challanges = new HashMap<>();

    public void register(Challenge challange)
    {
        challanges.put(challange.getId(), challange);
    }

    public Challenge get(String id)
    {
        return challanges.get(id);
    }

    public Collection<Challenge> getAll()
    {
        return challanges.values();
    }
}