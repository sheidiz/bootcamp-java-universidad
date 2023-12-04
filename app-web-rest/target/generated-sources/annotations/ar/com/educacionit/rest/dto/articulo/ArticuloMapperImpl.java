package ar.com.educacionit.rest.dto.articulo;

import ar.com.educacionit.bootcamp.Articulo;
import java.io.Serializable;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-04T19:02:36-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230523-1233, environment: Java 17.0.7 (Eclipse Adoptium)"
)
public class ArticuloMapperImpl implements ArticuloMapper {

    @Override
    public ArticuloDTO toArticuloDto(Articulo car) {
        if ( car == null ) {
            return null;
        }

        Long edit = null;
        Integer paginas = null;
        Serializable id = null;
        Long isbn = null;
        String idioma = null;

        edit = car.getEditorial();
        paginas = car.getNroPaginas();
        id = car.getId();
        isbn = car.getIsbn();
        idioma = car.getIdioma();

        ArticuloDTO articuloDTO = new ArticuloDTO( id, edit, isbn, paginas, idioma );

        return articuloDTO;
    }
}
