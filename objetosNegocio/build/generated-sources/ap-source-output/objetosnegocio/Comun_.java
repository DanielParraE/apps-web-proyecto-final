package objetosnegocio;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import objetosnegocio.Comentario;
import objetosnegocio.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-10-28T11:41:21")
@StaticMetamodel(Comun.class)
public class Comun_ extends Post_ {

    public static volatile SingularAttribute<Comun, Usuario> usuario;
    public static volatile ListAttribute<Comun, Comentario> comentarios;

}