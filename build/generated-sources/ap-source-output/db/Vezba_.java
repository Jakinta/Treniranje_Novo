package db;

import db.ElementProgramaVezbanja;
import db.SadrzajTreninga;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-29T17:56:14")
@StaticMetamodel(Vezba.class)
public class Vezba_ { 

    public static volatile SingularAttribute<Vezba, String> vezNaziv;
    public static volatile SingularAttribute<Vezba, Integer> vezAnaerobna;
    public static volatile SingularAttribute<Vezba, String> vezOpis;
    public static volatile SingularAttribute<Vezba, Integer> vezId;
    public static volatile SingularAttribute<Vezba, String> vezSlika;
    public static volatile SetAttribute<Vezba, ElementProgramaVezbanja> elementProgramaVezbanjaSet;
    public static volatile SetAttribute<Vezba, SadrzajTreninga> sadrzajTreningaSet;

}