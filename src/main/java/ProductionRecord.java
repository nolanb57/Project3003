import java.util.Date;
/**

 * Represents an Movie Player with Movie controls.

 * A Movie player is converted to a string for info.

 * @author Nolan Birmingham

 */
public class ProductionRecord{
    /**

     * The production number.

     */
    int productionNumber;
    /**

     * The product id.

     */
    int productID;
    /**

     * The serial number of a product.

     */
    String serialNumber;
    /**

     * The date a product was produced.

     */
    Date dateProduced;
    /**

     * The number of a product.

     */
    int num;
    /**

     * The serial number variable.

     */
    String serial;

    /**

     * Default constructor to create a Production Record.

     * @param productID the ID of a product.

     */
    public ProductionRecord(int productID){
        this.productID = productID;
        this.serialNumber = "0";
        this.productionNumber = 0;
        this.dateProduced = new Date();
    }

    /**

     * Constructor to create a custom Production Record.

     * @param productionNumber the products production number
     * @param productID this products ID.
     * @param serialNumber The product's serial number.
     * @param dateProduced the production date for the product.

     */
    public ProductionRecord(int productionNumber, int productID, String serialNumber, Date dateProduced){
        this.productionNumber = productionNumber;
        this.productID = productID;
        this.serialNumber = serialNumber;
        this.dateProduced = dateProduced;
    }
    /**

     * Constructor to create a Production record serial number.

     * @param product this product name.
     * @param productionAmt the amount of products produced.

     */
    public void ProductionRecord(Product product, int productionAmt){
        this.serialNumber = createSerialNum(product, productionAmt);
    }

    /**

     * Creates and prints serial number as a string.

     * @return Returns a string with a serial number.

     */
    public String createSerialNum(Product product, int productionAmt){
        String serialNumber;
        serialNumber = product.getManufacturer().substring(0,2) + product.getType().code;
        return serialNumber;
    }

    /**

     * Sets the production number for a product.

     */
    public void setProductionNum(int num){
        productionNumber = num;
    }
    /**

     * Retrieves a production number of a product.

     * @return Returns a production number.

     */

    public int getProductionNum(){
        return productionNumber;
    }
    /**

     * Sets the products ID.

     */
    public void setProductID(int num){
        productID = num;
    }
    /**

     * Retrieves the product ID.

     * @return Returns the products ID.

     */
    public int getProductID(){
        return productID;
    }
    /**

     * Sets the products serial number.

     */
    public void setSerialNum(String serial){
        serialNumber = serial;
    }
    /**

     * Retrieves serial number.

     * @return Returns a serial number.

     */
    public String getSerialNum(){
        return serialNumber;
    }
    /**

     * Sets the date a product was produced.

     */
    public void setProdDate(Date dateProduced){
        this.dateProduced = dateProduced;
    }
    /**

     * Retrieves the date a product was produced.

     * @return Returns the date produced.

     */
    public Date getProdDate(){
        return dateProduced;
    }
    /**

     * Creates and prints production log as a string.

     * @return Returns a string with a serial number.

     */
    public String toString(){
        return "Prod. Num: " + getProductionNum() + " Product ID: " + getProductID() + " Serial Num: " + getSerialNum() + " Date: " + getProdDate();
    }

}
