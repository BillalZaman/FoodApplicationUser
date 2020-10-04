package com.infotech4it.cibo.models;

public class MenuListModel {
    private String itemImage;
    private String itemName;

    public MenuListModel() {
    }

    public MenuListModel(String itemImage, String itemName) {
        this.itemImage = itemImage;
        this.itemName = itemName;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
