package edu.alenasoft.gildedrose;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum QualityUpdaterFactory {
    INSTANCE;

    private final Map<String, QualityUpdater> handlers;
    private final QualityUpdater defaultHandler;
    private final String AgedBrieKey = "Aged Brie";
    private final String BackstagePassesKey = "Backstage passes to a TAFKAL80ETC concert";
    private final String SulfurasKey = "Sulfuras, Hand of Ragnaros";

    QualityUpdaterFactory() {
        handlers = new ConcurrentHashMap<>();
        defaultHandler = new DefaultQualityUpdater();
        handlers.put(AgedBrieKey, new AgedBrieQualityUpdater());
        handlers.put(BackstagePassesKey, new BackstagePassesQualityUpdater());
        handlers.put(SulfurasKey, new SulfurasQualityUpdater());
    }

    public QualityUpdater getHandlerFor(String name) {
        return this.handlers.getOrDefault(name, defaultHandler);
    }
}
