package principale.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import principale.entity.ScontrinoR;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-03T14:32:27")
@StaticMetamodel(ScontrinoT.class)
public class ScontrinoT_ { 

    public static volatile SingularAttribute<ScontrinoT, Integer> idNeg;
    public static volatile SingularAttribute<ScontrinoT, LocalDate> data;
    public static volatile SetAttribute<ScontrinoT, ScontrinoR> righe;
    public static volatile SingularAttribute<ScontrinoT, Integer> id;

}