package bo.gob.dgac.rbs.organizacion.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bo.gob.dgac.rbs.organizacion.dto.TipoOperacionGuardarDto;
import bo.gob.dgac.rbs.organizacion.dto.TipoOperacionItemDto;
import bo.gob.dgac.rbs.organizacion.modelo.Organizacion;
import bo.gob.dgac.rbs.organizacion.modelo.ParamTipoOperacion;
import bo.gob.dgac.rbs.organizacion.modelo.TipoOperacion;
import bo.gob.dgac.rbs.organizacion.repository.TipoOperacionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoOperacionService {

    private final TipoOperacionRepository service;

  
    @Transactional
    public void guardarTipos(TipoOperacionGuardarDto dto) {



        Organizacion org = new Organizacion();
        org.setId(dto.organizacionId);

        List<TipoOperacion> entities = new ArrayList<>();
        
        for(TipoOperacionItemDto items: dto.tipos ) {
        	TipoOperacion  t = new TipoOperacion();
        	t.setOrganizacion(org);
        	ParamTipoOperacion pto=new ParamTipoOperacion();
        	pto.setId(items.tipoOperacionId);
        	//t.setTipoOperacionId(pto);
        	t.setTipoOperacion(pto);
            entities.add(t);
        	
        	
        }
        service.saveAll(entities);        
        


    }
/*
    @Transactional(readOnly = true)
    public List<TipoOperacionDto> listarPorOrganizacion(Long organizacionId) {
        return repo.findByOrganizacionId(organizacionId).stream().map(e -> {
            TipoOperacionDto d = new TipoOperacionDto();
            d.setId(e.getId());
            d.setTipoOperacionId(e.getTipoOperacionId());
            d.setDescripcion(e.getDescripcion());
            return d;
        }).toList();
    }*/
}
