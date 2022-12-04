package co.edu.iudigital.helpmeuid.service.iface;

import co.edu.iudigital.helpmeuid.dto.CasoDto;
import co.edu.iudigital.helpmeuid.exception.RestException;

import java.util.List;

public interface ICasoService {

    // consultar todos los casos
    public List<CasoDto> findAll() throws RestException;//TODO: Lanzar Excepcion personalizadas

    // crear un caso
    public CasoDto save(CasoDto casoDTO) throws RestException;//TODO: Lanzar Excepcion personalizadas

    // activar/inactivar caso
    //TODO: Lanzar Excepcion personalizadas
    public Boolean visible(Boolean visible, Long id) throws RestException;

    // consultar caso por ID
    //TODO: Lanzar Excepcion personalizadas
    public CasoDto findById(Long id) throws RestException;
}
