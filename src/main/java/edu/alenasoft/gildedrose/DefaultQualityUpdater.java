package edu.alenasoft.gildedrose;

public class DefaultQualityUpdater implements QualityUpdater {
    @Override
    public void updateQuality(Item item) {
        item.decrementQuality();
        item.setSellIn(item.getSellIn() - 1);

        if (item.sellInIsPassed()) {
            item.decrementQuality();
        }
    }
}
