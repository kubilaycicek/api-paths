package com.kubilaycicek.product.rest;

import com.kubilaycicek.product.model.Operation;
import com.kubilaycicek.product.components.AppPathComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {


    @Autowired
    AppPathComponent appUtil;

    @GetMapping("/getAllApiPaths")
    public List<Operation> getAllApiPaths() {
        return appUtil.getApiPaths();
    }
}
