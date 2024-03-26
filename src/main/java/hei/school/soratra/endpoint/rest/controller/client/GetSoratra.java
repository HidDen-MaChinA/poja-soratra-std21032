package hei.school.soratra.endpoint.rest.controller.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetSoratra {
    private String original_url;
    private String transformed_url;
}
