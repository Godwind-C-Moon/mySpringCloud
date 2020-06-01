package priv.patrick.product.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@TableName("t_coffee")
public class Coffee {
    private Long id;
    private String name;
    private BigDecimal price;
    private LocalDate createTime;
    private LocalDate updateTime;
}
