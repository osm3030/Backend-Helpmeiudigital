package co.edu.iudigital.helpmeuid.service.iface;

import co.edu.iudigital.helpmeuid.dto.UsuarioDto;
import co.edu.iudigital.helpmeuid.exception.RestException;
import co.edu.iudigital.helpmeuid.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    public List<UsuarioDto> findAll() throws RestException;//TODO: Lanzar Excepcion personalizadas

    public UsuarioDto findById(Long id) throws RestException;//TODO: Lanzar Excepcion personalizadas

    public UsuarioDto save(UsuarioDto usuarioDTO) throws RestException;//TODO: Lanzar Excepcion personalizadas

    public Usuario findByUsername(String name);//TODO: Lanzar Excepcion personalizadas
}
