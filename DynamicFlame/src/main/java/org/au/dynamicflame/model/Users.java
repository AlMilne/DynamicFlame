package org.au.dynamicflame.model;

/**
 * Users.java - TODO Alasdair COMMENT MISSING.
 * 
 * @author Alasdair
 * @since 19/01/2014
 */
public class Users {

    private String username;
    private String password;
    private byte permissions;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the permissions
     */
    public byte getPermissions() {
        return permissions;
    }

    /**
     * @param permissions the permissions to set
     */
    public void setPermissions(byte permissions) {
        this.permissions = permissions;
    }

}
