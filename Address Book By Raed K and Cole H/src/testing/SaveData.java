package testing;
/*
 * This code is for serializing variables that can store permanent data, which can later be written into a save file
 * Date: 6/7/20
 * Author: Raed K, Cole H
 */
public class SaveData implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    //serialized string variables for every section, so that they can be stored even when the program is exited
    public String name;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public String zip;
    public String phoneNumber;
    public String email;
    public String miscellaneous;
}
