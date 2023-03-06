/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.table.*;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import view.ControlPanal;

/**
 *
 * @author buddi
 */
public class dbIO {

    public void staffIN(String Name, String Address, String gender, String Email, String Date, String Pnumber, String UN, String pwd) {
        try {
            DBM.iud("insert into staffInfo values('" + Name + "','" + Address + "','" + gender + "','" + Email + "','" + Date + "','" + Pnumber + "','" + UN + "','" + pwd + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void staffLogin(String username, String password, JFrame loginframe) {
        try {

            ResultSet r = DBM.search("SELECT * FROM staffInfo WHERE username='" + username + "'");
            if (r.next()) {
                if (password.equals(r.getString("password"))) {
                    JOptionPane.showMessageDialog(null, "Successfully logged in", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                    loginframe.dispose();
                    new ControlPanal().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Type the correct password", "wrong password", JOptionPane.ERROR_MESSAGE);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Type the correct username", "wrong usename", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Something's wrong", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void adminAccess(String username, String password) {
        try {

            ResultSet r = DBM.search("SELECT * FROM staffInfo WHERE username='" + username + "'");
            if (r.next()) {
                if (password.equals(r.getString("password"))) {
                } else {
                    JOptionPane.showMessageDialog(null, "Type the correct password", "wrong password", JOptionPane.ERROR_MESSAGE);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Type the correct username", "wrong usename", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Something's wrong", JOptionPane.ERROR_MESSAGE);

        }

    }

    public static boolean ifUnique(String whereToLook, String primeryOfIt, String stringLookUp) {
        try {
            ResultSet r = DBM.search("select * from '" + whereToLook + "' where " + primeryOfIt + "='" + stringLookUp + "'");
            return !r.next();
        } catch (Exception e) {
        }
        return true;
    }

    public void populateCustomerTable(JTable whatTable, String whatField, JTextField IField) {
        try {
            ResultSet rs = DBM.search("select * from customerInfo where " + whatField + " like '%" + IField.getText() + "%'");
            if (IField.getText().equals("")) {
                rs = DBM.search("select * from customerInfo");
            }
            ResultSetMetaData rsmd = rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) whatTable.getModel();
            model.setRowCount(0);
            String[] colname = new String[rsmd.getColumnCount()];
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                colname[i] = rsmd.getColumnName(i + 1);
                model.setColumnIdentifiers(colname);
            }

            while (rs.next()) {

                String[] row = {rs.getString("roomNo"), rs.getString("name"), rs.getString("address"), rs.getString("phoneNo"), rs.getString("roomType"), rs.getString("guestNo"), rs.getString("checkIn"), rs.getString("checkOut"), rs.getString("NIC")};
                model.addRow(row);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ee) {

        }

    }

    public void reloadCustomerTable(JTable whichTable) {
        try {
            ResultSet rs = DBM.search("select * from customerInfo");
            ResultSetMetaData rsmd = rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) whichTable.getModel();
            model.setRowCount(0);
            String[] colname = new String[rsmd.getColumnCount()];
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                colname[i] = rsmd.getColumnName(i + 1);
                model.setColumnIdentifiers(colname);
            }

            while (rs.next()) {

                String[] rows = {rs.getString("roomNo"), rs.getString("name"), rs.getString("address"), rs.getString("phoneNo"), rs.getString("roomType"), rs.getString("guestNo"), rs.getString("checkIn"), rs.getString("checkOut"), rs.getString("NIC")};
                model.addRow(rows);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {

        }
    }

    public void customerIN(JTextField NIC, String roomNo, JTextField name, String address, JTextField phoneNo, JComboBox roomType, JComboBox guestNo, JDateChooser checkIn, JDateChooser checkOut, JTable table) {
        try {
            String dtccheckin = new SimpleDateFormat("yyyy/MM/dd").format(checkIn.getDate());
            String dtccheckout = new SimpleDateFormat("yyyy/MM/dd").format(checkOut.getDate());

            LocalDateTime from = LocalDateTime.ofInstant(checkIn.getDate().toInstant(), ZoneId.systemDefault());
            LocalDateTime to = LocalDateTime.ofInstant(checkOut.getDate().toInstant(), ZoneId.systemDefault());
            Duration d = Duration.between(from, to);
            System.out.println(d.toDays());
            DBM.iud("insert into customerDays values('" + NIC.getText() + "','" + d.toDays() + "')");

            DBM.iud("insert into customerInfo values('" + roomNo.replace(",", ", ") + "','" + name.getText() + "','" + address + "','" + phoneNo.getText() + "','" + roomType.getSelectedItem().toString() + "','" + guestNo.getSelectedItem().toString() + "','" + dtccheckin + "','" + dtccheckout + "','" + NIC.getText() + "')");
            roomsIN(roomNo.replace(",", ", "), NIC.getText());
            new dbIO().reloadCustomerTable(table);
            JOptionPane.showMessageDialog(null, "Successfully Submitted", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {

        }
    }

    public void customerINCPL(JTextField NIC, String roomNo, JTextField name, String address, JTextField phoneNo, JComboBox roomType, JComboBox guestNo, JDateChooser checkIn, JDateChooser checkOut) {
        try {
            String dtccheckin = new SimpleDateFormat("yyyy/MM/dd").format(checkIn.getDate());
            String dtccheckout = new SimpleDateFormat("yyyy/MM/dd").format(checkOut.getDate());

            LocalDateTime from = LocalDateTime.ofInstant(checkIn.getDate().toInstant(), ZoneId.systemDefault());
            LocalDateTime to = LocalDateTime.ofInstant(checkOut.getDate().toInstant(), ZoneId.systemDefault());
            Duration d = Duration.between(from, to);
            System.out.println(d.toDays());

            DBM.iud("insert into customerDays values('" + NIC.getText() + "','" + d.toDays() + "')");
            DBM.iud("insert into customerInfo values('" + roomNo + "','" + name.getText() + "','" + address + "','" + phoneNo.getText() + "','" + roomType.getSelectedItem().toString() + "','" + guestNo.getSelectedItem().toString() + "','" + dtccheckin + "','" + dtccheckout + "','" + NIC.getText() + "')");
            JOptionPane.showMessageDialog(null, "Successfully Submitted", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {

        }
    }

    public void customerUPDATE(JTable whichTable) {
        int row = whichTable.getSelectedRow();
        String[] cell = new String[9];
        for (int i = 0; i < 9; i++) {
            cell[i] = whichTable.getModel().getValueAt(row, i).toString();
            System.out.println(cell[i]);
        }

        try {

            if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (!cell[0].contains(", ")) {
                    cell[0] = cell[0].replace(",", ", ");
                }
                DBM.iud("update rooms set owner='' where owner='" + cell[8] + "'");
                DBM.iud("update customerInfo set roomNo='" + cell[0] + "', name='" + cell[1] + "', address='" + cell[2] + "', phoneNo='" + cell[3] + "', roomType='" + cell[4] + "', guestNo='" + cell[5] + "', checkIn='" + cell[6] + "', checkOut='" + cell[7] + "', NIC='" + cell[8] + "'  where NIC = '" + cell[8] + "'");
                roomsIN(cell[0], cell[8]);
                JOptionPane.showMessageDialog(null, "Edited Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Edited Unsuccesful!");
            }
            new dbIO().reloadCustomerTable(whichTable);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void customerDELETE(JTable whichTable) {
        int row = whichTable.getSelectedRow();
        String cell = whichTable.getModel().getValueAt(row, 8).toString();
        try {
            if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                roomsIN(whichTable.getModel().getValueAt(row, 0).toString(), "");
                DBM.iud("delete from customerDays where NIC = '" + cell + "'");
                DBM.iud("delete from customerInfo where NIC = '" + cell + "'");
                DBM.iud("delete from customerFoodInfo where NIC = '" + cell + "'");

                JOptionPane.showMessageDialog(null, "Delete Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Delete Unsuccesful!");
            }
            new dbIO().reloadCustomerTable(whichTable);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void rooms(JList rooms, String roomid) {
        DefaultListModel model = new DefaultListModel();
        rooms.setModel(model);
        try {
            ResultSet rs = DBM.search("select roomID from rooms WHERE (owner IS NULL OR owner = '') AND roomID like '" + roomid + "%' ");
            int[] listitems = new int[200];
            for (int i = 0; rs.next(); i++) {
                listitems[i] = rs.getInt("roomID");
                model.addElement("Room No " + listitems[i]);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void roomsIN(String list, String owner) {
        try {
            String[] roomsOwned;
            roomsOwned = list.split(", ");

            int i = 0;
            while (!roomsOwned[i].isEmpty()) {
                if (!roomsOwned[i].contains(" ")) {
                    roomsOwned[i] = roomsOwned[i].replace(" ", "");
                }
                DBM.iud("update rooms set owner='" + owner + "' where roomID='" + roomsOwned[i] + "'");
                i++;
            }
//            i = 0;
//            ResultSet rs = DBM.search("select * from rooms where owner='" + owner + "'");
//            while (rs.next()) {
//                if (rs.getString("roomID").equals(roomsOwned[i])) {
//                    i++;
//                }
//                DBM.iud("update rooms set owner='' where roomID='" + roomsOwned[i] + "'");
//                i++;
//            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        } catch (Exception ee) {
            System.out.println(ee);
        }
    }

    public static void roomsIN(JButton list, JTextField owner) {
        try {
            String[] roomsOwned;
            roomsOwned = list.getText().split(",");

            int i = 0;
            while (!roomsOwned[i].isEmpty()) {
                DBM.iud("update rooms set owner='" + owner.getText() + "' where roomID='" + roomsOwned[i].replace(" ", "") + "'");
                i++;
            }
//            i = 0;
//            ResultSet rs = DBM.search("select * from rooms where owner='" + owner + "'");
//            while (rs.next()) {
//                if (rs.getString("roomID").equals(roomsOwned[i])) {
//                    i++;
//                }
//                DBM.iud("update rooms set owner='' where roomID='" + roomsOwned[i] + "'");
//                i++;
//            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ee) {
            System.out.println(ee);
        }
    }

    public static void roomsReset(String owner) {
        try {

            DBM.iud("update rooms set owner='' where owner='" + owner + "'");

//            i = 0;
//            ResultSet rs = DBM.search("select * from rooms where owner='" + owner + "'");
//            while (rs.next()) {
//                if (rs.getString("roomID").equals(roomsOwned[i])) {
//                    i++;
//                }
//                DBM.iud("update rooms set owner='' where roomID='" + roomsOwned[i] + "'");
//                i++;
//            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        } catch (Exception ee) {
            System.out.println(ee);
        }
    }

    public void populateFoodTable(JTable whichTable, String whichtime) {
        try {
            ResultSet rs = DBM.search("select * from " + whichtime + "Foods");
            ResultSetMetaData rsmd = rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) whichTable.getModel();
            model.setRowCount(0);
            String[] colname = new String[rsmd.getColumnCount()];
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                colname[i] = rsmd.getColumnName(i + 1);
                model.setColumnIdentifiers(colname);
            }

            while (rs.next()) {

                String[] rows = {rs.getString("name"), rs.getString("price")};
                model.addRow(rows);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {

        }

    }

    public void populateFoodTable(JTable whichTable, JComboBox whichtime, JTextField whatfood) {
        try {
            ResultSet rs = DBM.search("select * from " + whichtime.getSelectedItem().toString() + "Foods where name like '%" + whatfood.getText() + "%'");
            ResultSetMetaData rsmd = rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) whichTable.getModel();
            model.setRowCount(0);
            String[] colname = new String[rsmd.getColumnCount()];
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                colname[i] = rsmd.getColumnName(i + 1);
                model.setColumnIdentifiers(colname);
            }

            while (rs.next()) {

                String[] rows = {rs.getString("name"), rs.getString("price")};
                model.addRow(rows);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {

        }

    }

    public void foodIN(JTextField name, JTextField price, JComboBox whichtime, JTable table) {
        try {
            DBM.iud("insert into " + whichtime.getSelectedItem().toString() + "foods values('" + name.getText() + "','" + price.getText() + "')");
            new dbIO().populateFoodTable(table, whichtime.getSelectedItem().toString());
            JOptionPane.showMessageDialog(null, "Successfully Submitted", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {

        }
    }

    public void foodUPDATE(JTable table, JComboBox whichtime) {
        int row = table.getSelectedRow();
        String[] cell = new String[2];
        for (int i = 0; i < 2; i++) {
            cell[i] = table.getModel().getValueAt(row, i).toString();
            System.out.println(cell[i]);
        }

        try {

            if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                DBM.iud("update " + whichtime.getSelectedItem().toString() + "foods set name='" + cell[0] + "', price='" + cell[1] + "' where name='" + cell[0] + "'");
                new dbIO().populateFoodTable(table, whichtime.getSelectedItem().toString());
                JOptionPane.showMessageDialog(null, "Edited Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Edited Unsuccesful!");
            }
            new dbIO().populateFoodTable(table, whichtime.getSelectedItem().toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void foodDELETE(JTable whichTable, JComboBox whichtime) {
        int row = whichTable.getSelectedRow();
        String cell = whichTable.getModel().getValueAt(row, 0).toString();
        System.out.println(cell);
        try {
            if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                DBM.iud("DELETE FROM " + whichtime.getSelectedItem().toString() + "foods where name = '" + cell + "'");
                new dbIO().populateFoodTable(whichTable, whichtime.getSelectedItem().toString());
                JOptionPane.showMessageDialog(null, "Delete Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Delete Unsuccesful!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {

        }
    }

    public static void reloadCustomerFoodTable(JTable whichTable, String who) {
        try {
            ResultSet rs = DBM.search("select roomNo,name from customerInfo where roomNo like '%" + who + "%' or name like '%" + who + "%'");
            ResultSetMetaData rsmd = rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) whichTable.getModel();
            model.setRowCount(0);
            String[] colname = new String[rsmd.getColumnCount()];
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                colname[i] = rsmd.getColumnName(i + 1);
                model.setColumnIdentifiers(colname);
            }

            while (rs.next()) {

                String[] rows = {rs.getString("roomNo"), rs.getString("name")};
                model.addRow(rows);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {

        }
    }

    public static void reloadCustomerFoodInfoTable(JTable whichTable, String who) {
        try {
            ResultSet rs = DBM.search("select name,food,quantity from customerFoodInfo where name like '%" + who + "%'");
            ResultSetMetaData rsmd = rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) whichTable.getModel();
            model.setRowCount(0);
            String[] colname = new String[rsmd.getColumnCount()];
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                colname[i] = rsmd.getColumnName(i + 1);
                model.setColumnIdentifiers(colname);
            }

            while (rs.next()) {

                String[] rows = {rs.getString("name"), rs.getString("food"), rs.getString("quantity"),};
                model.addRow(rows);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {

        }
    }

    public static void customerFoodIN(JTable cusTable, JTable foodTable, JTextField who, JSpinField quantity, JComboBox food) {
        try {
            String[] cellCusTable = new String[2];
            for (int i = 0; i < 2; i++) {
                cellCusTable[i] = cusTable.getModel().getValueAt(cusTable.getSelectedRow(), i).toString();
                System.out.println(cellCusTable[i]);
            }
            DBM.iud("insert into customerFoodInfo (NIC,name,food,quantity) select NIC,'" + cellCusTable[1] + "','" + food.getSelectedItem().toString() + "','" + String.valueOf(quantity.getValue()) + "' from customerInfo where roomNo='" + cellCusTable[0] + "' and name='" + cellCusTable[1] + "'");
            JOptionPane.showMessageDialog(null, "Successfully Submitted", "Success", JOptionPane.INFORMATION_MESSAGE);
            reloadCustomerFoodInfoTable(foodTable, who.getText());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {

        }
    }

    public static void customerFoodInfoDELETE(JTable whichTable) {

        String[] cell = new String[3];
        for (int i = 0; i < 3; i++) {
            cell[i] = whichTable.getModel().getValueAt(whichTable.getSelectedRow(), i).toString();
            System.out.println(cell[i]);
        }
        try {
            if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                roomsIN(whichTable.getModel().getValueAt(whichTable.getSelectedRow(), 0).toString(), "");
                DBM.iud("delete from customerFoodInfo where name='" + cell[0] + "' and food='" + cell[1] + "' and quantity='" + cell[2] + "'");
                reloadCustomerFoodInfoTable(whichTable, "");
                JOptionPane.showMessageDialog(null, "Delete Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Delete Unsuccesful!");
            }
            reloadCustomerFoodInfoTable(whichTable, cell[0]);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void reloadCustomerFoodInfoTable(JTable whichTable, JTable cusTable) {
        try {
            String[] cellCusTable = new String[2];
            for (int i = 0; i < 2; i++) {
                cellCusTable[i] = cusTable.getModel().getValueAt(cusTable.getSelectedRow(), i).toString();
                System.out.println(cellCusTable[i]);
            }
            ResultSet rs = DBM.search("select name,food,quantity from customerFoodInfo where name like '%" + cellCusTable[1] + "%'");
            ResultSetMetaData rsmd = rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) whichTable.getModel();
            model.setRowCount(0);
            String[] colname = new String[rsmd.getColumnCount()];
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                colname[i] = rsmd.getColumnName(i + 1);
                model.setColumnIdentifiers(colname);
            }

            while (rs.next()) {

                String[] rows = {rs.getString("name"), rs.getString("food"), rs.getString("quantity"),};
                model.addRow(rows);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {

        }

    }

    public void loadPaymentBill(JTable whichTable) {
        try {
            String[] cell = new String[4];
            for (int i = 0; i < 4; i++) {
                cell[i] = whichTable.getModel().getValueAt(whichTable.getSelectedRow(), i).toString();
                System.out.println(cell[i]);
            }
            int priceFood = 0;
            ResultSet rst = DBM.search("select * from customerFoodInfo where NIC='" + cell[1] + "'");
            while (rst.next()) {
                ResultSet rsb = DBM.search("select * from breakfastFoods where name='" + rst.getString("food") + "'");
                if (rsb.next()) {
                    priceFood = priceFood + Integer.parseInt(rst.getString("quantity")) * Integer.parseInt(rsb.getString("price"));
                }
                ResultSet rsl = DBM.search("select * from lunchFoods where name='" + rst.getString("food") + "'");
                if (rsl.next()) {
                    priceFood = priceFood + Integer.parseInt(rst.getString("quantity")) * Integer.parseInt(rsl.getString("price"));
                }
                ResultSet rsd = DBM.search("select * from dinnerFoods where name='" + rst.getString("food") + "'");
                if (rsl.next()) {
                    priceFood = priceFood + Integer.parseInt(rst.getString("quantity")) * Integer.parseInt(rsd.getString("price"));
                }
                System.out.println(priceFood);
            }
            ResultSet rsr = DBM.search("select * from customerInfo where NIC='" + cell[1] + "'");
            rsr.next();

            HashMap<String, Object> hm = new HashMap<>();
            System.out.println(cell[0]);
            hm.put("parameter1", cell[0]);
            hm.put("parameter2", rsr.getString("roomNo"));
            System.out.println(rsr.getString("roomNo"));
            ResultSet rsda = DBM.search("select * from customerDays where NIC='" + cell[1] + "'");
            rsda.next();
            String days = rsda.getString("days");
            hm.put("parameter3", days);
            System.out.println(days);
            ResultSet rsf = DBM.search("select * from customerFoodInfo where NIC='" + cell[1] + "'");
            String param = "";
            while (rsf.next()) {
                param = param + "\n" + rsf.getString("quantity") + " portions of " + rsf.getString("food");
                System.out.println(rsf.getString("quantity") + " portions of " + rsf.getString("food"));
            }
            hm.put("parameter4", param);
            ResultSet rsrp = DBM.search("select * from roomPrices where type in (select roomType from customerInfo where NIC='" + cell[1] + "')");
            rsrp.next();
            int fullPrice = priceFood + Integer.parseInt(rsrp.getString("price")) * Integer.parseInt(days);

            hm.put("parameter5", String.valueOf(fullPrice));

            hm.put("parameter6", String.valueOf(priceFood));
            System.out.println(fullPrice);
            JasperDesign idesign = JRXmlLoader.load("src\\view\\payment.jrxml");
            JasperReport rpt = JasperCompileManager.compileReport(idesign);
            JasperPrint prt = JasperFillManager.fillReport(rpt, hm, new JREmptyDataSource());
            JasperViewer.viewReport(prt, false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void loadPaymentTable(JTable whichTable, String who) {
        try {
            ResultSet rsg = DBM.search("select name,customerInfo.NIC,roomType,customerDays.days from customerInfo inner join customerDays on customerDays.NIC=customerInfo.NIC WHERE name LIKE '%" + who + "%' or roomType LIKE '%" + who + "%'");
            DefaultTableModel model = (DefaultTableModel) whichTable.getModel();
            model.setRowCount(0);

            while (rsg.next()) {

                String[] rows = {rsg.getString("name"), rsg.getString("NIC"), rsg.getString("roomType"), rsg.getString("days")};
                model.addRow(rows);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {

        }
    }
}
