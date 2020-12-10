import java.util.*;
import java.lang.Character;
import java.io.*;
/**

 * A class to create and store different employees usernames and passwords.

 * @author Nolan Birmingham

 */
public class Employee {

    /**

     * The name of an employee.

     */
    String name;
    /**

     * The username of the employee.

     */
    String username;
    /**

     * The employee password.

     */
    String password;
    /**

     * The email of an employee.

     */
    String email;
    /**

     * Checks the name to make sure its valid.

     * @param name name of the employee.

     */
    public int checkName(String name){
        char c=' ';
        int flag=0;
        int i;
        int length = name.length();
        for(i=0;i<length;i++){
            if(name.charAt(i)==c)
                flag=1;
        }
        return flag;
    }
    /**

     * Checks the password to make sure its valid.

     * @param password password of the employee.

     */
    public int isValidPassword(String password){

        int flaglowercase=0;
        int flaguppercase=0;
        int flagspecialchar=0;
        int flagotherchar=0;
        int length = password.length();
        for(int i=0;i<length;i++){
            char ch=password.charAt(i);
            if(Character.isUpperCase(ch))
                flaguppercase=1;
            else if(Character.isLowerCase(ch))
                flaglowercase=1;
            else if(ch=='"' ||ch=='!'||ch=='@'||ch=='&'||ch=='$'||ch=='#'||ch=='%'||ch=='^'||ch=='*')
                flagspecialchar=1;
            else
                flagotherchar=1;
        }
        if(flaglowercase==1 && flaguppercase==1 && flagspecialchar==1 && flagotherchar==0)
            return 1;
        else
            return 0;
    }
    /**

     * sets the employees default username.

     * @param name name of the employee.

     */
    public void setUsername(String name){
        int i,pos=0;
        char c=' ';
        String username="";
        name.toLowerCase();

        int length = name.length();
        for(i=0;i<length;i++){
            if(name.charAt(i)==c){
                pos=i+1;
                break;
            }
        }
        username=username+name.charAt(0);
        for(i=pos;i<length;i++)
            username=username+name.charAt(i);
        this.username=username.toLowerCase();
    }
    /**

     * sets the employees default email.

     * @param name name of the employee.

     */
    public void setEmail(String name){

        char c=' ';
        String email="";
        name.toLowerCase();
        int length = name.length();
        for(int i=0;i<length;i++){
            if(name.charAt(i)==c)
                email=email+".";
            else
                email=email+name.charAt(i);
        }
        email=email.toLowerCase()+"@oracleacademy.Test";
        this.email=email;
    }

    /**

     * Prints employee details as a string.

     * @return Returns a string with employee details.

     */
    public String toString() {
        return "\nEmployee Details\nName:"+this.name+"\nUsername:"+this.username+"\nEmail:"+this.email+"\nInitial Password:"+this.password;
    }
    /**

     * Constructor to create an employee.

     * @param name this employees name.
     * @param password the employees password.

     */
    Employee(String name,String password){

        this.name=name;
        if(checkName(name)==1){
            setUsername(name);
            setEmail(name);
        }
        else{
            this.username="default";
            this.email="user@oracleacademy.Test";
        }
        if(isValidPassword(password)==1)
            this.password=password;
        else
            this.password="pw";
    }

}
