/**

 * Interface of an Item.

 * used with functions to define elements of an item.

 * @author Nolan Birmingham

 */
public interface Item {
    /**

     * Gets the ID for an item.

     */
    public int getId();
    /**

     * Sets the name for an item.

     */
    public void setName(String name);
    /**

     * Gets the name for an item.

     */
    public String getName();
    /**

     * Sets the manufacturer name for an item.

     */
    public void setManufacturer(String manufacturer);
    /**

     * Gets the manufacturer name for an item.

     */
    public String getManufacturer();
}
