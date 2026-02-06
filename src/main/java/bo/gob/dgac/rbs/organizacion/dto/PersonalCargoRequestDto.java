package bo.gob.dgac.rbs.organizacion.dto;
import java.util.List;
import lombok.Data;

@Data
public class PersonalCargoRequestDto {
  public Long organizacionId;
  public List<PersonaCargoDto> personaCargo;
}

