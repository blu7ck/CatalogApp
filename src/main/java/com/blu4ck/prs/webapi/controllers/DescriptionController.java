package com.blu4ck.prs.webapi.controllers;

import com.blu4ck.prs.dto.requests.CreateDescriptionRequest;
import com.blu4ck.prs.dto.requests.UpdateDescriptionRequest;
import com.blu4ck.prs.dto.requests.UpdateLanguageRequest;
import com.blu4ck.prs.dto.responses.GetAllDescriptionResponse;
import com.blu4ck.prs.service.abstracts.DescriptionService;
import com.blu4ck.prs.service.concretes.DescriptionManager;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/tech/description")
public class DescriptionController {
    private DescriptionService descriptionService;

    @GetMapping
    public List<GetAllDescriptionResponse> getAll(){
        return descriptionService.getAll();
    }
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateDescriptionRequest createDescriptionRequest){
        this.descriptionService.create(createDescriptionRequest);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody UpdateDescriptionRequest updateDescriptionRequest){
        this.descriptionService.update(updateDescriptionRequest);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        this.descriptionService.delete(id);
    }
}
