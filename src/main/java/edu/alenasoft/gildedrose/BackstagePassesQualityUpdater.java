package edu.alenasoft.gildedrose;

public class BackstagePassesQualityUpdater implements QualityUpdater {
    @Override
    public void updateQuality(Item item) {
        item.incrementQuality();

        if (item.getSellIn() < 11) {
            item.incrementQuality();
        }

        if (item.getSellIn() < 6) {
            item.incrementQuality();
        }

        item.setSellIn(item.getSellIn() - 1);

        if (item.sellInIsPassed()) {
            item.cancelQuality();
        }
    }
}
