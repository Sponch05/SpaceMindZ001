package com.spacemindz.www.spacemindz001;

/**
 * Created by Sponch on 2017/09/30.
 */

public class BackEnd {

    //Private variable for item
    int itemId;
    String itemName;
    double itemPrice;
    int itemRating;
    int sellerId;


    //user private variables
    String username;
    int points;
    double totalSpent;

    public BackEnd()
    {

    }

   //paramitized constructor should be here public BackEnd
    public BackEnd(int itemId, String itemName,double itemPrice,int itemRating,int sellerId)
    {

        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemRating = itemRating;
        this.sellerId = sellerId;
    }
    //All getters
    int getItemId()
    {
        return itemId;
    }
    //get name
    String getItemName()
    {
        return itemName;
    }
    //get item price
    double getPrice()
    {
        return itemPrice;
    }
    //getRating
    int getRating()
    {
        return itemRating;
    }
    //getSellerId
    int getSellerId()
    {
        return sellerId;
    }
    //
    //must make getters for user table

    //All the setters
    void setItemId(int itemId)
    {
        this.itemId = itemId;
    }
    void setItemName(String itemName)
    {
        this.itemName = itemName;
    }
    void setItemPrice(double itemPrice)
    {
        this.itemPrice = itemPrice;
    }
    void setRating(int rating)
    {
        this.itemRating = rating;
    }
    void setSellerId(int sellerId)
    {
        this.sellerId = sellerId;
    }






}
