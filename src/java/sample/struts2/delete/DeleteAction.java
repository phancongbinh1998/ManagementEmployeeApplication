/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.delete;

import sample.registration.RegistrationDAO;

/**
 *
 * @author Mochi
 */
public class DeleteAction {
    private String username;
    private String searchLastValue;
    
    private  final String SUCCESS = "success";
    private  final String FAIL = "fail";
    
    public DeleteAction() {
    }
    
    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        boolean result = dao.deleteAcount(username);
        String url = FAIL;
        if(result){
            url = SUCCESS;
        }
        return url;
    }

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
     * @return the searchLastValue
     */
    public String getSearchLastValue() {
        return searchLastValue;
    }

    /**
     * @param searchLastValue the searchLastValue to set
     */
    public void setSearchLastValue(String searchLastValue) {
        this.searchLastValue = searchLastValue;
    }
    
}
