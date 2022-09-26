package com.innobitsystems.simulator.ipisSimulator;
 
/**
 * Book Class
 * @author Dan
 * Modified 9/27/2012
 */
public class Book implements Comparable{
    /* Define variables */
     
    protected String ItemNumber;
    protected String ItemName;
    protected Integer InStock;
    protected double PriceEach;
     
    /* Parameterized Constructor */
    public Book(String ItemNumber, String ItemName, Integer InStock, double PriceEach)
    {
        this.ItemNumber = ItemNumber;
        this.ItemName = ItemName;
        this.InStock = InStock;
        this.PriceEach = PriceEach;
 
    }
     
    /* Calculate value of stock */
    public double getTotal()
    {
        return this.PriceEach * this.InStock;
    }
    /* Define Set and Get functions */
    public void setItemNumber(String itemNumber)
    {
        ItemNumber = ItemNumber;
    }
    public String getItemNumber()
    {
        return ItemNumber;
    }
    public void setItemName(String itemName)
    {
        ItemName = ItemName;
    }
    public String getItemName()
    {
        return ItemName;
    }
    public void setInStock(Integer inStock)
    {
        InStock = InStock;
    }
    public Integer getInStock()
    {
        return InStock;
    }
    public void setPriceEach(double priceEach)
    {
        PriceEach = PriceEach;
    }
    public double getPriceEach()
    {
        return PriceEach;
    }
     
    /* Sort array by name? */
    @Override
    public int compareTo(Object o)
    {
        Book inputParameter = (Book)o;
        return ItemName.compareTo(inputParameter.ItemName);
    }
    /* Override otString to display array data */
    @Override
    public String toString()
    {
        return String.format(ItemNumber + "\t" + ItemName + "\t" + InStock + "\t\t" + PriceEach);
    }
} /* End class */