package db;

import db.Cilj;
import db.ElementProgramaVezbanja;
import db.Nivo;
import db.Posetilac;
import db.ProgramIshrane;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-29T17:56:14")
@StaticMetamodel(ProgramVezbanjaAb0.class)
public class ProgramVezbanjaAb0_ { 

    public static volatile SingularAttribute<ProgramVezbanjaAb0, Integer> prvId;
    public static volatile SingularAttribute<ProgramVezbanjaAb0, String> prvNapomena;
    public static volatile SingularAttribute<ProgramVezbanjaAb0, Cilj> cljId;
    public static volatile SingularAttribute<ProgramVezbanjaAb0, Nivo> nivId;
    public static volatile SetAttribute<ProgramVezbanjaAb0, ElementProgramaVezbanja> elementProgramaVezbanjaSet;
    public static volatile SetAttribute<ProgramVezbanjaAb0, Posetilac> posetilacSet;
    public static volatile SingularAttribute<ProgramVezbanjaAb0, String> prvkrvnaGrupa;
    public static volatile SingularAttribute<ProgramVezbanjaAb0, ProgramIshrane> priId;

}