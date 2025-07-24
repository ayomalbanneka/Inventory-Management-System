/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.jiat.ims.validate;

import javax.swing.JOptionPane;

public class Validator {

    private static final String EMAIL = "^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    private static final String MOBILE = "^(0{1})(7{1})([0|1|2|4|5|6|7|8]{1})([0-9]{7})";
    private static final String PASSWORD = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";

    public static boolean isEmailValid(String value) {
        if (value.isBlank()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Email input cannot be empty",
                    "Email Validation",
                    JOptionPane.WARNING_MESSAGE
            );

            return false;
        } else if (!value.matches(EMAIL)) {

            JOptionPane.showMessageDialog(
                    null,
                    "Enter a valid email address",
                    "Email Validation",
                    JOptionPane.WARNING_MESSAGE
            );

            return false;
        }

        return true;
    }

    public static boolean isMobielValid(String value) {
        if (value.isBlank()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Mobile number input cannot be empty",
                    "Mobile Validation",
                    JOptionPane.WARNING_MESSAGE
            );

            return false;
        } else if (!value.matches(MOBILE)) {

            JOptionPane.showMessageDialog(
                    null,
                    "Enter the mobile number",
                    "Mobile Validation",
                    JOptionPane.WARNING_MESSAGE
            );

            return false;
        }
        return true;
    }

    public static boolean isPasswordValid(String value) {
        if (value.isBlank()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Password must include the following characters. \n"
                    + "At least one lowercase, \n"
                    + "At least one upppercase, \n"
                    + "a special chracter, \n"
                    + "The password must be greater than 4 and less 8 character",
                    "Password Validation",
                    JOptionPane.WARNING_MESSAGE
            );

            return false;
        } else if (!value.matches(PASSWORD)) {

            JOptionPane.showMessageDialog(
                    null,
                    "Enter a password",
                    "Password Validation",
                    JOptionPane.WARNING_MESSAGE
            );

            return false;
        }
        return true;
    }

}
