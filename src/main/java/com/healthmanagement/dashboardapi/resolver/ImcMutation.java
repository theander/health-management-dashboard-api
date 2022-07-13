package com.healthmanagement.dashboardapi.resolver;


import com.healthmanagement.dashboardapi.model.Imc;
import com.healthmanagement.dashboardapi.service.ImcService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class ImcMutation implements GraphQLMutationResolver {
    private final ImcService imcService;

    public ImcMutation(ImcService imcService) {
        this.imcService = imcService;
    }


    public Imc createImc(String name) {
        Imc imc = new Imc();
        imc.setId("asd");
        imc.setPeso(455f);
        imc.setAltura(654f);
        return imcService.create(imc);
    }


}
