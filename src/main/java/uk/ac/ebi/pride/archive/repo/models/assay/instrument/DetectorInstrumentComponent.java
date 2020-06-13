package uk.ac.ebi.pride.archive.repo.models.assay.instrument;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Collection;

/**
 * @author Jose A. Dianes
 * @version $Id$
 */
@Entity
@DiscriminatorValue("DETECTOR")
public class DetectorInstrumentComponent extends InstrumentComponent {
    @Override
    public Collection<? extends String> getAdditionalAttributesStrings() {
        return null;
    }
}
