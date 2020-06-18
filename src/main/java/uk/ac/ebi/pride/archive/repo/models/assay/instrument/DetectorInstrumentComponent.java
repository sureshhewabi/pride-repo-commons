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
@DiscriminatorValue("DETECTOR")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope= DetectorInstrumentComponent.class)
public class DetectorInstrumentComponent extends InstrumentComponent {
    @JsonIgnore
    @Override
    public Collection<? extends String> getAdditionalAttributesStrings() {
        return null;
    }
}
