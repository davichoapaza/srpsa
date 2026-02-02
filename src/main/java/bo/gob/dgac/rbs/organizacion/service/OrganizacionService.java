package bo.gob.dgac.rbs.organizacion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bo.gob.dgac.rbs.organizacion.dto.OrganizacionCreacionDto;
import bo.gob.dgac.rbs.organizacion.dto.OrganizacionDTO;
import bo.gob.dgac.rbs.organizacion.dto.OrganizacionDetalleDTO;
import bo.gob.dgac.rbs.organizacion.mapper.OrganizacionMapper;
import bo.gob.dgac.rbs.organizacion.modelo.Organizacion;
import bo.gob.dgac.rbs.organizacion.repository.OrganizacionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrganizacionService  {

    private final OrganizacionRepository repository;
    private final OrganizacionMapper mapper;
    
    public List<OrganizacionDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    
    public OrganizacionDTO obtenerPorId(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrado")));
    }

    
    public OrganizacionDTO guardar(OrganizacionDTO dto) {
        return mapper.toDto(
                repository.save(mapper.toEntity(dto))
        );
    }

    
    public OrganizacionDTO actualizar(Long id, OrganizacionDTO dto) {
        Organizacion entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }
    
    
    /*
    public OrganizacionDetalleDTO obtenerConUbicaciones(Long id) {

        Organizacion org = repository.findByIdConUbicaciones(id)
                .orElseThrow(() -> new RuntimeException("No encontrada"));

        return mapper.toDetalleDto(org);
    }*/
   
    /*@Transactional
    public Organizacion crear(OrganizacionCreacionDto dto) {
        Organizacion o = new Organizacion();
        o.setNombreOrganizacion(dto.nombreOrganizacion);
        o.setTipoOrganizacionId(dto.paramTipoOrganizacionId);
        o.setFechaCertificacionInicial(dto.fechaCertificacionInicial);
        o.setFechaCertificacionExpiracion(dto.fechaCertificacionExpiracion);
        o.setNumeroCertificadoDgac(dto.numeroCertificadoDgac);
        o.setNumeroResolucionAdministrativaDgac(dto.numeroResolucionAdministrativaDgac);
        o.setParamClaseCertificacionId(dto.paramClaseCertificacionId);
        o.setOtraResolucionClaseCertificacion(dto.otraResolucionClaseCertificacion);
        o.setTieneSms(dto.tieneSms);
        o.setFechaAceptacionInicialSms(dto.fechaAceptacionInicialSms);
        o.setParamNacionalidadId(dto.paramNacionalidadId);
        o.setParamTamanoOrganizacionId(dto.paramTamanoOrganizacionId);
        o.setParamComplejidadOrganizacionId(dto.paramComplejidadOrganizacionId);
        o.setEstadoRegistro(dto.estadoRegistro);
        o.setUsuarioCreado(dto.usuarioCreado);
        o.setRutaFile(dto.rutaFile);

        if (dto.ubicaciones != null) {
            for (UbicacionCreacionDto u : dto.ubicaciones) {
                Ubicacion ub = new Ubicacion();
                ub.setDepartamentoId(u.departamentoId);
                ub.setDireccion(u.direccion);
                ub.setTelefono(u.telefono);
                ub.setCorreo(u.correo);
                o.addUbicacion(ub);
            }
        }

        return repository.save(o);
    }*/
    
    //@Transactional
   public Organizacion crear(OrganizacionCreacionDto dto) {
	   
	   
        Organizacion entity = mapper.toEntity(dto);
        return repository.save(entity);
    }
    
/*
    public OrganizacionResponseDto obtenerArbol(Long organizacionId) {

        Organizacion org = repository.findArbolById(organizacionId)
                .orElseThrow(() -> new RuntimeException("No existe organización"));

        OrganizacionResponseDto dto = new OrganizacionResponseDto();
        
        dto.id=org.getId();
        dto.nombreOrganizacion=org.getNombreOrganizacion();

        for (Objetivos o : org.getObjetivos()) {

            ObjetivosDto oDto = new ObjetivosDto();
            
            //oDto.id = o.getId();
            oDto.nombre= o.getNombre();
            oDto.descripcion= o.getDescripcion();

            for (Metas m : o.getMetas()) {

                MetaDto mDto = new MetaDto();
                //mDto.setId(m.getId());
                mDto.setNombre(m.getNombre());
                mDto.setDescripcion(m.getDescripcion());

                for (Indicador i : m.getIndicador()) {

                    IndicadorDto iDto = new IndicadorDto();
                    //iDto.setId(i.getId());
                    
                    iDto.periodicidadId=i.getPeriodicidad().getId();
                    iDto.formula=iDto.getFormula();
                    iDto.nivelAlerta1=iDto.getNivelAlerta1();
                    iDto.nivelAlerta2=iDto.getNivelAlerta2();
                    iDto.nivelAlerta3= iDto.getNivelAlerta3();

                    if (i.getTipoIndicador() != null) {
                        
                        iDto.TipoIndicadorId=i.getTipoIndicador().getId();
                        //iDto.setTipoIndicadorNombre(i.getTipoIndicador().getNombreIndicador());
                        
                    }

                    mDto.getIndicadores().add(iDto);
                }

                oDto.metas.add(mDto);
            }

//            dto.getObjetivos().add(oDto);
            dto.objetivos.add(oDto);
        }

        return dto;
    }*/
    
     
}

/*
import java.util.List;
import org.springframework.stereotype.Service;
import bo.gob.dgac.rbs.organizacion.modelo.Organizacion;
import bo.gob.dgac.rbs.organizacion.repository.OrganizacionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrganizacionService {

    private final OrganizacionRepository repository;

    public List<Organizacion> listarTodos() {
        return repository.findAll();
    }

    public Organizacion obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Organización no encontrada con ID: " + id));
    }

    
    public Organizacion guardar(Organizacion organizacion) {
        return repository.save(organizacion);
    }

    
    public Organizacion actualizar(Long id, Organizacion organizacion) {

        Organizacion existente = obtenerPorId(id);

        existente.setNombreOrganizacion(organizacion.getNombreOrganizacion());
        existente.setTipoOrganizacion(organizacion.getTipoOrganizacion());
        existente.setClaseCertificacion(organizacion.getClaseCertificacion());
        existente.setNacionalidad(organizacion.getNacionalidad());
        existente.setTamanoOrganizacion(organizacion.getTamanoOrganizacion());
        existente.setComplejidadOrganizacion(organizacion.getComplejidadOrganizacion());

        existente.setFechaCertificacionInicial(organizacion.getFechaCertificacionInicial());
        existente.setFechaCertificacionExpiracion(organizacion.getFechaCertificacionExpiracion());
        existente.setNumeroCertificadoDgac(organizacion.getNumeroCertificadoDgac());
        existente.setNumeroResolucionAdministrativaDgac(organizacion.getNumeroResolucionAdministrativaDgac());
        existente.setOtraResolucionClaseCertificacion(organizacion.getOtraResolucionClaseCertificacion());

        existente.setTieneSms(organizacion.getTieneSms());
        existente.setFechaAceptacionInicialSms(organizacion.getFechaAceptacionInicialSms());

        existente.setEstadoRegistro(organizacion.getEstadoRegistro());
        existente.setRutaFile(organizacion.getRutaFile());

        return repository.save(existente);
    }

    
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
*/