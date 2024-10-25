/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaswingdev.event;

import Restaurant.DTO.CategoryDTO;
import Restaurant.UI.POS;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author kalan
 */
public class ActionListenerHandler implements ActionListener{
    private ArrayList<CategoryDTO> categoryDTO;
    
    
    public ActionListenerHandler() {
    }
    
    

    public ActionListenerHandler(ArrayList<CategoryDTO> categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Fuck");
        String command = e.getActionCommand();
                            

        if (getCategoryList() != null) {
            for (CategoryDTO categoryDTO : getCategoryList()) {
                if (command.equals(categoryDTO.getCategoryName())) {
                    
                    JOptionPane.showMessageDialog(null, categoryDTO.getCatCode());
                    POS p = new POS(categoryDTO.getCatCode());
                }
            }
        }
        
//        JButton jButton = new JButton();
//        if (e.getSource() == getjButton()) {
//            for (MOTD motd : getMotdList()) {
//                MOTD m = new MOTD();
//                m.setId(Integer.parseInt(getjButton().getName())); 
//                if (motd.getId() == Integer.parseInt(getjButton().getName())) {
//                    new JPanelCashier(m);
//                }
//            }
//        }
        
    }
    
    
    /**
     * @return the categoryList
     */
    public ArrayList<CategoryDTO> getCategoryList() {
        return categoryDTO;
    }

    
    public void setCategoryList(ArrayList<CategoryDTO> categoryDTO) {
        this.categoryDTO = categoryDTO;
    }


    

    
}
