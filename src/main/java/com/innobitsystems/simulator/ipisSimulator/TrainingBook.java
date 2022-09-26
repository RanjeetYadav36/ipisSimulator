package com.innobitsystems.simulator.ipisSimulator;
import java.text.*;
/**
 * Subclass of Book
 * @author Dan
 * Created 9/28/2012
 */
public class TrainingBook extends Book{
    /* Declare new variables */
     String ItemClass;
      
    /* Inheret conductor from Book */
    public TrainingBook(String itemNumber, String itemName, 
        Integer inStock, double priceEach, String itemClass) 
    {
        super(itemNumber, itemName, inStock, priceEach); 
        this.ItemClass = itemClass;
    }
     
    /* New Method for Item Class */
    public void setItemClass(String ItemClass)
    {
        ItemClass = ItemClass;
    }
    public String getItemClass()
    {
        return ItemClass;
    }
 
    /* Override and modify Calculation from Book class*/
    @Override
    public double getTotal()
    {
        return (this.PriceEach * this.InStock) * 1.05;
    }
    public void GetTwoDecimal()
    {
        DecimalFormat Form = new DecimalFormat("###,###.##");
        Form.format(getTotal());
    }
    /* Override toString to format output */
    @Override
    public String toString()
    {
        return String.format(ItemNumber + "\t" + ItemName + "\t" + InStock
           + "\t\t" + PriceEach + "\t\t" + ItemClass + "\t" + getTotal() );
    }
}/* end class */