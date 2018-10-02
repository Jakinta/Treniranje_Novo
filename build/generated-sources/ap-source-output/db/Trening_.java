package db;

import db.Posetilac;
import db.SadrzajTreninga;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-29T17:56:14")
@StaticMetamodel(Trening.class)
public class Trening_ { 

    public static volatile SingularAttribute<Trening, Integer> treIzdrzljivost;
    public static volatile SingularAttribute<Trening, Integer> treTrajanje;
    public static volatile SingularAttribute<Trening, Posetilac> posId;
    public static volatile SingularAttribute<Trening, Integer> trePuls;
    public static volatile SingularAttribute<Trening, Integer> treId;
    public static volatile SingularAttribute<Trening, Date> treDatum;
    public static volatile SetAttribute<Trening, SadrzajTreninga> sadrzajTreningaSet;

}