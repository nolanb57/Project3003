/**

 * Enum for Item type.

 * classifies an item by type and gives a type code.

 * @author Nolan Birmingham

 */
public enum ItemType {

    AUDIO("AU"),
    VISUAL("VI"),
    AUDIO_MOBILE("AM"),
    VISUAL_MOBILE("VM");

    String code;

    /**

     * Sets the Item code for the Item type.

     */
    ItemType(String C){
        this.code = C;
    }

}
