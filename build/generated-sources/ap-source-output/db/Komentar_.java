package db;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-29T17:56:14")
@StaticMetamodel(Komentar.class)
public class Komentar_ { 

    public static volatile SingularAttribute<Komentar, Integer> prvId;
    public static volatile SingularAttribute<Komentar, Integer> posId;
    public static volatile SingularAttribute<Komentar, String> komTekst;
    public static volatile SingularAttribute<Komentar, Short> komOcena;
    public static volatile SingularAttribute<Komentar, Integer> komId;
    public static volatile SingularAttribute<Komentar, Date> komDatum;

}