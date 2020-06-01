package priv.patrick.order.pojo;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Coffee {
    private Long id;
    private String name;
    private BigDecimal price;
    private LocalDate createTime;
    private LocalDate updateTime;
}
