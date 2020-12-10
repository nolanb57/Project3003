/**

 * A class to create and store different products.

 * A product is converted to a string for info.

 * @author Nolan Birmingham

 */
public abstract class Product implements Item{
    /**

     * The ID of the product.

     */
    int id;
    /**

     * The type of product being made.

     */
    ItemType type;
    /**

     * The manufacturer of the product.

     */
    String manufacturer;
    /**

     * The name of the product.

     */
    String name;

    /**

     * Constructor to create a Product.

     * @param manufacturer this products manufacturer.
     * @param name this products name.
     * @param type The type of product this is.

     */
    public Product(String name, String manufacturer, ItemType type){
        this.id = id;
        this.type = type;
        this.manufacturer = manufacturer;
        this.name = name;
    }

    /**

     * Prints product details as a string.

     * @return Returns a string with product details.

     */
    public String toString(){
        return "Name: " + getName() + "\nManufacturer: " + getManufacturer() + "\nType: " + type.code;
    }

    /**

     * Retrieves Item type.

     * @return Returns the item type.

     */
    public ItemType getType(){
        return ItemType.AUDIO;
    }
    /**

     * Retrieves Item ID.

     * @return Returns the item ID.

     */
    public int getId(){
        return id;
    }
    /**

     * Sets the name.

     */
    public void setName(String name){
        this.name = name;
    }
    /**

     * Retrieves Item name.

     * @return Returns the item name.

     */
    public String getName(){
        return name;
    }
    /**

     * sets the items manufacturer.

     */
    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }
    /**

     * Retrieves Item manufacturer.

     * @return Returns the item manufacturer.

     */
    public String getManufacturer(){
        return manufacturer;
    }

}
/**

 * A class to instantiate different products.

 * A widget is converted to a string for info.

 * @author Nolan Birmingham

 */
class Widget extends Product {
    Widget(String name, String manufacturer, ItemType type){ super(name, manufacturer, type); }
}
