/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Restaurant.Database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author kalan
 */
public class getProperties {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = getProperties.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Sorry, unable to find db.properties");
//                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    
}
