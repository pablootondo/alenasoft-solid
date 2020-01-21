package edu.alenasoft.gildedrose;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum QualityUpdaterFactory {
    INSTANCE;

    private final Map<String, QualityUpdater> handlers;
    private final QualityUpdater defaultHandler;
    private final String agedBrieKey = "Aged Brie";
    private final String backstagePassesKey = "Backstage passes to a TAFKAL80ETC concert";
    private final String conjuredKey = "Conjured Mana Cake";
    private final String sulfurasKey = "Sulfuras, Hand of Ragnaros";

    QualityUpdaterFactory() {
        handlers = new ConcurrentHashMap<>();
        defaultHandler = new DefaultQualityUpdater();
        handlers.put(agedBrieKey, new AgedBrieQualityUpdater());
        handlers.put(backstagePassesKey, new BackstagePassesQualityUpdater());
        handlers.put(conjuredKey, new ConjuredQualityUpdater());
        handlers.put(sulfurasKey, new SulfurasQualityUpdater());
    }

    public QualityUpdater getHandlerFor(String name) {
        return this.handlers.getOrDefault(name, defaultHandler);
    }
}
