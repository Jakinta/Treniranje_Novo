package db;

import db.ElementProgramaVezbanjaPK;
import db.ProgramVezbanjaAb0;
import db.Vezba;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-29T17:56:14")
@StaticMetamodel(ElementProgramaVezbanja.class)
public class ElementProgramaVezbanja_ { 

    public static volatile SingularAttribute<ElementProgramaVezbanja, Integer> epvTrajanje;
    public static volatile SingularAttribute<ElementProgramaVezbanja, Integer> epvUcestalost;
    public static volatile SingularAttribute<ElementProgramaVezbanja, Vezba> vezba;
    public static volatile SingularAttribute<ElementProgramaVezbanja, ElementProgramaVezbanjaPK> elementProgramaVezbanjaPK;
    public static volatile SingularAttribute<ElementProgramaVezbanja, String> epvNapomena;
    public static volatile SingularAttribute<ElementProgramaVezbanja, Integer> epvbrPonavljanja;
    public static volatile SingularAttribute<ElementProgramaVezbanja, Integer> epvbrSerija;
    public static volatile SingularAttribute<ElementProgramaVezbanja, ProgramVezbanjaAb0> programVezbanjaAb0;

}