package com.coinlockedplugin.requirements;

import com.coinlockedplugin.CoinlockedPlugin;

import java.util.Set;

public class MemberRequirement implements AppearRequirement {

    public MemberRequirement() {

    }

    @Override
    public boolean isMet(CoinlockedPlugin plugin, Set<String> unlockedIds) {
        return plugin.isInMemberWorld();
    }

    @Override
    public String getRequiredUnlockTitle() {
        return "Membership Required";
    }
}

