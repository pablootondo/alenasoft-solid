package edu.alenasoft.gildedrose;

public class ConjuredQualityUpdater implements QualityUpdater {
    @Override
    public void updateQuality(Item item) {
        decrementQuality(item);
        item.setSellIn(item.getSellIn() - 1);

        if (item.sellInIsPassed()) {
            decrementQuality(item);
        }
    }

    private void decrementQuality(Item item) {
        item.decrementQuality();
        item.decrementQuality();
    }
}
