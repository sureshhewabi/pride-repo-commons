package uk.ac.ebi.pride.archive.repo.models.assay.instrument;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Collection;

/**
 * @author Jose A. Dianes
 * @version $Id$
 */
@Entity
@DiscriminatorValue("ANALYZER")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope= AnalyzerInstrumentComponent.class)
public class AnalyzerInstrumentComponent extends InstrumentComponent {
    @JsonIgnore
    @Override
    public Collection<? extends String> getAdditionalAttributesStrings() {
        return null;
    }
}
