package edu.alenasoft.gildedrose;

public class AgedBrieQualityUpdater implements QualityUpdater {
    @Override
    public void updateQuality(Item item) {
        item.incrementQuality();
        item.setSellIn(item.getSellIn() - 1);

        if (item.sellInIsPassed()) {
            item.incrementQuality();
        }
    }
}
