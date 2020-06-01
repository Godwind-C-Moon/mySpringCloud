package priv.patrick.order.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Order {
    private Long id;
    private String customer;
    private List<Coffee> items;
    private OrderState state;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
