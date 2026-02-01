package com.coinlockedplugin.pack;

import com.coinlockedplugin.CoinlockedPlugin;

public interface PackOption {
    String getDisplayName();

    String getDisplayType();

    String getDescription();

    void onChosen(CoinlockedPlugin plugin);
}