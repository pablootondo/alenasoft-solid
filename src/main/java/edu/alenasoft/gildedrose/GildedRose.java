package edu.alenasoft.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

  private static final int MIN_QUALITY = 0;
  private static final int MAX_QUALITY = 50;

  public static List<Item> items = new ArrayList<>();

  public static void main(String[] args) {

    System.out.println("OMGHAI!");

    items.add(new Item("+5 Dexterity Vest", 10, 20));
    items.add(new Item("Aged Brie", 2, 0));
    items.add(new Item("Elixir of the Mongoose", 5, 7));
    items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
    items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
    items.add(new Item("Conjured Mana Cake", 3, 6));

    updateQuality();

    System.out.println(items);
  }

  public static void updateQuality() {
    for (Item item : items) {
      if (isAgedBrie(item)) {
        incrementQuality(item);
      } else if (isBackstagePasses(item)) {
        incrementQuality(item);

        if (item.getSellIn() < 11) {
          incrementQuality(item);
        }

        if (item.getSellIn() < 6) {
          incrementQuality(item);
        }
      } else if (!isSulfuras(item)) {
        decrementQuality(item);
      }

      if (!isSulfuras(item)) {
        item.setSellIn(item.getSellIn() - 1);
      }

      if (sellInPassed(item)) {
        if (isAgedBrie(item)) {
          incrementQuality(item);
        } else if (isBackstagePasses(item)) {
          item.setQuality(MIN_QUALITY);
        } else if (!isSulfuras(item)) {
          decrementQuality(item);
        }
      }
    }
  }

  private static boolean sellInPassed(Item item) {
    return item.getSellIn() < 0;
  }

  private static void incrementQuality(Item item) {
    if (item.getQuality() < MAX_QUALITY) {
      item.setQuality(item.getQuality() + 1);
    }
  }

  private static void decrementQuality(Item item) {
    if (item.getQuality() > MIN_QUALITY) {
      item.setQuality(item.getQuality() - 1);
    }
  }

  private static boolean isAgedBrie(Item item) {
    return "Aged Brie".equals(item.getName());
  }

  private static boolean isSulfuras(Item item) {
    return "Sulfuras, Hand of Ragnaros".equals(item.getName());
  }

  private static boolean isBackstagePasses(Item item) {
    return "Backstage passes to a TAFKAL80ETC concert".equals(item.getName());
  }
}
