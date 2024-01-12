package br.com.weslei.bender.api.duelcards.domain.BanList;

import java.util.Map;

public class BanList {

    Map<String, CardLimitation> cardLimitationMap;

    public enum CardLimitation {
        UNLIMITED,
        LIMITED,
        SEMI_LIMITED,
        BANNED
    }

    public void addLimitation(String cardName, CardLimitation limitation) {
        this.cardLimitationMap.put(cardName, limitation);
    }
}
