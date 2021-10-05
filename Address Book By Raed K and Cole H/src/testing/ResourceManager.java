package testing;
/*This code is for writing data onto a save file and loading data from a save file   
 * Date: 6/7/20
 * Author: Raed K
 */
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ResourceManager {

    //This method takes in the variable "data" and outputs a save file containing the info the variable "data" has
    public static void save(Serializable data, String fileName) throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            oos.writeObject(data);
        }
    }
    //This method loads in the info contained in variable data, so that it can be outputted later
    public static Object load(String fileName) throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            return ois.readObject();
        }
    }
}
