package uk.ac.ebi.pride.archive.repo.models.accession;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * {@code ProjectAccession} is a wrapper object for a list of pride accessions
 * This object is designed mainly for web service, wrapping a list of accessions in an object
 * will enable easy consumption by the client, for instance: JavaScript client libraries like Ext JS, GWT
 *
 * @author Rui Wang
 * @version $Id$
 */
public class PrideAccessions {
    private final Set<String> accessions;

    public PrideAccessions() {
        this.accessions = new LinkedHashSet<String>();
    }

    public void addAccession(String accession) {
        this.accessions.add(accession);
    }

    public Set<String> getAccessions() {
        return accessions;
    }
}
