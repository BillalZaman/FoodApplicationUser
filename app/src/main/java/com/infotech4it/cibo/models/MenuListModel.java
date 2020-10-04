package com.infotech4it.cibo.models;

public class MenuListModel {
    private int itemImage;
    private String itemName;

    public MenuListModel(int itemImage, String itemName) {
        this.itemImage = itemImage;
        this.itemName = itemName;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
