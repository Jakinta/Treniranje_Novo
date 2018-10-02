package db;

import db.ProgramVezbanjaAb0;
import db.Trening;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-29T17:56:14")
@StaticMetamodel(Posetilac.class)
public class Posetilac_ { 

    public static volatile SingularAttribute<Posetilac, ProgramVezbanjaAb0> prvId;
    public static volatile SingularAttribute<Posetilac, Integer> posId;
    public static volatile SingularAttribute<Posetilac, String> posPassword;
    public static volatile SetAttribute<Posetilac, Trening> treningSet;
    public static volatile SingularAttribute<Posetilac, String> posEmail;
    public static volatile SingularAttribute<Posetilac, String> posIme;
    public static volatile SingularAttribute<Posetilac, String> posPrezime;

}