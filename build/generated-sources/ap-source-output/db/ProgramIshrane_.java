package db;

import db.ProgramVezbanjaAb0;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-29T17:56:14")
@StaticMetamodel(ProgramIshrane.class)
public class ProgramIshrane_ { 

    public static volatile SingularAttribute<ProgramIshrane, Integer> ishId;
    public static volatile SingularAttribute<ProgramIshrane, Integer> ishkolProteina;
    public static volatile SingularAttribute<ProgramIshrane, Integer> ishkolMasti;
    public static volatile SingularAttribute<ProgramIshrane, Integer> ishkolUgljenihHidrata;
    public static volatile SetAttribute<ProgramIshrane, ProgramVezbanjaAb0> programVezbanjaAb0Set;
    public static volatile SingularAttribute<ProgramIshrane, String> ishPrimer;

}