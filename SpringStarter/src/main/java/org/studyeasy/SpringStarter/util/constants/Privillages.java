package org.studyeasy.SpringStarter.util.constants;

public enum Privillages {
    
    //RESET_ANY_USER_PASSWORD(authorityId:1l, authorityString:"RESET_ANY_USER_PASSWORD");
    //ACCESS_ADMIN_PANEL(authorityId:2l, authorityString:"ACCESS_ADMIM_PANEL");
    
    private Long id;
    private String privillage;

    private Privillages (Long id, String privillage){
        this.id = id; 
        this.privillage  = privillage;  

    }

    public Long getAuthorityId(){
        return id;
    }

    public String getPrivillage(){
        return privillage;
    }

}
