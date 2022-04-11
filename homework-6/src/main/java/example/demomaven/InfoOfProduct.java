package example.demomaven;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class InfoOfProduct {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Integer id;
}
