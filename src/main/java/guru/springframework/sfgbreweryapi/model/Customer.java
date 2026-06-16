package guru.springframework.sfgbreweryapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private UUID id;
    private Integer version;

    private String customerName;
    private String email;
    private String phoneNumber;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}