package org.studyeasy.SpringStarter.util.constants;

public enum Authorities {

    /*
    Aqui temos dois elementos. O primeiro é o ID da autoridade e, em seguida, 
    a string de autoridade ou nome da autoridade. 
    */
    RESET_ANY_USER_PASSWORD(authorityId:1l, authorityString:"RESET_ANY_USER_PASSWORD"),
    ACCESS_ADMIN_PANEL(authorityId:2l, authorityString:"ACCESS_ADMIM_PANEL");
    
    private Long authorityId;
    private String authorityString;
    
    private Authorities (Long authorityId, String authorityString){
        this.authorityId     = authorityId; 
        this.authorityString = authorityString;  

    }

    public Long getAuthorityId(){
        return authorityId;
    }

    public String getAuthorityString(){
        return authorityString;
    }

}
