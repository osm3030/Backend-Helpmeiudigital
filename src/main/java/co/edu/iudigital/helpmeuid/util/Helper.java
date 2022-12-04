package co.edu.iudigital.helpmeuid.util;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.iudigital.helpmeuid.dto.UsuarioDto;
import co.edu.iudigital.helpmeuid.model.Usuario;


/**
 * Utilidad o Helper para métodos transversales en la aplicación
 * @author Oscar Mantilla
 */
public interface Helper {


    public static void setMapValuesClient(List<Usuario> usuarios, List<UsuarioDto> usuariosDto){
        usuarios.stream().map(usuario -> {
            UsuarioDto cDto = getMapValuesClient(usuario);
            return cDto;
        }).forEach(cDto -> {
            usuariosDto.add(cDto);
        });
    }

    public static UsuarioDto getMapValuesClient(Usuario usuario){
        UsuarioDto uDto = new UsuarioDto();
        uDto.setId(usuario.getId());
        uDto.setNombre(usuario.getNombre());
        uDto.setApellido(usuario.getApellido());
        uDto.setFechaNacimiento(usuario.getFechaNacimiento());
        uDto.setImage(usuario.getImage());
        uDto.setRoles(usuario.getRoles()
                .stream().map(r -> r.getNombre())
                .collect(Collectors.toList())
        );
        uDto.setUsername(usuario.getUsername());

        return uDto;
    }}
