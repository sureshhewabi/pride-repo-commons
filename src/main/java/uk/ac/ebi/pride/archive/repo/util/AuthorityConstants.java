package uk.ac.ebi.pride.archive.repo.util;

import org.springframework.security.core.GrantedAuthority;

public enum AuthorityConstants implements GrantedAuthority {

    /**
     * Full access to all the PRIDE projects, can make changes to all the PRIDE project,
     * such as: making project public
     */
    ADMINISTRATOR,

    /**
     * Data submitter, has access and control over the PRIDE projects owned by the submitter,
     * can make changes only to the PRIDE projects owned by the submitter
     */
    SUBMITTER,

    /**
     * Journal or testdata reviewer, has access to the PRIDE projects owned by the submitter
     */
    REVIEWER;

    public static AuthorityConstants fromString(String authority) {
        for (AuthorityConstants role : AuthorityConstants.values()) {
            if (role.toString().equalsIgnoreCase(authority.trim())) {
                return role;
            }
        }

        return null;
    }

    @Override
    public String getAuthority() {
        return name();
    }
}