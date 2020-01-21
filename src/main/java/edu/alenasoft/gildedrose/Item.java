package edu.alenasoft.gildedrose;

public class Item {
  private static final int MIN_QUALITY = 0;
  private static final int MAX_QUALITY = 50;

  private String name;
  private int sellIn;
  private int quality;

  public Item(String name, int sellIn, int quality) {
    this.setName(name);
    this.setSellIn(sellIn);
    this.setQuality(quality);
  }

  /* Generated getter and setter code */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getSellIn() {
    return sellIn;
  }

  public void setSellIn(int sellIn) {
    this.sellIn = sellIn;
  }

  public int getQuality() {
    return quality;
  }

  public void setQuality(int quality) {
    this.quality = quality;
  }

  public void cancelQuality() {
    this.setQuality(MIN_QUALITY);
  }

  public void incrementQuality() {
    if (this.getQuality() < MAX_QUALITY) {
      this.setQuality(this.getQuality() + 1);
    }
  }

  public void decrementQuality() {
    if (this.getQuality() > MIN_QUALITY) {
      this.setQuality(this.getQuality() - 1);
    }
  }

  public boolean sellInIsPassed() {
    return this.getSellIn() < 0;
  }

  @Override
  public String toString() {
    return "Item{" + "name='" + name + '\'' + ", sellIn=" + sellIn + ", quality=" + quality + '}';
  }
}
