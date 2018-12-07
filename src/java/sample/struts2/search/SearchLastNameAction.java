/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.search;

import sample.registration.RegistrationDAO;

/**
 *
 * @author Mochi
 */
public class SearchLastNameAction {
    private String searchLastName;
    private  final String SUCCESS = "success";
    private  final String FAIL = "fail";
    public int count;
    public SearchLastNameAction() {
    }
    
    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        dao.searchLastname(searchLastName);
        count = dao.returnCount();
        
        return FAIL;
    }

    /**
     * @return the searchLastName
     */
    public String getSearchLastName() {
        return searchLastName;
    }

    /**
     * @param searchLastName the searchLastName to set
     */
    public void setSearchLastName(String searchLastName) {
        this.searchLastName = searchLastName;
    }
    
}
