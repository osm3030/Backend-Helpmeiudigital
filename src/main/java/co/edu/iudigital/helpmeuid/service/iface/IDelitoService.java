package co.edu.iudigital.helpmeuid.service.iface;

import co.edu.iudigital.helpmeuid.dto.DelitoDto;
import co.edu.iudigital.helpmeuid.exception.RestException;

import java.util.List;

public interface IDelitoService {

    // listar todos los delitos
    public List<DelitoDto> findAll() throws RestException;//TODO: Lanzar Excepcion personalizadas

    // listar un delito por ID
    public DelitoDto findById(Long id) throws RestException;//TODO: Lanzar Excepcion personalizadas

    // guardar un delito
    public DelitoDto save(DelitoDto delitoDTO) throws RestException;//TODO: Lanzar Excepcion personalizadas

    // borrar un delito por ID
    public void delete(Long id);//TODO: Lanzar Excepcion personalizadas
}
