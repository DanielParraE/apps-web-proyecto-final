package objetosnegocio;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import objetosnegocio.Comentario;
import objetosnegocio.Comun;
import objetosnegocio.Normal;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-10-28T11:41:21")
@StaticMetamodel(Comentario.class)
public class Comentario_ { 

    public static volatile SingularAttribute<Comentario, String> contenido;
    public static volatile SingularAttribute<Comentario, Timestamp> fechaHora;
    public static volatile SingularAttribute<Comentario, Normal> usuarioNormal;
    public static volatile SingularAttribute<Comentario, Integer> id;
    public static volatile SingularAttribute<Comentario, Comun> postComun;
    public static volatile ListAttribute<Comentario, Comentario> comentarios;

}