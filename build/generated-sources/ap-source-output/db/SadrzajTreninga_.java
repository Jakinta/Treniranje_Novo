package db;

import db.SadrzajTreningaPK;
import db.Trening;
import db.Vezba;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-29T17:56:14")
@StaticMetamodel(SadrzajTreninga.class)
public class SadrzajTreninga_ { 

    public static volatile SingularAttribute<SadrzajTreninga, Vezba> vezba;
    public static volatile SingularAttribute<SadrzajTreninga, Trening> trening;
    public static volatile SingularAttribute<SadrzajTreninga, Integer> strbrPonavljanja;
    public static volatile SingularAttribute<SadrzajTreninga, SadrzajTreningaPK> sadrzajTreningaPK;
    public static volatile SingularAttribute<SadrzajTreninga, Integer> strbrSerija;
    public static volatile SingularAttribute<SadrzajTreninga, Integer> strTrajanje;

}